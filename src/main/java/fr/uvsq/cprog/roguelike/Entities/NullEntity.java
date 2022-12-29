package fr.uvsq.cprog.roguelike.Entities;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

public class NullEntity extends Entity{
    public NullEntity(int x, int y) {
        try {
            super.glyph = ' ';
            super.position = new Position(x, y);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}
