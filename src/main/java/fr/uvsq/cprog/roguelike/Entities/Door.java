package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color;
import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

public class Door extends Entity{
    
    public Door(int x, int y){
        try {
            super.color = Color.CYAN ;
            super.glyph = 'D' ;
            super.position = new Position(x, y) ;
        } catch (IllegalPositionException e) {
           e.printStackTrace();
        }
    }
}
