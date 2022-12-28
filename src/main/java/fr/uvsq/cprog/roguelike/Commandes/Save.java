package fr.uvsq.cprog.roguelike.Commandes;
import fr.uvsq.cprog.roguelike.Board;
import fr.uvsq.cprog.roguelike.UI.TextFieldWindow; 

public class Save implements Commande{
    private Board board;

    public Save(Board board){
        this.board = board ;
    }

    private void waitUntilUserHasClicked(TextFieldWindow g){
        while( !(g.getUserHasCliked()) ){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void execute(){
        TextFieldWindow g = new TextFieldWindow();
        g.showWindow();
        this.waitUntilUserHasClicked(g);
        String data = g.getData();
        data = data.replaceAll("\\s", "");
        this.board.serialize(data);
        System.exit(0);
    }
} 
