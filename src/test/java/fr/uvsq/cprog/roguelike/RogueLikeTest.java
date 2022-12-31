package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import fr.uvsq.cprog.roguelike.Commandes.InitGame;
import fr.uvsq.cprog.roguelike.Commandes.MoveDownCursor;
import fr.uvsq.cprog.roguelike.Commandes.MoveUpCursor;
import fr.uvsq.cprog.roguelike.Commandes.NullCommande;
import fr.uvsq.cprog.roguelike.Commandes.Quit;

import java.awt.Button;
import java.awt.event.KeyEvent;

public class RogueLikeTest {

    @Test
    public void processInputTest() {
        RogueLike rg = new RogueLike();
        Button a = new Button() ;
        long time = System.currentTimeMillis() ;

        KeyEvent eventEnter = new KeyEvent(a, 1, time, 1, KeyEvent.VK_ENTER, 'e');
        KeyEvent eventQuit = new KeyEvent(a, 1, time, 1, KeyEvent.VK_Q, 'q');
        KeyEvent eventUp = new KeyEvent(a, 1, time, 1, KeyEvent.VK_UP, 'z');
        KeyEvent eventDown = new KeyEvent(a, 1, time, 1, KeyEvent.VK_DOWN, 's');
        KeyEvent eventNull = new KeyEvent(a, 1, time, 1, KeyEvent.VK_W, 'w');


        assert(rg.processInput(eventEnter) instanceof InitGame);
        assert(rg.processInput(eventQuit) instanceof Quit);
        assert(rg.processInput(eventDown) instanceof MoveDownCursor);
        assert(rg.processInput(eventUp) instanceof MoveUpCursor);
        assert(rg.processInput(eventNull) instanceof NullCommande);
    }
}
