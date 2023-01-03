package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.UI.Position;
import fr.uvsq.cprog.roguelike.world.World;
import fr.uvsq.cprog.roguelike.Entities.Wall;
import fr.uvsq.cprog.roguelike.Entities.Figure;
import fr.uvsq.cprog.roguelike.Entities.Zombie;
import fr.uvsq.cprog.roguelike.Entities.Coin;
import fr.uvsq.cprog.roguelike.Entities.Door;

import fr.uvsq.cprog.roguelike.Board;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class MoveUp implements Commande{
    private Figure figure ;
    private World world ;
    private Board rg ;

    public MoveUp(Board rg) {
        this.rg = rg ;
        this.figure = rg.getPJ() ;
        this.world = rg.getWorld() ;
    }

    @Override
    public void execute() {
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posUp = this.figure.getPos().getPosOnTop() ;
        int x = posUp.getX() ;
        int y = posUp.getY() ;
        if (layout[x][y] instanceof Zombie) {
            this.figure.getPos().moveUp();
            this.figure.setView("UP");
            this.figure.removeOneLife(rg.getUi());
        }
        else if (layout[x][y] instanceof Door) {
            rg.updateGame();
            rg.run();
        }
        else if (layout[x][y] instanceof Coin) {
            this.figure.getPos().moveUp();
            this.figure.setView("UP");
            this.figure.addOneCoin();
        }
        else if (!(layout[x][y] instanceof Wall)) {
            this.figure.getPos().moveUp();
            this.figure.setView("UP");
        }
    }
}
