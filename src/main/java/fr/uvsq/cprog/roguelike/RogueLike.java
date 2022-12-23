package fr.uvsq.cprog.roguelike;

import java.awt.Color;
import java.awt.event.KeyEvent ;
import java.util.NoSuchElementException;

import fr.uvsq.cprog.roguelike.Commandes.* ;
import fr.uvsq.cprog.roguelike.Entities.PJ;
import fr.uvsq.cprog.roguelike.UI.UserInterface;
import fr.uvsq.cprog.roguelike.World.World;

public class RogueLike {
    private PJ player ; 
    private UserInterface ui ;
    private World world ;

    private final long timePerFrame = 8333333 ;

    public RogueLike(){
        this.player = new PJ(1, 1, '@', Color.RED);
        this.ui = new UserInterface() ;
        this.world = new World(0);
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

    public Commande processInput(KeyEvent event){
        switch(event.getKeyCode()){
            case KeyEvent.VK_LEFT :
                return new MoveLeft(this.player, this.world);
            case KeyEvent.VK_RIGHT :
                return new MoveRight(this.player, this.world);
            case KeyEvent.VK_UP :
                return new MoveUp(this.player, this.world);
            case KeyEvent.VK_DOWN :
                return new MoveDown(this.player, this.world);
            case KeyEvent.VK_Q : 
                return new Quit();
            case KeyEvent.VK_SPACE:
                return new Shoot();
            default :
                return new NullCommande() ;
            }
    }

    public void preRender(){
        ui.clearPJ(this.player);
    }

    public void render(){
        ui.drawPJ(this.player);
        ui.repaint();
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
}
