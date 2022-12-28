package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Entities.Cursor;

public class MoveUpCursor implements Commande{
    private Cursor cursor ;
    private int minHeigh ;
    private int[] fileNamesWidth ;

    public MoveUpCursor(Cursor cusor, int[] fileNamesWidth){
        this.cursor = cusor ;
        this.minHeigh = 16 ;
        this.fileNamesWidth = fileNamesWidth;
    }

    @Override
    public void execute(){
        int currY = this.cursor.getPos().getY();
        if ( currY - 1 > minHeigh ){
            this.cursor.getPos().moveUp();
            this.cursor.getPos().setX(fileNamesWidth[(currY - 1) - 17]);
        }
    }
}
