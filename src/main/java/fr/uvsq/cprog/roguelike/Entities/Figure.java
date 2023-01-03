package fr.uvsq.cprog.roguelike.Entities;

import java.awt.Color;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.UI.UserInterface;

/**
 * A Figure is a particular Entity that can move, has lifePoints and coins
 * @author lazare-rd
 * @version 01/01/2023
 */
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

    
    /** 
     * @return int
     */
    public int getCoins() {
        return this.coins ;
    }

    
    /** 
     * @param coins
     */
    public void setCoins(int coins) {
        this.coins = coins ;
    }

    public void addOneCoin() {
        this.coins += 1 ;
    }

    
    /** 
     * @param ui
     */
    public void removeOneLife(UserInterface ui) {
        if (this.lifePoints - 1 == 0) {
            kill(ui);
        }
        else {
            this.lifePoints -= 1 ;
        }
    }

    
    /** 
     * @return int
     */
    public int getLifePoints() {
        return this.lifePoints ;
    }

    
    /** 
     * @param lifePoints
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints ;
    }

    
    /** 
     * @param fig
     * @return boolean
     */
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
    
    
    /** 
     * @param ui
     */
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
