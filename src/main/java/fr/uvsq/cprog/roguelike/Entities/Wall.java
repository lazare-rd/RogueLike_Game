package fr.uvsq.cprog.roguelike.Entities;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;
import java.awt.Color;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class Wall extends Entity{ 

    public Wall(int x, int y) {
        try {
            super.color = Color.WHITE ;
            super.glyph = '#' ;
            super.position = new Position(x, y) ;
        } catch (IllegalPositionException e) {
           e.printStackTrace();
        }
    }
}
