package fr.uvsq.cprog.roguelike;
import org.junit.Test;
import fr.uvsq.cprog.roguelike.Commandes.*;

public class CommandesBoardTest {

    @Test
    public void testBasicCommandes() {
        Board b = new Board();

        Commande moveDown = new MoveDown(b);
        moveDown.execute();

        Commande moveUp = new MoveUp(b);
        moveUp.execute();

        Commande moveLeft = new MoveLeft(b);
        moveLeft.execute();

        Commande moveRight = new MoveRight(b);
        moveRight.execute();
    }

}
