package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.World.World;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.Entities.Wall;
import fr.uvsq.cprog.roguelike.Entities.Figure;
import fr.uvsq.cprog.roguelike.Entities.Zombie;

public class MoveUp implements Commande{
    private Figure figure ;
    private World world ;

    public MoveUp(Figure figure, World world){
        this.figure = figure ;
        this.world = world ;
    }

    @Override
    public void execute(){
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posUp = this.figure.getPos().getPosOnTop() ;
        int x = posUp.getX() ;
        int y = posUp.getY() ;
        if ( layout[x][y] instanceof Zombie ){
            this.figure.getPos().moveUp();
            this.figure.setView("UP");
            this.figure.removeOneLife();
        }
        else if ( !(layout[x][y] instanceof Wall) ){
            this.figure.getPos().moveUp();
            this.figure.setView("UP");
        }
    }
}