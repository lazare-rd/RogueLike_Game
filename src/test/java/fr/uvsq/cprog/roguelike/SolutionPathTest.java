package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import fr.uvsq.cprog.roguelike.World.SolutionPath;

public class SolutionPathTest {

    @Test
    public void testConstructor(){
        new SolutionPath() ;
    }

    @Test
    public void testMoveRight_whenAtBound(){
        SolutionPath path = new SolutionPath();
        moveToRightSideBound(path);
        assert(path.moveRight() == "DOWN") ;
        assert(path.getX() == 7) ;
        assert(path.getY() == 1) ; 
    }

    @Test
    public void testMoveLeft_whenAtBound(){
        SolutionPath path = new SolutionPath();
        assert(path.moveLeft() == "DOWN") ; 
        assert(path.getX() == 0) ; 
        assert(path.getY() == 1) ;
    }

    @Test
    public void testMoveSideway(){
        SolutionPath path = new SolutionPath();
        assert(path.moveRight() == "RIGHT");
        assert(path.getX() == 1) ; 
        assert(path.getY() == 0) ;
        assert(path.moveLeft() == "LEFT");
        assert(path.getX() == 0) ; 
        assert(path.getY() == 0) ;
    }

    @Test
    public void testMoveDown(){
        SolutionPath path = new SolutionPath();
        assert(path.moveDown() == "DOWN");
        assert(path.getX() == 0) ; 
        assert(path.getY() == 1) ;
    }

    @Test
    public void testMoveDown_whenAtBound(){
        SolutionPath path = new SolutionPath() ;
        moveToLowerBound(path);
        assert(path.moveDown() == "STOP") ;
        assert(path.getX() == 0);
        assert(path.getY() == 5);
    }

    private void moveToRightSideBound(SolutionPath path){
        for (int i = 0 ; i < 7 ; i++){
            path.moveRight();
        }
    }

    private void moveToLowerBound(SolutionPath path){
        for (int i = 0 ; i < 5 ; i++){
            path.moveDown();
        }
    }
}
