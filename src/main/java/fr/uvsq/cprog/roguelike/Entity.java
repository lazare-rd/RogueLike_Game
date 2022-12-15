package fr.uvsq.cprog.roguelike;
import java.awt.Color ;

public abstract class Entity {
    protected Position position ;
    protected char glyph ; 
    protected Color color ;
    protected String view ;

    public Position getPos(){
        return position ;
    } ;

    public Color getColor(){
        return color;
    } ;

    public char getGlyph(){
        return glyph ;
    } ;

    public void setView(String view){
        this.view = view ;
    }

    public String getView(){
        return this.view ; 
    }
}
