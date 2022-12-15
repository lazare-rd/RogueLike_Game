package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Entities.Entity;

public class MoveUp implements Commande{
    private Entity entity ;

    public MoveUp(Entity entity){
        this.entity = entity ; 
    }

    @Override
    public void execute(){
        entity.getPos().moveUp();
        this.entity.setView("UP");
    }
}