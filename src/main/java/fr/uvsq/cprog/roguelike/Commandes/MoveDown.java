package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.World.World;
import fr.uvsq.cprog.roguelike.Entities.Wall;
import fr.uvsq.cprog.roguelike.UI.Position;

public class MoveDown implements Commande{
    private Entity entity ;
    private World world ;

    public MoveDown(Entity entity, World world){
        this.entity = entity ;
        this.world = world ;
    }

    @Override
    public void execute(){
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posDown = this.entity.getPos().getPosUnder() ;
        int xDown = posDown.getX() ;
        int yDown = posDown.getY() ;
        if ( !(layout[xDown][yDown] instanceof Wall) ){
            this.entity.getPos().moveDown();
            this.entity.setView("DOWN");
        }
    }
}