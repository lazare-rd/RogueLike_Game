package fr.uvsq.cprog.roguelike;

import java.awt.Color ;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;

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
