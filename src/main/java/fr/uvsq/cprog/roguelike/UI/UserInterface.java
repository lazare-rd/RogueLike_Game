package fr.uvsq.cprog.roguelike.UI;

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import asciiPanel.AsciiPanel;
import fr.uvsq.cprog.roguelike.Entities.PJ;
import fr.uvsq.cprog.roguelike.World.World;
import java.awt.Color;

import java.awt.Dimension ;
import java.awt.Toolkit;

public class UserInterface extends JFrame implements KeyListener{
    private Queue<KeyEvent> inputQueue ;
    private AsciiPanel terminal;

    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int pixelsInHeight = 48;
    public static final int pixelsInWidth = 104;

    public UserInterface(){
        super("Roguelike");

        this.inputQueue = new LinkedList<>() ;

        this.terminal = new AsciiPanel(pixelsInWidth, pixelsInHeight);
        this.add(terminal) ;
        this.setSize(dimension);
        super.addKeyListener(this);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public AsciiPanel getTerminal(){
        return this.terminal ;
    }

    public void drawPJ(PJ player){
        this.terminal.write(player.getGlyph(), player.getPos().getX(), player.getPos().getY(), player.getColor());
    }

    public void drawWorld(World world){
        char[][] grid = world.generateCharGrid() ;
        for(int x = 0 ; x < pixelsInWidth ; x++){
            for (int y = 0 ; y < pixelsInHeight ; y++){
                this.terminal.write(grid[x][y], x, y, Color.WHITE);
            }
        }
    }

    public void clear(){
        this.terminal.clear() ;
    }

    public void clearPJ(PJ perso){
        this.terminal.clear(' ', perso.getPos().getX(), perso.getPos().getY(), 1, 1) ;
    }

    public void repaint(){
        this.terminal.repaint();
    }

    public KeyEvent getNextInput(){
        return inputQueue.remove() ;
    }

    public void showUi(){
        this.setVisible(true);
    }

    public void addEventInQueue(KeyEvent e){
        inputQueue.add(e) ;
    }

    @Override
    public void keyPressed(KeyEvent e){
        inputQueue.add(e) ;
    }

    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyTyped(KeyEvent e){}

}
