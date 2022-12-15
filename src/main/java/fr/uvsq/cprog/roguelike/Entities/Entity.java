package fr.uvsq.cprog.roguelike.Entities;
import java.awt.Color ;

import fr.uvsq.cprog.roguelike.UI.Position;

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
