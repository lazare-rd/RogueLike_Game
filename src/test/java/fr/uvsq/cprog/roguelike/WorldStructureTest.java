package fr.uvsq.cprog.roguelike;
import org.junit.Test;

import asciiPanel.AsciiCharacterData;
import fr.uvsq.cprog.roguelike.Entities.Entity;
import fr.uvsq.cprog.roguelike.Entities.NullEntity;
import fr.uvsq.cprog.roguelike.Entities.Wall;
import fr.uvsq.cprog.roguelike.world.Worldstructure;

public class WorldStructureTest {

    @Test
    public void constructorTest() {
        Worldstructure ws = new Worldstructure(8, 6, 0) ;
        assert(ws.getRoomHeight() == 1);
        assert(ws.getRoomWidth() == 1);
        assert(checkDataInitiation(ws.getData(), 8, 6));
    }

    @Test
    public void addRoom0Test() {
        Worldstructure ws = new Worldstructure(104, 48, 0) ;
        ws.addRoom0(0, 0);
        Entity[][] data = ws.getData() ;
        assert(checkUpperRow(data, false));
        assert(checkLowerRow(data, false));
        assert(checkLefColumn(data, false));
        assert(checkRightColumn(data, false));
    }

    @Test
    public void addRoom1Test() {
        Worldstructure ws = new Worldstructure(104, 48, 0) ;
        ws.addRoom1(0, 0);
        Entity[][] data = ws.getData() ;
        assert(checkUpperRow(data, false));
        assert(checkLowerRow(data, false));
        assert(checkLefColumn(data, true));
        assert(checkRightColumn(data, true));
    }

    @Test
    public void addRoom2Test() {
        Worldstructure ws = new Worldstructure(104, 48, 0) ;
        ws.addRoom2(0, 0);
        Entity[][] data = ws.getData() ;
        assert(checkUpperRow(data, true));
        assert(checkLowerRow(data, true));
        assert(checkLefColumn(data, true));
        assert(checkRightColumn(data, true));
    }

    @Test
    public void addRoom3Test() {
        Worldstructure ws = new Worldstructure(104, 48, 0) ;
        ws.addRoom3(0, 0);
        Entity[][] data = ws.getData() ;
        assert(checkUpperRow(data, true));
        assert(checkLowerRow(data, false));
        assert(checkLefColumn(data, true));
        assert(checkRightColumn(data, true));
    }

    @Test
    public void generateCharGridTest() {
        Worldstructure ws = new Worldstructure(3, 3, 0);
        AsciiCharacterData[][] grid = ws.generateCharGrid() ;
        assert(checkCharGrid(grid));
    }

    private boolean checkDataInitiation(Entity[][] data, int w, int h) {
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                if (!(data[i][j] instanceof NullEntity)) {
                    return false ;
                }
            }
        }
        return true ;
    }

    private boolean checkUpperRow(Entity[][] data, boolean checkIfNull) {
        if (checkIfNull) {
            for (int i = 0 ; i < data.length / 8 ; i++) {
                if (i == 3 || i == 4) {
                    if (!(data[i][0] instanceof NullEntity)) {
                        return false ;
                    }  
                }
                else {
                    if (!(data[i][0] instanceof Wall)) {
                        return false ;
                    } 
                }
            }
        }
        else {
            for (int i = 0 ; i < data.length / 8 ; i++) {
                if (!(data[i][0] instanceof Wall)) {
                    return false ;
                }
            }
        }
        return true ;
    }

    private boolean checkLowerRow(Entity[][] data, boolean checkIfNull) {
        if (checkIfNull) {
            for (int i = 0 ; i < data.length / 8 ; i++) {
                if (i == 4 || i == 3) {
                    if (!(data[i][data[0].length / 6 - 1] instanceof NullEntity)) {
                        return false ;
                    }  
                }
                else {
                    if (!(data[i][data[0].length / 6 - 1] instanceof Wall)) {
                        return false ;
                    } 
                }
            }
        }
        else {
            for (int i = 0 ; i < data.length / 8 ; i++) {
                if (!(data[i][data[0].length / 6 - 1] instanceof Wall)) {
                    return false ;
                }
            }
        }
        return true ;
    }

    private boolean checkLefColumn(Entity[][] data, boolean checkIfNull) {
        if (checkIfNull) {
            for (int i = 0 ; i < data[0].length / 6 ; i++) {
                if (i == 4 || i == 3) {
                    if (!(data[0][i] instanceof NullEntity)) {
                        return false ;
                    }  
                }
                else {
                    if (!(data[0][i] instanceof Wall)) {
                        return false ;
                    } 
                }
            }
        }
        else {
            for (int i = 0 ; i < data[0].length / 6 ; i++) {
                if (!(data[0][i] instanceof Wall)) {
                    return false ;
                }
            }
        }
        return true ;
    }

    private boolean checkRightColumn(Entity[][] data, boolean checkIfNull) {
        if (checkIfNull) {
            for (int i = 0 ; i < data[0].length / 6 ; i++) {
                if (i == 4 || i == 3) {
                    if (!(data[data.length / 8 - 1][i] instanceof NullEntity)) {
                        return false ;
                    }  
                }
                else {
                    if (!(data[data.length / 8 - 1][i] instanceof Wall)) {
                        return false ;
                    } 
                }
            }
        }
        else {
            for (int i = 0 ; i < data[0].length / 6 ; i++) {
                if (!(data[data.length / 8 - 1][i] instanceof Wall)) {
                    return false ;
                }
            }
        }
        return true ;
    }

    private boolean checkCharGrid(AsciiCharacterData[][] grid) {
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j].character != ' ') {
                    return false ;
                }
            }
        }
        return true ;
    }
}
