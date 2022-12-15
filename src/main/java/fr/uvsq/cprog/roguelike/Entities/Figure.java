package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color ;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

public class Figure extends Entity{

    public Figure(int x, int y, char glyph, Color color){
        try {
            super.position = new Position(x, y);
            super.glyph = glyph ;
            super.color = color ;
            this.view = "RIGHT" ;
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }
}
