package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entity;

public class MoveDown implements Commande{
    private Entity entity ;

    public MoveDown(Entity entity){
        this.entity = entity ;
    }

    @Override
    public void execute(){
        this.entity.getPos().moveDown();
        this.entity.setView("DOWN");
    }
}