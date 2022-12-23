package fr.uvsq.cprog.roguelike.World;

public class SolutionPath {
    private int x ;
    private int y ;
    private int direction ;

    public SolutionPath(){
        this.x = 0;
        this.y = 0;
        this.direction = 1 ;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String moveLeft(){
        if (x - (direction * 1) >= 0 && x - (direction * 1) <= 7){
            x = x - (direction * 1) ;
            return "LEFT" ;
        }
        else{
            this.direction *= -1 ; 
            return moveDown();
        }
    }

    public String moveRight(){
        if (x + (direction * 1) >= 0 && x + (direction * 1) <= 7){
            x = x + (direction * 1) ;
            return "RIGHT" ;
        }
        else{
            this.direction *= -1 ;
            return moveDown();
        }
    }

    public String moveDown(){
        if (y+1 <= 5){
            y+=1 ;
            return "DOWN" ;
        }
        else{
            return "STOP" ;
        }
    }
} 
