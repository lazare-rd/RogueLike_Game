package fr.uvsq.cprog.roguelike.world;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

import asciiPanel.AsciiCharacterData;
import fr.uvsq.cprog.roguelike.Entities.*;

/**
 * A wrapper for the Entity[][] array that stores every entity in the world in its position on the map.
 * @author lazare-rd
 * @version 01/01/2023
 */
public class Worldstructure implements Serializable {
    private int width ; 
    private int height ;
    private int roomHeight ;
    private int roomWidth ;
    private Entity[][] data ;
    private static final Random r = new Random() ;
    private int level ;

    public Worldstructure(int width, int height, int level) {
        this.width = width ;
        this.height = height ;
        this.roomHeight = (int)(height / 6) ;
        this.roomWidth = (int)(width / 8) ;
        this.data = initiateData(width, height);
        this.level = 14 - level ;
    }

    
    /** 
     * @return int
     */
    public int getRoomHeight() {
        return this.roomHeight ;
    }

    
    /** 
     * @return int
     */
    public int getRoomWidth() {
        return this.roomWidth ;
    }

    
    /** 
     * @return Entity[][]
     */
    public Entity[][] getData() {
        return this.data ;
    }

    
    /** 
     * A room of type 0 is a room that has no way out.
     * Generates a room 0 with an upper-left corner at (xStart, yStart) in data.
     * This room has its height = roomHeight 
     *                    width = roomWidth 
     * @param xStart
     * @param yStart
     */
    public void addRoom0(int xStart, int yStart) {
        generateInnerRoom(xStart, yStart);

        generateWallCollumn(xStart, yStart);
        generateWallCollumn(xStart + roomWidth - 1, yStart);
        generateWallRow(xStart, yStart);
        generateWallRow(xStart, yStart + roomHeight - 1);
    }

    
    /** 
     * A room of type 1 is a room that has a left and a right way-out.
     * Generates a room 1 with an upper-left corner at (xStart, yStart) in data.
     * This room has its height = roomHeight 
     *                    width = roomWidth 
     * @param xStart
     * @param yStart
     */
    public void addRoom1(int xStart, int yStart) {
        generateInnerRoom(xStart, yStart);
        addZombies(xStart, yStart, level);
        addCoins(xStart, yStart);
        
        generateNullCollumn(xStart, yStart);
        generateNullCollumn(xStart + roomWidth - 1, yStart);
        generateWallRow(xStart, yStart);
        generateWallRow(xStart, yStart + roomHeight - 1);
    }

    
   /** 
     * A room of type 2 is a room that has a way-out on every side.
     * Generates a room 2 with an upper-left corner at (xStart, yStart) in data.
     * This room has its height = roomHeight 
     *                    width = roomWidth 
     * @param xStart
     * @param yStart
     */
    public void addRoom2(int xStart, int yStart) {
        generateInnerRoom(xStart, yStart);
        addZombies(xStart, yStart, level);
        addCoins(xStart, yStart);

        generateNullCollumn(xStart, yStart); 
        generateNullCollumn(xStart + roomWidth - 1, yStart); 
        generateNullRow(xStart, yStart + roomHeight - 1); 
        generateNullRow(xStart, yStart);
    }

