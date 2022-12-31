package fr.uvsq.cprog.roguelike.Entities;
import java.awt.Color;
import java.io.Serializable;

import fr.uvsq.cprog.roguelike.UI.Position;

public abstract class Entity implements Serializable {

    private static final long serialVersionUID = -7460262937617263578L;

    protected Position position ;
    protected char glyph ; 
    protected Color color ;
    protected String view ;

    public Position getPos() {
        return position ;
    } ;

    public Color getColor() {
        return color;
    } ;

    public char getGlyph() {
        return glyph ;
    } ;

    public void setView(String view) {
        this.view = view ;
    }

    public String getView() {
        return this.view ; 
    }

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
