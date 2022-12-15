package fr.uvsq.cprog.roguelike;
import org.junit.Test;
import fr.uvsq.cprog.roguelike.Commandes.*;
import java.awt.Button ;
import java.awt.event.KeyEvent ;

public class RogueLikeTest {
    
    @Test
    public void isConstructorInstanciated(){
        new RogueLike() ;
    }

    @Test
    public void GetUiTest(){
        RogueLike rg = new RogueLike();
        assert(rg.getUi() instanceof UserInterface);
    }

    @Test
    public void GetPJTest(){
        RogueLike rg = new RogueLike();
        assert(rg.getPJ() instanceof PJ) ;
    }

    @Test
    public void ProcessInputTest(){ 
        RogueLike rg = new RogueLike();
        Button a = new Button() ;
        long time = System.currentTimeMillis() ;

        KeyEvent eventLeft = new KeyEvent(a, 1, time, 1, KeyEvent.VK_LEFT, 'q');
        KeyEvent eventRight = new KeyEvent(a, 1, time, 1, KeyEvent.VK_RIGHT, 'd');
        KeyEvent eventUp = new KeyEvent(a, 1, time, 1, KeyEvent.VK_UP, 'z');
        KeyEvent eventDown = new KeyEvent(a, 1, time, 1, KeyEvent.VK_DOWN, 's');
        KeyEvent eventNull = new KeyEvent(a, 1, time, 1, KeyEvent.VK_V, 'v');


        assert(rg.processInput(eventLeft) instanceof MoveLeft) ;
        assert(rg.processInput(eventRight) instanceof MoveRight) ;
        assert(rg.processInput(eventUp) instanceof MoveUp) ;
        assert(rg.processInput(eventDown) instanceof MoveDown) ;
        assert(rg.processInput(eventNull) instanceof NullCommande) ;
    }
}