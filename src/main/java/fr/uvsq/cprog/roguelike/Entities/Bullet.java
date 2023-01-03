package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class Bullet extends Entity {

    public Bullet(int x, int y) {
        try {
            super.color = Color.RED ;
            super.glyph = '*' ;
            super.position = new Position(x, y) ;
        } catch (IllegalPositionException e) {
           e.printStackTrace();
        }
    }
}
