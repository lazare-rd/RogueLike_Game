package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color;
import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

/**
 * The Door symbolized by a blue D, is the entry point of the next level
 * @author lazare-rd
 * @version 01/01/2023
 */
public class Door extends Entity{
    
    public Door(int x, int y) {
        try {
            super.color = Color.CYAN ;
            super.glyph = 'D' ;
            super.position = new Position(x, y) ;
        } catch (IllegalPositionException e) {
           e.printStackTrace();
        }
    }
}
