package fr.uvsq.cprog.roguelike.World;

import java.util.Random;

import fr.uvsq.cprog.roguelike.Entities.*;

public class Worldstructure {
    private int width ; 
    private int height ;
    private int roomHeight ;
    private int roomWidth ;
    private Entity[][] data ;
    private static final Random r = new Random() ;

    public Worldstructure(int width, int height){
        this.width = width ;
        this.height = height ;
        this.roomHeight = (int)(height/6) ;
        this.roomWidth = (int)(width/8) ;
        this.data = initiateData(width, height);
    }

    public int getRoomHeight(){
        return this.roomHeight ;
    }

    public int getRoomWidth(){
        return this.roomWidth ;
    }

    public Entity[][] getData(){
        return this.data ;
    }

    public void addRoom0(int xStart, int yStart){
        generateInnerRoom(xStart, yStart);

        generateWallCollumn(xStart, yStart);
        generateWallCollumn(xStart + roomWidth - 1, yStart);
        generateWallRow(xStart, yStart);
        generateWallRow(xStart, yStart + roomHeight - 1);
    }

    public void addRoom1(int xStart, int yStart){
        generateInnerRoom(xStart, yStart);
        
        generateNullCollumn(xStart, yStart);
        generateNullCollumn(xStart+roomWidth - 1, yStart);
        generateWallRow(xStart, yStart);
        generateWallRow(xStart, yStart+roomHeight - 1);
    }

    public void addRoom2(int xStart, int yStart){ //Has exits on the left, right and bottom, if there is another 2 above, it also has a top exit
        generateInnerRoom(xStart, yStart);

        generateNullCollumn(xStart, yStart); 
        generateNullCollumn(xStart+roomWidth - 1, yStart); 
        generateNullRow(xStart, yStart+roomHeight - 1); 
        generateNullRow(xStart, yStart);
    }

    public void addRoom3(int xStart, int yStart){ //Has exits on the left, right and top.
        generateInnerRoom(xStart, yStart);

        generateNullCollumn(xStart, yStart);
        generateNullCollumn(xStart+roomWidth - 1, yStart); 
        generateNullRow(xStart, yStart);
        generateWallRow(xStart, yStart+roomHeight - 1);

    } 

    public char[][] generateCharGrid(){
        char[][] grid = new char[width][height];
        for (int x=0 ; x<width ; x++){
            for (int y=0; y<height ; y++){
                grid[x][y] = this.data[x][y].getGlyph();
            }
        }
        return grid ;
    }

    private Entity[][] initiateData(int width, int height){
        Entity[][] data = new Entity[width][height];
        for (int x = 0 ; x<width ; x++){
            for (int y = 0 ; y<height ; y++){
                data[x][y] = new NullEntity(x, y);
            }
        }
        return data ;
    }

    private void generateInnerRoom(int xStart, int yStart){
        nestedloops :
        for (int x = xStart + 2 ; x < xStart + roomWidth - 4 ; x++){
            for (int y = yStart + 2 ; y < yStart + roomHeight - 4 ; y++){
                if (r.nextInt(15) == 0){
                    generateSquare(x, y);
                    break nestedloops;
                }
            }
        }
    }

    private void generateSquare(int xStart, int yStart){
        for (int x = xStart ; x < xStart+2 ; x++){
            for (int y = yStart ; y < yStart+2 ; y++){
                this.data[x][y] = new Wall(x, y) ;
            }
        }
    }

    private void generateNullRow(int xStart, int yStart){
        for (int x = xStart ; x < xStart + roomWidth ; x++){
            if ( x == xStart + 3 || x == xStart + 4){
                this.data[x][yStart] = new NullEntity(x, yStart);
            }
            else{
                this.data[x][yStart] = new Wall(x, yStart);
            }
        }
    }

    private void generateNullCollumn(int xStart, int yStart){
        for (int y = yStart ; y < yStart + roomHeight ; y++){
            if ( y == yStart + 3 || y == yStart + 4){
                this.data[xStart][y] = new NullEntity(xStart, y);
            }
            else{
                this.data[xStart][y] = new Wall(xStart, y);
            }
        }
    }

    private void generateWallRow(int xStart, int yStart){
        for (int x = xStart ; x < xStart + roomWidth ; x++){
            this.data[x][yStart] = new Wall(x, yStart);
        }
    }

    private void generateWallCollumn(int xStart, int yStart){
        for (int y = yStart ; y < yStart + roomHeight ; y++){
            this.data[xStart][y] = new Wall(xStart, y);
        }
    }
}
