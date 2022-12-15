package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Entity;

public class MoveRight implements Commande{
    private Entity entity ;

    public MoveRight(Entity entity){
        this.entity = entity ; 
    }

    @Override
    public void execute(){
        entity.getPos().moveRight();
        this.entity.setView("RIGHT");
    }
}