package fr.uvsq.cprog.roguelike.UI;

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import asciiPanel.AsciiPanel;
import fr.uvsq.cprog.roguelike.Entities.PJ;

import java.awt.Dimension ;
import java.awt.Toolkit;

public class UserInterface extends JFrame implements KeyListener{
    private Queue<KeyEvent> inputQueue ;
    private AsciiPanel terminal;

    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    private final double pixelHeight = 0.058 ;
    private final double pixelWidth = 0.11 ;
    private final int screenHeight = (int)dimension.getHeight() ;
    private final int screenWidth = (int)dimension.getWidth() ;
    private final int pixelsInHeight = (int)(pixelHeight*screenHeight);
    private final int pixelsInWidth = (int)(pixelWidth*screenWidth);

    public UserInterface(){
        super("Roguelike");

        this.inputQueue = new LinkedList<>() ;

        this.terminal = new AsciiPanel(pixelsInWidth, pixelsInHeight);
        this.add(terminal) ;
        this.setSize(dimension);
        super.addKeyListener(this);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Position.setBounds(pixelsInWidth, pixelsInHeight);
    }

    public AsciiPanel getTerminal(){
        return this.terminal ;
    }

    public void drawPJ(PJ player){
        this.terminal.write(player.getGlyph(), player.getPos().getX(), player.getPos().getY(), player.getColor());
    }

    public void clear(){
        this.terminal.clear() ;
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
