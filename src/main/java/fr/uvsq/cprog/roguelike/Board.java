package fr.uvsq.cprog.roguelike;

import java.awt.Color;
import java.awt.event.KeyEvent ;
import java.io.Serializable;
import java.util.NoSuchElementException;

import fr.uvsq.cprog.roguelike.Commandes.* ;
import fr.uvsq.cprog.roguelike.Entities.PJ;
import fr.uvsq.cprog.roguelike.UI.UserInterface;
import fr.uvsq.cprog.roguelike.World.World;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Board implements Serializable{
    private PJ player ; 
    private transient UserInterface ui ;
    private World world ;
    private String name ;

    public static final long timePerFrame = 8333333 ;

    
    public Board(){
        this.player = new PJ(1, 1, '@', Color.RED);
        this.ui = new UserInterface() ;
        this.world = new World(0);
    }

    public void updateGame(){
        int coins = this.player.getCoins();
        int lives = this.player.getLifePoints() ;
        
        this.player = new PJ(1, 1, '@', Color.RED);
        this.player.setCoins(coins);
        this.player.setLifePoints(lives);

        this.ui = new UserInterface() ;
        this.world = new World(this.world.getLevel() + 1);
    }

    public UserInterface getUi(){
        return this.ui ;
    }

    public PJ getPJ(){
        return this.player ;
    }

    public World getWorld(){
        return this.world ;
    }

    public String getName(){
        return this.name ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public void setUI(){
        this.ui = new UserInterface();
    }

    public void serialize(String fileName){
        try {
            FileOutputStream fout = new FileOutputStream("savedGames/" + fileName + ".rgl");    
            ObjectOutputStream out = new ObjectOutputStream(fout);    
            out.writeObject(this);    
            out.flush();        
            out.close();    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Board deserialize(String fileName){
        Board board = null;
        try {
            FileInputStream fin = new FileInputStream("savedGames/" + fileName);    
            ObjectInputStream in = new ObjectInputStream(fin);    
            board = (Board) in.readObject() ;
            board.setUI();
            in.close();
            fin.close(); 
        } catch (FileNotFoundException f){
            return new Board();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        return board ;
    }

    public void run(){
        boolean loop = true ;
        this.ui.drawWorld(this.world);
        this.ui.showUi();
        while(loop){
            long timeBeforeFrame = System.nanoTime() ;
            try {
                this.preRender();
                KeyEvent event = this.ui.getNextInput();
                Commande commande = this.processInput(event);
                commande.execute();
                this.render();
            } catch (NoSuchElementException e) {
                this.render();
            }
            long timeAfterFrame = System.nanoTime() ;
            long sleepTime = timePerFrame - (timeAfterFrame - timeBeforeFrame) ;
            if (sleepTime > 0){
                try {
                    Thread.sleep(sleepTime / 100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Commande processInput(KeyEvent event){
        switch(event.getKeyCode()){
            case KeyEvent.VK_LEFT :
                return new MoveLeft(this);
            case KeyEvent.VK_RIGHT :
                return new MoveRight(this);
            case KeyEvent.VK_UP :
                return new MoveUp(this);
            case KeyEvent.VK_DOWN :
                return new MoveDown(this);
            case KeyEvent.VK_Q : 
                return new Quit();
            case KeyEvent.VK_SPACE:
                return new Shoot();
            case KeyEvent.VK_S:
                return new Save(this);
            default :
                return new NullCommande() ;
            }
    }

    private void preRender(){
        ui.clearFig(this.player);
    }

    private void render(){
        ui.drawFig(this.player);
        ui.repaint();
    }

}
