package fr.uvsq.cprog.roguelike.Entities;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import java.awt.Color;

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
