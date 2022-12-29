package fr.uvsq.cprog.roguelike.Commandes;

public class Quit implements Commande{
    public void execute() {
        System.exit(0);
    }
}
