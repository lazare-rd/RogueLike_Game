package fr.uvsq.cprog.roguelike.Entities;
import java.awt.Color;

/**
 * The cursor allows the User to select which game he wants start on the welcome screen
 * @author lazare-rd
 * @version 01/01/2023
 */
public class Cursor extends Figure{
    public Cursor(int x, int y) {
        super(x, y, '<', Color.CYAN);
        this.setCoins(0);
        this.setLifePoints(0);
    }
}
