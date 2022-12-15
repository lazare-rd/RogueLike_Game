package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entities.Entity;

public class MoveLeft implements Commande{
    private Entity entity ;

    public MoveLeft(Entity entity){
        this.entity = entity ; 
    }

    @Override
    public void execute(){
        entity.getPos().moveLeft();
        this.entity.setView("LEFT");
    }
}
