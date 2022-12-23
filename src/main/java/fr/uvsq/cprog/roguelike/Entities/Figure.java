package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color ;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

public class Figure extends Entity{
    private int lifePoints ;

    public Figure(int x, int y, char glyph, Color color){
        try {
            super.position = new Position(x, y);
            super.glyph = glyph ;
            super.color = color ;
            super.view = "RIGHT" ;
            this.lifePoints = 3 ;
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }

    public int getLifePoints(){
        return this.lifePoints ;
    }

    public void removeOneLifePoint(){
        if (this.lifePoints - 1 == 0){
            kill(this);
        }
        else{
            this.lifePoints -= 1 ;
        }
    }

    private static void kill(Figure fig){
        fig = null ;
        System.gc();
    }
}
