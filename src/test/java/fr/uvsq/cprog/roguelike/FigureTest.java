package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import fr.uvsq.cprog.roguelike.Entities.Figure;

import java.awt.Color ;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.UI.UserInterface;

public class FigureTest {

    @Test
    public void constructorTest(){
        Figure fig = new Figure(0, 0, '@', Color.BLACK);
        assert(fig.getPos().equals(new Position()));
        assert(fig.getGlyph() == '@');
        assert(fig.getColor() == Color.BLACK);
        assert(fig.getView() == "RIGHT");
        assert(fig.getLifePoints() == 3);
        assert(fig.getCoins() == 0);
    }

    @Test
    public void removeOneLifeTest(){
        Figure fig = new Figure(0, 0, '@', Color.BLACK);
        UserInterface ui = new UserInterface();
        fig.removeOneLife(ui);
        assert(fig.getLifePoints() == 2);
    }

    @Test
    public void addOneCoinTest(){
        Figure fig = new Figure(0, 0, '@', Color.BLACK);
        fig.addOneCoin();
        assert(fig.getCoins() == 1);
    }

    @Test
    public void settersTest(){
        Figure fig = new Figure(0, 0, '@', Color.BLACK);
        fig.setCoins(100);
        fig.setLifePoints(100);
        assert(fig.getCoins() == 100);
        assert(fig.getLifePoints() == 100);
    }
}   
