package fr.uvsq.cprog.roguelike.Entities;
import java.awt.Color;

public class Cursor extends Figure{
    public Cursor(int x, int y) {
        super(x, y, '<', Color.CYAN);
        this.setCoins(0);
        this.setLifePoints(0);
    }
}
