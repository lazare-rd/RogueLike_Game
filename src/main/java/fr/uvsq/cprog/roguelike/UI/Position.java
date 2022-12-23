package fr.uvsq.cprog.roguelike.UI;

import fr.uvsq.cprog.roguelike.Exceptions.IllegalPositionException;

public class Position {
    private int posX ;
    private int posY ;

    private static int maxHeigh = UserInterface.pixelsInHeight ;
    private static int maxWidth = UserInterface.pixelsInWidth ;


    public Position(int posX, int posY) throws IllegalPositionException{
        if (posX>=0 && posY>=0 && posX<maxWidth && posY<maxHeigh){
            this.posX = posX ; 
            this.posY = posY ;
        }
        else{
            throw new IllegalPositionException() ;
        }
    }

    public Position(){
        this.posX = 0 ;
        this.posY = 0 ;
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

    public Position getPosOnTheRight(){
        int x = this.posX + 1;
        int y = this.posY ;
        try {
            return new Position(x, y) ;
        } catch (IllegalPositionException e) {
            return new Position();
        }
    }

    public Position getPosOnTheLeft(){
        int x = this.posX - 1;
        int y = this.posY ;
        try {
            return new Position(x, y) ;
        } catch (IllegalPositionException e) {
            return new Position();
        }
    }

    public Position getPosOnTop(){
        int x = this.posX ;
        int y = this.posY - 1 ;
        try {
            return new Position(x, y) ;
        } catch (IllegalPositionException e) {
            return new Position();
        }
    }

    public Position getPosUnder(){
        int x = this.posX ;
        int y = this.posY + 1 ;
        try {
            return new Position(x, y) ;
        } catch (IllegalPositionException e) {
            return new Position();
        }
    }

    public static int getMaxHeight(){
        return maxHeigh ;
    }

    public static int getMaxWidth(){
        return maxWidth ;
    }

    public boolean equals(Position pos){
        if (this.posX == pos.getX() && this.posY == pos.getY()){
            return true ;
        }
        else{
            return false ;
        }
    }

    private boolean isOnTheLeftOf(Position pos){
        if (this.posY == pos.getY() && this.posX == pos.getX() - 1 ){
            return true ;
        }
        else{
            return false ;
        }
    }

    private boolean isOnTopOf(Position pos){
        if (this.posY == pos.getY() + 1 && this.posX == pos.getX()){
            return true ;
        }
        else{
            return false ;
        }
    }

    private boolean isUnder(Position pos){
        if (this.posY == pos.getY() - 1 && this.posX == pos.getX()){
            return true ;
        }
        else{
            return false ;
        }
    }
}
