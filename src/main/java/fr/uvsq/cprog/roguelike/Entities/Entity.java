package fr.uvsq.cprog.roguelike.Entities;
import java.awt.Color;
import java.io.Serializable;

import fr.uvsq.cprog.roguelike.UI.Position;

/**
 * Averything that is displayed on the map is an Entity
 * @author lazare-rd
 * @version 01/01/2023
 */
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = -7460262937617263578L;

    protected Position position ;
    protected char glyph ; 
    protected Color color ;
    protected String view ;

    
    /** 
     * @return Position
     */
    public Position getPos() {
        return position ;
    } ;

    
    /** 
     * @return Color
     */
    public Color getColor() {
        return color;
    } ;

    
    /** 
     * @return char
     */
    public char getGlyph() {
        return glyph ;
    } ;

    
    /** 
     * @param view
     */
    public void setView(String view) {
        this.view = view ;
    }

    
    /** 
     * @return String
     */
    public String getView() {
        return this.view ; 
    }

    
    /** 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true ;
        }
        if (obj == null) {
            return false ;
        }
        if (!(obj instanceof Entity)) {
            return false ;
        }
        Entity e = (Entity)obj ;
        if (this.position.equals(e.getPos()) 
            && this.glyph == e.getGlyph() 
            && this.color.equals(e.getColor()))
        {
            return true ;
        }
        else {
            return false ;
        }
    }
}
