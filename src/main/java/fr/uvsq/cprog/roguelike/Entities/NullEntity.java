package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

public class NullEntity extends Entity{
    public NullEntity(int x, int y) {
        try {
            super.glyph = ' ';
            super.position = new Position(x, y);
            super.color = Color.BLACK ;
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}
