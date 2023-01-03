package fr.uvsq.cprog.roguelike.Commandes;

import fr.uvsq.cprog.roguelike.Entities.Cursor;

/**
 * @author lazare-rd
 * @version 01/01/2023
 */
public class MoveDownCursor implements Commande{
    private Cursor cursor ;
    private int maxHeigh ;
    private int[] fileNamesWidth ;

    public MoveDownCursor(Cursor cusor, int[] fileNamesWidth) {
        this.cursor = cusor ;
        this.maxHeigh = fileNamesWidth.length + 17 ;
        this.fileNamesWidth = fileNamesWidth;
    }

    @Override
    public void execute() {
        int currY = this.cursor.getPos().getY();
        if (currY + 1 < maxHeigh) {
            this.cursor.getPos().moveDown();
            this.cursor.getPos().setX(fileNamesWidth[(currY + 1) - 17]);
        }
    }
}
