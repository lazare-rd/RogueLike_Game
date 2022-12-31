package fr.uvsq.cprog.roguelike;
import org.junit.Test;
import fr.uvsq.cprog.roguelike.Commandes.*;


public class CommandesRLTest {

    @Test
    public void testBasicCommandes() {
        RogueLike rg = new RogueLike();
        int[] getFileNamesWidth = {12, 3, 9};

        Commande moveDown = new MoveDownCursor(rg.getCursor(), getFileNamesWidth);
        moveDown.execute();

        Commande moveUp = new MoveUpCursor(rg.getCursor(), getFileNamesWidth);
        moveUp.execute();
    }
}
