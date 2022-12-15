package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

public class PositionTest {

    @Test
    public void isConstructorInstanciated() throws IllegalPositionException{
        new Position(0, 0);
    }

    @Test
    public void gettersTest() throws IllegalPositionException{
        Position p = new Position(0, 0);
        assert(p.getX() == 0);
        assert(p.getY() == 0);
    }

    @Test
    public void moveUpAndLeftBorderTest() throws IllegalPositionException{
        Position p = new Position(0, 0);
        p.moveUp();
        assert(p.getY() == 0);
        p.moveLeft();
        assert(p.getX() == 0);
        p.moveDown();
        assert(p.getY() == 1);
        p.moveRight();
        assert(p.getX() == 1);
    }

    @Test
    public void moveDownAndRightBorderTest() throws IllegalPositionException{
        Position.setBounds(100, 100);
        int x = Position.getMaxWidth() ;
        int y = Position.getMaxHeight() ;
        Position p = new Position(x, y);
        p.moveDown();
        assert(p.getY() == y);
        p.moveRight();
        assert(p.getX() == x);
        p.moveUp();
        assert(p.getY() == y - 1);
        p.moveLeft();
        assert(p.getX() == x - 1);
    }        
}
