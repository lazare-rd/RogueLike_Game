package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.World.World;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.Entities.Wall;
import fr.uvsq.cprog.roguelike.Entities.Figure;
import fr.uvsq.cprog.roguelike.Entities.Zombie;

public class MoveRight implements Commande{
    private Figure figure ;
    private World world ;

    public MoveRight(Figure figure, World world){
        this.figure = figure ; 
        this.world = world ;
    }

    @Override
    public void execute(){
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posRight = this.figure.getPos().getPosOnTheRight() ;
        int x = posRight.getX() ;
        int y = posRight.getY() ;
        if ( layout[x][y] instanceof Zombie ){
            this.figure.setView("RIGHT");
            this.figure.removeOneLife();
            this.figure.getPos().moveRight();
        }
        else if ( !(layout[x][y] instanceof Wall) ){
            this.figure.getPos().moveRight();
            this.figure.setView("RIGHT");
        }
    }
}