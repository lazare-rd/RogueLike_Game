package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.World.World;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.Entities.Wall;

public class MoveUp implements Commande{
    private Entity entity ;
    private World world ;

    public MoveUp(Entity entity, World world){
        this.entity = entity ;
        this.world = world ;
    }

    @Override
    public void execute(){
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posUp = this.entity.getPos().getPosOnTop() ;
        int xDown = posUp.getX() ;
        int yDown = posUp.getY() ;
        if ( !(layout[xDown][yDown] instanceof Wall) ){
            this.entity.getPos().moveUp();
            this.entity.setView("UP");
        }
    }
}