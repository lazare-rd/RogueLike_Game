package fr.uvsq.cprog.roguelike.Entities;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import java.awt.Color;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class Coin extends Entity{
    public Coin(int x, int y) {
        try {
            super.color = Color.YELLOW ;
            super.glyph = 'O' ;
            super.position = new Position(x, y) ;
        } catch (IllegalPositionException e) {
           e.printStackTrace();
        }
    }
}