    /** 
     * A room of type 3 is a room that has a way out on every side except on the bottom.
     * Generates a room 3 with an upper-left corner at (xStart, yStart) in data.
     * This room has its height = roomHeight 
     *                    width = roomWidth 
     * @param xStart
     * @param yStart
     */
    public void addRoom3(int xStart, int yStart) { //Has exits on the left, right and top.
        generateInnerRoom(xStart, yStart);
        addZombies(xStart, yStart, level);
        addCoins(xStart, yStart);

        generateNullCollumn(xStart, yStart);
        generateNullCollumn(xStart + roomWidth - 1, yStart); 
        generateNullRow(xStart, yStart);
        generateWallRow(xStart, yStart + roomHeight - 1);

    }
    
    
    /** 
     * @param x
     * @param y
     * @param ent
     */
    public void addEntity(int x, int y, Entity ent) {
        data[x][y] = ent ;
    }

    
    /** 
     * @return AsciiCharacterData[][]
     */
    public AsciiCharacterData[][] generateCharGrid() {
        AsciiCharacterData[][] grid = new AsciiCharacterData[width][height];
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                grid[x][y] = new AsciiCharacterData(this.data[x][y].getGlyph(), this.data[x][y].getColor(), Color.BLACK);
            }
        }
        return grid ;
    }

    
    /** 
     * @param ws
     * @return boolean
     */
    public boolean equals(Worldstructure ws) {
        if (Arrays.deepEquals(this.data, ws.getData())) {
            return true ;
        }
        else {
            return false ;
        }
    }

    
    /** 
     * @param width
     * @param height
     * @return Entity[][]
     */
    private Entity[][] initiateData(int width, int height) {
        Entity[][] data = new Entity[width][height];
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                data[x][y] = new NullEntity(x, y);
            }
        }
        return data ;
    }

    
    /** 
     * @param xStart
     * @param yStart
     */
    private void generateInnerRoom(int xStart, int yStart) {
        nestedloops :
        for (int x = xStart + 2 ; x < xStart + roomWidth - 4 ; x++) {
            for (int y = yStart + 2 ; y < yStart + roomHeight - 4 ; y++) {
                if (r.nextInt(15) == 0) {
                    generateSquare(x, y);
                    break nestedloops;
                }
            }
        }
    }

    
    /** 
     * @param xStart
     * @param yStart
     */
    private void generateSquare(int xStart, int yStart) {
        for (int x = xStart ; x < xStart + 2 ; x++) {
            for (int y = yStart ; y < yStart + 2 ; y++) {
                this.data[x][y] = new Wall(x, y) ;
            }
        }
    }

     /** 
     * Generates a row with an exit, starting at (xStart, yStart) of width = roomWidth
     * @param xStart
     * @param yStart
     */
    private void generateNullRow(int xStart, int yStart) {
        for (int x = xStart ; x < xStart + roomWidth ; x++) {
            if (x == xStart + 3 || x == xStart + 4) {
                this.data[x][yStart] = new NullEntity(x, yStart);
            }
            else {
                this.data[x][yStart] = new Wall(x, yStart);
            }
        }
    }

    
    /** 
     * Generates a collumn with an exit, starting at (xStart, yStart) of height = roomHeight
     * @param xStart
     * @param yStart
     */
    private void generateNullCollumn(int xStart, int yStart) {
        for (int y = yStart ; y < yStart + roomHeight ; y++) {
            if (y == yStart + 3 || y == yStart + 4) {
                this.data[xStart][y] = new NullEntity(xStart, y);
            }
            else {
                this.data[xStart][y] = new Wall(xStart, y);
            }
        }
    }

    
    /** 
     * Generates a wall row starting at (xStart, yStart) of width = roomWidth
     * @param xStart
     * @param yStart
     */
    private void generateWallRow(int xStart, int yStart) {
        for (int x = xStart ; x < xStart + roomWidth ; x++) {
            this.data[x][yStart] = new Wall(x, yStart);
        }
    }

    
    /** 
     * Generates a wall collumn starting at (xStart, yStart) of height = roomHeight
     * @param xStart
     * @param yStart
     */
    private void generateWallCollumn(int xStart, int yStart) {
        for (int y = yStart ; y < yStart + roomHeight ; y++) {
            this.data[xStart][y] = new Wall(xStart, y);
        }
    }

    
    /** 
     * @param xStart
     * @param yStart
     * @param seed
     */
    private void addZombies(int xStart, int yStart, int seed) {
        for (int i = xStart + 2 ; i < xStart + roomWidth - 4 ; i++) {
            for (int j = yStart + 2 ; j < yStart + roomHeight - 4 ; j++) {
                if (r.nextInt(seed) == 0) {
                    this.data[i][j] = new Zombie(i, j) ;
                }
            }
        }
    }

    
    /** 
     * @param xStart
     * @param yStart
     */
    private void addCoins(int xStart, int yStart) {
        for (int i = xStart + 2 ; i < xStart + roomWidth - 4 ; i++) {
            for (int j = yStart + 2 ; j < yStart + roomHeight - 4 ; j++) {
                if (r.nextInt(25) == 0) {
                    this.data[i][j] = new Coin(i, j) ;
                }
            }
        }
    }
}
