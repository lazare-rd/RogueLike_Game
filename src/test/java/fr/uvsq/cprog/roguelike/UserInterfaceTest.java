package fr.uvsq.cprog.roguelike;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Button;

import org.junit.Test;

import asciiPanel.AsciiPanel;
import fr.uvsq.cprog.roguelike.Entities.PJ;
import fr.uvsq.cprog.roguelike.UI.UserInterface;
import asciiPanel.AsciiCharacterData;
import fr.uvsq.cprog.roguelike.world.World;

import java.util.NoSuchElementException;

public class UserInterfaceTest {
    private UserInterface ui = new UserInterface();

    private PJ player = new PJ(0, 0, '@', Color.WHITE);
    private AsciiCharacterData expectedGlyph = new AsciiCharacterData('@', Color.WHITE, null);

    private long time = System.currentTimeMillis() ;
    private Button a = new Button() ;
    private KeyEvent expectedEvent = new KeyEvent(a, 1, time, 1, KeyEvent.VK_LEFT, 'q');


    @Test 
    public void isConstructorInstanciated() {
        new UserInterface() ;
    }

    @Test
    public void getTerminalTest() {
        assert(ui.getTerminal() instanceof AsciiPanel);
    }

    @Test
    public void drawPjTest() {
        ui.drawFig(player);
        AsciiPanel panel = ui.getTerminal() ;
        AsciiCharacterData[][] characters = panel.getCharacters() ;

        assert(characters[0][0].character == expectedGlyph.character) ;
        assert(characters[0][0].foregroundColor == expectedGlyph.foregroundColor) ;
    }

    @Test
    public void drawWorldTest() {
        World world = new World(0);
        AsciiCharacterData[][] expectedCharacters = world.generateCharGrid();
        ui.drawWorld(world);
        AsciiPanel panel = ui.getTerminal() ;
        AsciiCharacterData[][] characters = panel.getCharacters() ;

        for (int i = 0 ; i < expectedCharacters.length ; i++) {
            for (int j = 0 ; j < expectedCharacters[0].length ; j++) {
                assert(characters[i][j].character == expectedCharacters[i][j].character);
                assert(characters[i][j].foregroundColor == expectedCharacters[i][j].foregroundColor);
            }
        }
    }

    @Test
    public void drawingUITest() {
        ui.drawWelcome();
        ui.drawDeadScreen();
    }

    @Test(expected = NoSuchElementException.class)
    public void getNextInputTestException() {
        ui.getNextInput();
    }

    @Test
    public void getNextInputTest() {
        ui.addEventInQueue(expectedEvent);
        assert(ui.getNextInput().equals(expectedEvent));
    }
}
