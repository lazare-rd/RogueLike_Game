package fr.uvsq.cprog.roguelike;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;

public class Position {
    private int posX ;
    private int posY ;

    private static int maxHeigh ;
    private static int maxWidth ;


    public Position(int posX, int posY) throws IllegalPositionException{
        if (posX>=0 && posY>=0){
            this.posX = posX ; 
            this.posY = posY ;
        }
        else{
            throw new IllegalPositionException() ;
        }
    }

    public int getX(){
        return posX ;
    }

    public int getY(){
        return posY ;
    }

    public void moveUp(){
        if (this.posY - 1 >= 0){
            this.posY -= 1 ;
        }
    }

    public void moveDown(){
        if (this.posY + 1 < maxHeigh){
            this.posY += 1 ;
        }
    }

    public void moveLeft(){
        if (this.posX - 1 >= 0){
            this.posX -= 1 ;
        }
    }

    public void moveRight(){
        if (this.posX + 1 < maxWidth){
            this.posX += 1 ;
        }
    }

    public static void setBounds(int width, int height){
        maxHeigh = height ;
        maxWidth = width ;
    }

    public static int getMaxHeight(){
        return maxHeigh ;
    }

    public static int getMaxWidth(){
        return maxWidth ;
    }
}
