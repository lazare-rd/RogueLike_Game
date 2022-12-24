package fr.uvsq.cprog.roguelike.UI;

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import asciiPanel.AsciiCharacterData;
import asciiPanel.AsciiPanel;
import fr.uvsq.cprog.roguelike.Entities.Figure;
import fr.uvsq.cprog.roguelike.World.World;
import java.awt.Color ;

import java.awt.Dimension ;
import java.awt.Toolkit;

public class UserInterface extends JFrame implements KeyListener{
    private Queue<KeyEvent> inputQueue ;
    private AsciiPanel terminal;

    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int pixelsInHeight = 48;
    public static final int pixelsInWidth = 104;
    public static final int pixelsInRoomHeight = (int)(pixelsInHeight/6) ;
    public static final int pixelsInRoomWidth = (int)(pixelsInWidth/8) ;

    public UserInterface(){
        super("Roguelike");

        this.inputQueue = new LinkedList<>() ;

        this.terminal = new AsciiPanel(pixelsInWidth + 30, pixelsInHeight);
        this.add(terminal) ;
        this.setSize(dimension);
        super.addKeyListener(this);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public AsciiPanel getTerminal(){
        return this.terminal ;
    }

    public void drawFig(Figure player){
        this.terminal.write(player.getGlyph(), player.getPos().getX(), player.getPos().getY(), player.getColor());
        for (int i=0 ; i<player.getLifePoints()*2 ; i+=2){
            this.terminal.write('<', pixelsInWidth + 10 + i, 1, Color.RED);
            this.terminal.write('3', pixelsInWidth + 11 + i, 1, Color.RED);
        }
        this.terminal.write(String.valueOf(player.getCoins()), pixelsInWidth + 10 , 3, Color.YELLOW);
    } 

    public void drawWorld(World world){
        AsciiCharacterData[][] grid = world.generateCharGrid() ;
        for(int x = 0 ; x < pixelsInWidth ; x++){
            for (int y = 0 ; y < pixelsInHeight ; y++){
                this.terminal.write(grid[x][y].character, x, y, grid[x][y].foregroundColor);
            }
        }
        char[] lives = {' ', 'L', 'I', 'V', 'E', 'S', ' ', ':', ' '};
        char[] coins = {' ', 'C', 'O', 'I', 'N', 'S', ' ', ':', ' '};
        char[] level = {' ', 'L', 'E', 'V', 'E', 'L', ' ', ':', ' '};
        for (int i = 0; i<lives.length ; i++){
            this.terminal.write(lives[i], pixelsInWidth + 1 + i , 1, Color.RED);
        }
        for (int i = 0; i<coins.length ; i++){
            this.terminal.write(coins[i], pixelsInWidth + 1 + i , 3, Color.YELLOW);
        }
        for (int i = 0; i<level.length ; i++){
            this.terminal.write(level[i], pixelsInWidth + 1 + i , 5, Color.CYAN);
        }
        this.terminal.write(String.valueOf(world.getLevel()), pixelsInWidth + 10, 5, Color.CYAN);
    }

    public void clear(){
        this.terminal.clear() ;
    }

    public void clearFig(Figure player){
        this.terminal.clear(' ', player.getPos().getX(), player.getPos().getY(), 1, 1) ;
        this.terminal.clear(' ', pixelsInWidth + 9, 1, 15, 1);
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
