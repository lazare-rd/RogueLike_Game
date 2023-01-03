package fr.uvsq.cprog.roguelike.world;

import java.io.Serializable;

/**
 * This class implements the logics of the random world generation described bellow
 * http://tinysubversions.com/spelunkyGen/
 * @author lazare-rd
 * @version 01/01/2023
 */
public class SolutionPath implements Serializable{
    
    private static final long serialVersionUID = 6693868199962313574L;

    private int x ;
    private int y ;
    private int direction ;

    public SolutionPath() {
        this.x = 0;
        this.y = 0;
        this.direction = 1 ;
    }

    
    /** 
     * @return int
     */
    public int getX() {
        return this.x;
    }

    
    /** 
     * @return int
     */
    public int getY() {
        return this.y;
    }

    
    /** 
     * @return String
     */
    public String moveLeft() {
        if (x - (direction * 1) >= 0 && x - (direction * 1) <= 7) {
            x = x - (direction * 1) ;
            return "LEFT" ;
        }
        else {
            this.direction *= -1 ; 
            return moveDown();
        }
    }

    
    /** 
     * @return String
     */
    public String moveRight() {
        if (x + (direction * 1) >= 0 && x + (direction * 1) <= 7) {
            x = x + (direction * 1) ;
            return "RIGHT" ;
        }
        else {
            this.direction *= -1 ;
            return moveDown();
        }
    }

    
    /** 
     * @return String
     */
    public String moveDown() {
        if (y + 1 <= 5) {
            y += 1 ;
            return "DOWN" ;
        }
        else {
            return "STOP" ;
        }
    }
} 
