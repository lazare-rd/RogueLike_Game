package fr.uvsq.cprog.roguelike;

import java.awt.Color;
import java.awt.event.KeyEvent ;
import java.awt.Button;

import org.junit.Test;

import asciiPanel.AsciiPanel;
import fr.uvsq.cprog.roguelike.Entities.PJ;
import fr.uvsq.cprog.roguelike.UI.UserInterface;
import asciiPanel.AsciiCharacterData ;

import java.util.NoSuchElementException;

public class UserInterfaceTest {
    private UserInterface ui = new UserInterface();

    private PJ player = new PJ(0, 0, '@', Color.WHITE);
    private AsciiCharacterData expectedGlyph = new AsciiCharacterData('@', Color.WHITE, null);

    private long time = System.currentTimeMillis() ;
    private Button a = new Button() ;
    private KeyEvent expectedEvent = new KeyEvent(a, 1, time, 1, KeyEvent.VK_LEFT, 'q');


    @Test 
    public void isConstructorInstanciated(){
        new UserInterface() ;
    }

    @Test
    public void getTerminalTest(){
        assert(ui.getTerminal() instanceof AsciiPanel);
    }

    @Test
    public void drawPjTest(){
        ui.drawFig(player);
        AsciiPanel panel = ui.getTerminal() ;
        AsciiCharacterData[][] characters = panel.getCharacters() ;

        assert(characters[0][0].character == expectedGlyph.character) ;
        assert(characters[0][0].foregroundColor == expectedGlyph.foregroundColor) ;
    }

    @Test (expected = NoSuchElementException.class)
    public void getNextInputTestException(){
        ui.getNextInput();
    }

    @Test
    public void getNextInputTest(){
        ui.addEventInQueue(expectedEvent);
        assert(ui.getNextInput().equals(expectedEvent));
    }
}
