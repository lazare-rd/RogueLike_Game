package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entities.Figure;

import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.World.World;
import fr.uvsq.cprog.roguelike.Entities.Wall;
import fr.uvsq.cprog.roguelike.Entities.Zombie;
import fr.uvsq.cprog.roguelike.UI.Position;


import fr.uvsq.cprog.roguelike.RogueLike;
import fr.uvsq.cprog.roguelike.Entities.Coin;
import fr.uvsq.cprog.roguelike.Entities.Door;


public class MoveDown implements Commande{
    private Figure figure ;
    private World world ;
    private RogueLike rg ;

    public MoveDown(RogueLike rg){
        this.rg = rg ;
        this.figure = rg.getPJ() ;
        this.world = rg.getWorld() ;
    }

    @Override
    public void execute(){
        Entity[][] layout = this.world.getLayout().getData() ;
        Position posDown = this.figure.getPos().getPosUnder() ;
        int x = posDown.getX() ;
        int y = posDown.getY() ;
        if ( layout[x][y] instanceof Zombie ){
            this.figure.getPos().moveDown();
            this.figure.setView("DOWN");
            this.figure.removeOneLife();
        }
        else if ( layout[x][y] instanceof Door ){
            rg.updateGame();
            rg.run();
        }
        else if ( layout[x][y] instanceof Coin ){
            this.figure.getPos().moveDown();
            this.figure.setView("DOWN");
            this.figure.addOneCoin();
        }
        else if ( !(layout[x][y] instanceof Wall) ){
            this.figure.getPos().moveDown();
            this.figure.setView("DOWN");
        }
    }
}