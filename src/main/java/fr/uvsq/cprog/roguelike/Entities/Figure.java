package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.UI.UserInterface;

public class Figure extends Entity{
    private int lifePoints ;
    private int coins ;

    public Figure(int x, int y, char glyph, Color color) {
        try {
            super.position = new Position(x, y);
            super.glyph = glyph ;
            super.color = color ;
            super.view = "RIGHT" ;
            this.lifePoints = 3 ;
            this.coins = 0 ;
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }

    public int getCoins() {
        return this.coins ;
    }

    public void setCoins(int coins) {
        this.coins = coins ;
    }

    public void addOneCoin() {
        this.coins += 1 ;
    }

    public void removeOneLife(UserInterface ui) {
        if (this.lifePoints - 1 == 0) {
            kill(ui);
        }
        else {
            this.lifePoints -= 1 ;
        }
    }

    public int getLifePoints() {
        return this.lifePoints ;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints ;
    }

    public boolean equals(Figure fig) {
        if (super.equals(fig)
            && this.coins == fig.getCoins()
            && this.lifePoints == fig.getLifePoints())
        {
            return true ;
        }
        else {
            return false ;
        }
    }
    
    private static void kill(UserInterface ui) {
        ui.drawDeadScreen();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
