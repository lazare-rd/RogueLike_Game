package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.World.World;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.Entities.Wall;
public class MoveLeft implements Commande{
    private Entity entity ;
    private World world ;

    public MoveLeft(Entity entity, World world){
        this.entity = entity ; 
        this.world = world ;
    }

    @Override
    public void execute(){
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posLeft = this.entity.getPos().getPosOnTheLeft() ;
        int x = posLeft.getX() ;
        int y = posLeft.getY() ;
        if ( !(layout[x][y] instanceof Wall) ){
            this.entity.getPos().moveLeft();
            this.entity.setView("LEFT");
        }
    }
}
