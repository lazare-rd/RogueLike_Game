package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.World.World;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.Entities.Wall;

public class MoveRight implements Commande{
    private Entity entity ;
    private World world ;

    public MoveRight(Entity entity, World world){
        this.entity = entity ; 
        this.world = world ;
    }

    @Override
    public void execute(){
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posRight = this.entity.getPos().getPosOnTheRight() ;
        int x = posRight.getX() ;
        int y = posRight.getY() ;
        if ( !(layout[x][y] instanceof Wall) ){
            this.entity.getPos().moveRight();
            this.entity.setView("RIGHT");
        }
    }
}