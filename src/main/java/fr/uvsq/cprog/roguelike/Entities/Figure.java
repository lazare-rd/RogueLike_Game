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

    public void removeOneLife(){
        if (this.lifePoints - 1 == 0){
            kill();
        }
        else{
            this.lifePoints -= 1 ;
        }
    }

    public int getLifePoints(){
        return this.lifePoints ;
    }
    
    private static void kill(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
