package fr.uvsq.cprog.roguelike.Entities;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;
import java.awt.Color ;

public class Wall extends Entity{ 

    public Wall(int x, int y){
        try {
            super.color = Color.BLUE ;
            super.glyph = '#' ;
            super.position = new Position(x, y) ;
        } catch (IllegalPositionException e) {
           e.printStackTrace();
        }
    }
}
