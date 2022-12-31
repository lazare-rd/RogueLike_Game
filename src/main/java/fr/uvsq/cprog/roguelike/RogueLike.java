package fr.uvsq.cprog.roguelike;

import fr.uvsq.cprog.roguelike.UI.UserInterface;
import fr.uvsq.cprog.roguelike.Entities.Cursor;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

import fr.uvsq.cprog.roguelike.Commandes.*;

public class RogueLike {
    private UserInterface ui ;
    private Board board ;
    private Cursor cursor ;
    private String[] fileNames ;
    
    public RogueLike() {
        this.ui = new UserInterface();
        this.cursor = new Cursor(35, 17);
        this.fileNames = this.ui.getNamesOfSavedGames();
    }

    public Cursor getCursor() {
        return this.cursor ;
    } 

    public Commande processInput(KeyEvent event) {
        switch(event.getKeyCode()) {
            case KeyEvent.VK_ENTER :
                this.board = Board.deserialize(getFileSelected());
                return new InitGame(this.board);
            case KeyEvent.VK_Q :
                return new Quit();
            case KeyEvent.VK_UP :
                return new MoveUpCursor(this.cursor, getFileNamesWidth(this.fileNames));
            case KeyEvent.VK_DOWN :
                return new MoveDownCursor(this.cursor, getFileNamesWidth(this.fileNames));
            default :
                return new NullCommande();
        }
    }

    private int[] getFileNamesWidth(String[] f) {
        int[] widths = new int[f.length];
        for (int i = 0 ; i < f.length ; i++) {
            widths[i] = f[i].length() + 27;
        }
        return widths ;
    }

    private String getFileSelected() {
        return fileNames[cursor.getPos().getY() - 17];
    }

    public void run() {
        boolean loop = true ;
        this.ui.drawWelcome();
        this.ui.showUi();
        while (loop) {
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
            long sleepTime = Board.timePerFrame - (timeAfterFrame - timeBeforeFrame) ;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void render() {
        ui.drawFig(this.cursor);
        this.ui.getTerminal().write(' ', UserInterface.pixelsInWidth + 10, 3);
        ui.repaint();
    }

    private void preRender() {
        ui.clearFig(this.cursor);
    }
}
