package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.world.World;
import fr.uvsq.cprog.roguelike.Entities.Wall;
import fr.uvsq.cprog.roguelike.Entities.Figure;
import fr.uvsq.cprog.roguelike.Entities.Zombie;
import fr.uvsq.cprog.roguelike.Board;
import fr.uvsq.cprog.roguelike.Entities.Coin;
import fr.uvsq.cprog.roguelike.Entities.Door;

public class MoveLeft implements Commande{
    private Figure figure ;
    private World world ;
    private Board rg ;

    public MoveLeft(Board rg) {
        this.rg = rg ;
        this.figure = rg.getPJ() ; 
        this.world = rg.getWorld() ;
    }

    @Override
    public void execute() {
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posLeft = this.figure.getPos().getPosOnTheLeft() ;
        int x = posLeft.getX() ;
        int y = posLeft.getY() ;
        if (layout[x][y] instanceof Zombie) {
            this.figure.getPos().moveLeft();
            this.figure.setView("LEFT");
            this.figure.removeOneLife(rg.getUi());
        }
        else if (layout[x][y] instanceof Door) {
            rg.updateGame();
            rg.run();
        }
        else if (layout[x][y] instanceof Coin) {
            this.figure.getPos().moveLeft();
            this.figure.setView("LEFT");
            this.figure.addOneCoin();
        }
        else if (!(layout[x][y] instanceof Wall)) {
            this.figure.getPos().moveLeft();
            this.figure.setView("LEFT");
        }
    }
}
