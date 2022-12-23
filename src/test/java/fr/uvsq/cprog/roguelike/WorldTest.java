package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.UI.UserInterface;
import fr.uvsq.cprog.roguelike.World.World;

public class WorldTest {

    @Test
    public void constuctorTest(){
        new World(0);
    }

    @Test
    public void isThereAWayOutTest(){
        for (int i=0 ; i<20 ; i++){
            World world = new World(0) ;
            assert(findWayOut(world));
        } 
    }

    @Test
    public void isThereANullElement(){
        for (int i=0 ; i<20 ; i++){
            World world = new World(0) ;
            assert( !(findNullElement(world)) );
        } 
    }

    private boolean findWayOut(World world){
        int[][] layout = world.getRoomLayout();
        for (int i=0 ; i<7 ; i++){
            innerLoop :
            for (int j=0 ; j<5 ; j++){
                if (layout[i][j] == 2){
                    if (layout[i][j+1] != 2 && layout[i][j+1] != 3){
                        return false ;
                    }
                    else{
                        break innerLoop ;
                    }
                }
            }
        }
        return true ;
    }

    private boolean findNullElement(World world){
        Entity[][] layout = world.getLayout().getData() ;
        for (int i = 0 ; i < UserInterface.pixelsInWidth ; i++){
            for (int j = 0 ; j < UserInterface.pixelsInHeight ; j++){
                if ( !(layout[i][j] instanceof Entity) ){
                    return true ;
                }
            }
        }
        return false ;
    }
}
