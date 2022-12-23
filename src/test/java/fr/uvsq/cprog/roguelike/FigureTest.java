package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import fr.uvsq.cprog.roguelike.Entities.Figure;

import java.awt.Color ;
import fr.uvsq.cprog.roguelike.UI.Position;

public class FigureTest {

    @Test
    public void constructorTest(){
        Figure fig = new Figure(0, 0, '@', Color.BLACK);
        assert(fig.getPos().equals(new Position()));
        assert(fig.getGlyph() == '@');
        assert(fig.getColor() == Color.BLACK);
        assert(fig.getView() == "RIGHT");
        assert(fig.getLifePoints() == 3);
    }

    @Test
    public void removeOneLifeTest(){
        Figure fig = new Figure(0, 0, '@', Color.BLACK);
        fig.removeOneLife();
        assert(fig.getLifePoints() == 2);
    }
}   
