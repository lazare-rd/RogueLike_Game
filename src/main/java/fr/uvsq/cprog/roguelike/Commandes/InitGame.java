package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Board;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class InitGame implements Commande{
    private Board board ;

    public InitGame(Board board) {
        this.board = board ;
    }

    @Override
    public void execute() {
        this.board.run();
    }
}
