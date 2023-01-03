package fr.uvsq.cprog.roguelike.world;

import java.io.Serializable;
import java.util.Random;

import asciiPanel.AsciiCharacterData;
import fr.uvsq.cprog.roguelike.UI.UserInterface;
import fr.uvsq.cprog.roguelike.Entities.Door;

/**
 * Represents a map with it's zombies and coins, the constructor generates a random map.
 * @author lazare-rd
 * @version 01/01/2023
 */
public class World implements Serializable{
    private int width = UserInterface.pixelsInWidth ;
    private int height = UserInterface.pixelsInHeight ; 
    private int roomHeight = UserInterface.pixelsInRoomHeight ; 
    private int roomWidth = UserInterface.pixelsInRoomWidth ;
    private Worldstructure layout ;
    private int[][] roomLayout = {{0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0}};
    private int level ;
    private static final Random r = new Random() ;


    public World(int level) {
        if (level >= 0 && level < 14) {
            this.level = level;
            this.layout = new Worldstructure(width, height, level) ; 
        }
        else {
            this.level = 0 ;
            this.layout = new Worldstructure(width, height, 0) ;
        }
        generateWorld();
    }

    
    /** 
     * @return Worldstructure
     */
    public Worldstructure getLayout() {
        return this.layout ;
    }

    
    /** 
     * @return int[][]
     */
    public int[][] getRoomLayout() {
        return this.roomLayout ;
    }

    
    /** 
     * @return int
     */
    public int getLevel() {
        return this.level ;
    }

    
    /** 
     * @param w
     * @return boolean
     */
    public boolean equals(World w) {
        if (this.layout.equals(w.getLayout()) && this.level == w.getLevel()) {
            return true ;
        }
        else {
            return false ;
        }
    }

    /**
     * Generates a new world layout randomly. 
     */
    private void generateWorld() {
        int w = this.layout.getRoomWidth();
        int h = this.layout.getRoomHeight();
        layout.addRoom1(0, 0);
        roomLayout[0][0] = 1;
        SolutionPath path = new SolutionPath();
        boolean carryOn = true ;
        int randomInt ;
        while (carryOn) {
            randomInt = r.nextInt(5) ; 
            if (randomInt == 0 || randomInt == 1) {
                carryOn = caseLeft(path, w, h);
            }
            else if (randomInt == 2 || randomInt == 3) {
                carryOn = caseRight(path, w, h);
            }
            else {
                carryOn = caseDown(path, w, h);
            }
        }
        fillVoidRooms();
        placeDoor();
    }

    /**
     * Places the door in the room where the random world generation stopped.
     */
    private void placeDoor() {
        int j = roomLayout[0].length - 1;
        int iBefore3 = 0 ;
        int iAfter3 = 0 ;
        int nBefore3 = 0 ; 
        int nAfter3 = 0 ;
        boolean isPassed = false ;
        for (int i = 0 ; i < roomLayout.length ; i++) {
            if (roomLayout[i][j] == 3) {
                iAfter3 = i ;
                isPassed = true ;
            }
            else if (roomLayout[i][j] == 1) {
                if (!isPassed) {
                    iAfter3 = i ;
                    nAfter3 += 1 ; 
                }
                else {
                    iBefore3 = i ;
                    nBefore3 += 1 ;
                }
            }   
        }
        if (nAfter3 > nBefore3) {
            this.layout.addEntity(iAfter3 * roomWidth + 1 + r.nextInt(11), j * roomHeight + 1, new Door(iAfter3, j));
        }
        else if (nAfter3 <= nBefore3 && nBefore3 != 0) {
            this.layout.addEntity(iBefore3 * roomWidth + 1 + r.nextInt(11), j * roomHeight + 1, new Door(iBefore3, j));
        }
        else {
            this.layout.addEntity(iAfter3 * roomWidth + 1 + r.nextInt(11), j * roomHeight + 1, new Door(iAfter3, j));
        }
    }

    
    /** 
     * @param path
     * @param w
     * @param h
     * @return boolean
     */
    private boolean caseLeft(SolutionPath path, int w, int h) {
        String output = path.moveLeft();
        boolean carryOn = processPathOutput(output); 
        int x = path.getX();
        int y = path.getY();
        if (output == "LEFT") {
            if (roomLayout[x][y] != 2 && roomLayout[x][y] != 3) {
                layout.addRoom1(x * w, y * h);
                roomLayout[x][y] = 1;
            }
        }
        else if (output == "DOWN") {
            layout.addRoom2(x * w, (y - 1) * h);
            layout.addRoom3(x * w, y * h);
            roomLayout[x][y - 1] = 2;
            roomLayout[x][y] = 3;
        }
        return carryOn ;
    }

    
    /** 
     * @param path
     * @param w
     * @param h
     * @return boolean
     */
    private boolean caseRight(SolutionPath path, int w, int h) {
        String output = path.moveRight();
        boolean carryOn = processPathOutput(output); 
        int x = path.getX();
        int y = path.getY();
        if (output == "RIGHT") {
            if (roomLayout[x][y] != 2 && roomLayout[x][y] != 3) {
                layout.addRoom1(x * w, y * h);
                roomLayout[x][y] = 1;
            }
        }
        else if (output == "DOWN") {
            layout.addRoom2(x * w, (y - 1) * h);
            layout.addRoom3(x * w, y * h);
            roomLayout[x][y - 1] = 2;
            roomLayout[x][y] = 3;
        }
        return carryOn ;
    }

    
    /** 
     * @param path
     * @param w
     * @param h
     * @return boolean
     */
    private boolean caseDown(SolutionPath path, int w, int h) {
        String output = path.moveDown() ; 
        boolean carryOn = processPathOutput(output);
        int x = path.getX();
        int y = path.getY();
        if (output == "DOWN") {
            layout.addRoom2(x * w, (y - 1) * h);
            layout.addRoom3(x * w, y * h);
            roomLayout[x][y - 1] = 2;
            roomLayout[x][y] = 3;
        }
        return carryOn ;
    }

    
    /** 
     * @param s
     * @return boolean
     */
    private boolean processPathOutput(String s) {
        switch(s) {
            case"LEFT":
                return true ;
            case"RIGHT":
                return true ;
            case"DOWN":
                return true ;
            case"STOP":
                return false ;
            default :
                return true ;
        }
    }

    
    /** 
     * @return AsciiCharacterData[][]
     */
    public AsciiCharacterData[][] generateCharGrid() {
        return this.layout.generateCharGrid();
    }
    
    /**
     * Fills the rest of the grid that hasn't already been filled with rooms of type 0
     */
    private void fillVoidRooms() {
        int w = this.layout.getRoomWidth();
        int h = this.layout.getRoomHeight();
        for (int x = 0 ; x < 8 ; x++) {
            for (int y = 0 ; y < 6 ; y++) {
                if (roomLayout[x][y] == 0) {
                    layout.addRoom0(x * w, y * h);
                }
            }
        }
    }
}
