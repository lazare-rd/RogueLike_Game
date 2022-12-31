package fr.uvsq.cprog.roguelike;
import org.junit.Test;
import fr.uvsq.cprog.roguelike.Commandes.*;
import fr.uvsq.cprog.roguelike.Entities.PJ;
import fr.uvsq.cprog.roguelike.UI.UserInterface;
import fr.uvsq.cprog.roguelike.world.World;
import java.io.File;

import java.awt.Button;
import java.awt.event.KeyEvent;

public class BoardTest {
    
    @Test
    public void isConstructorInstanciated() {
        new Board() ;
    }

    @Test
    public void GettersTest() {
        Board rg = new Board();
        assert(rg.getUi() instanceof UserInterface);
        assert(rg.getPJ() instanceof PJ) ;
        assert(rg.getWorld() instanceof World);
    }

    @Test
    public void NameTest() {
        Board rg = new Board();
        rg.setName("Board");
        assert(rg.getName() == "Board");
    }

    @Test
    public void ProcessInputTest() { 
        Board rg = new Board();
        Button a = new Button() ;
        long time = System.currentTimeMillis() ;

        KeyEvent eventLeft = new KeyEvent(a, 1, time, 1, KeyEvent.VK_LEFT, 'q');
        KeyEvent eventRight = new KeyEvent(a, 1, time, 1, KeyEvent.VK_RIGHT, 'd');
        KeyEvent eventUp = new KeyEvent(a, 1, time, 1, KeyEvent.VK_UP, 'z');
        KeyEvent eventDown = new KeyEvent(a, 1, time, 1, KeyEvent.VK_DOWN, 's');
        KeyEvent eventNull = new KeyEvent(a, 1, time, 1, KeyEvent.VK_V, 'v');
        KeyEvent eventQuit = new KeyEvent(a, 1, time, 1, KeyEvent.VK_Q, 'q');
        KeyEvent eventSave = new KeyEvent(a, 1, time, 1, KeyEvent.VK_S, 's');

        assert(rg.processInput(eventLeft) instanceof MoveLeft) ;
        assert(rg.processInput(eventRight) instanceof MoveRight) ;
        assert(rg.processInput(eventUp) instanceof MoveUp) ;
        assert(rg.processInput(eventDown) instanceof MoveDown) ;
        assert(rg.processInput(eventNull) instanceof NullCommande) ;
        assert(rg.processInput(eventQuit) instanceof Quit);
        assert(rg.processInput(eventSave) instanceof Save);
    }

    @Test
    public void searializeDeserializeTest() {
        Board b1 = new Board();
        b1.serialize("testGame");
        Board b2 = Board.deserialize("testGame.rgl");
        assert(b1.equals(b2));
        File file = new File("savedGames/testGame.rgl");
        file.delete();
    }
}
