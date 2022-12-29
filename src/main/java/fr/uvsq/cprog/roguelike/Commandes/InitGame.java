package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Board;

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
