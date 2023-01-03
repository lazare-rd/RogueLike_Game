package fr.uvsq.cprog.roguelike.Commandes;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class Quit implements Commande{
    public void execute() {
        System.exit(0);
    }
}
