package fr.uvsq.cprog.roguelike.Commandes;

/**
 * An interface implemented by a class that needs to represent a user commande
 * @author lazare-rd
 * @version 01/01/2023
 */
public interface Commande{

    /**
     * Everything that the command is meant to do happens in this method. 
     */
    void execute();
}
