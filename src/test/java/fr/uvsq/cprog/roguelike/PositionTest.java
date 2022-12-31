package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;
import fr.uvsq.cprog.roguelike.UI.Position;

public class PositionTest {

    @Test
    public void isConstructorInstanciated() throws IllegalPositionException {
        new Position(0, 0);
    }

    @Test(expected = IllegalPositionException.class)
    public void constructorExceptionTest() throws IllegalPositionException {
        int x = Position.getMaxWidth() + 10 ;
        int y = Position.getMaxHeight() + 10 ;
        new Position(x, y);
    }

    @Test
    public void gettersTest() throws IllegalPositionException {
        Position p = new Position(0, 0);
        assert(p.getX() == 0);
        assert(p.getY() == 0);
    }

    @Test
    public void settersTest() {
        Position p = new Position();
        p.setX(2);
        p.setY(3);
        assert(p.getX() == 2 && p.getY() == 3);
    }

    @Test
    public void moveUpAndLeftBorderTest() throws IllegalPositionException {
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
    public void moveDownAndRightBorderTest() throws IllegalPositionException {
        int x = Position.getMaxWidth() - 1 ;
        int y = Position.getMaxHeight() - 1  ;
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
    
    @Test
    public void testEquals()throws IllegalPositionException {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(2, 1);
        assert(!(p1.equals(p2)));
    }

    @Test
    public void testGetPosOnTop() throws IllegalPositionException {
        Position pLim = new Position();
        Position p = new Position(1, 1);
        Position pTop = p.getPosOnTop();
        assert(pTop.getX() == 1 && pTop.getY() == 0);
        assert(pLim.getPosOnTop().equals(new Position()));
    }

    @Test
    public void testGetPosOnTheRight() throws IllegalPositionException {
        int x = Position.getMaxWidth() - 1 ;
        int y = Position.getMaxHeight() - 1  ;
        Position pLim = new Position(x, y);
        Position p = new Position(1, 1);
        Position pTop = p.getPosOnTheRight();
        assert(pTop.getX() == 2 && pTop.getY() == 1);
        assert(pLim.getPosOnTheRight().equals(new Position()));
    }

    @Test
    public void testGetPosOnTheLeft() throws IllegalPositionException {
        Position pLim = new Position();
        Position p = new Position(1, 1);
        Position pTop = p.getPosOnTheLeft();
        assert(pTop.getX() == 0 && pTop.getY() == 1);
        assert(pLim.getPosOnTheLeft().equals(new Position()));
    }

    @Test
    public void testGetPosUnder() throws IllegalPositionException {
        int x = Position.getMaxWidth() - 1 ;
        int y = Position.getMaxHeight() - 1 ;
        Position pLim = new Position(x, y);
        Position p = new Position(1, 1);
        Position pTop = p.getPosUnder();
        assert(pTop.getX() == 1 && pTop.getY() == 2);
        assert(pLim.getPosUnder().equals(new Position()));
    }

}
