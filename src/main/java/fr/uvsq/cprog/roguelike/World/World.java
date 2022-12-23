package fr.uvsq.cprog.roguelike.World;

import java.util.Random;

import asciiPanel.AsciiCharacterData;
import fr.uvsq.cprog.roguelike.UI.UserInterface;


public class World {
    private static int width = UserInterface.pixelsInWidth ;
    private static int height = UserInterface.pixelsInHeight ; 
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


    public World(int level){
        if (level >= 0 && level < 14){
            this.level = level;
            this.layout = new Worldstructure(width, height, level) ; 
        }
        else{
            this.level = 0 ;
            this.layout = new Worldstructure(width, height, 0) ;
        }
        generateWorld();
    }

    public Worldstructure getLayout(){
        return this.layout ;
    }

    public int[][] getRoomLayout(){
        return this.roomLayout ;
    }

    private void generateWorld(){
        int w = this.layout.getRoomWidth();
        int h = this.layout.getRoomHeight();
        layout.addRoom1(0, 0);
        roomLayout[0][0] = 1;
        SolutionPath path = new SolutionPath();
        boolean carryOn = true ;
        int randomInt ;
        while(carryOn){
            randomInt = r.nextInt(5) ; 
            if(randomInt == 0 || randomInt == 1){
                carryOn = caseLeft(path, w, h);
            }
            else if(randomInt == 2 || randomInt == 3){
                carryOn = caseRight(path, w, h);
            }
            else{
                carryOn = caseDown(path, w, h);
            }
        }
        fillVoidRooms();
    }

    private boolean caseLeft(SolutionPath path, int w, int h){
        String output = path.moveLeft();
        boolean carryOn = processPathOutput(output); 
        int x = path.getX();
        int y = path.getY();
        if (output == "LEFT"){
            if (roomLayout[x][y] != 2 && roomLayout[x][y] != 3){
                layout.addRoom1(x*w, y*h);
                roomLayout[x][y] = 1;
            }
        }
        else if (output == "DOWN"){
            layout.addRoom2(x*w, (y-1)*h);
            layout.addRoom3(x*w, y*h);
            roomLayout[x][y-1] = 2;
            roomLayout[x][y] = 3;
        }
        return carryOn ;
    }

    private boolean caseRight(SolutionPath path, int w, int h){
        String output = path.moveRight();
        boolean carryOn = processPathOutput(output); 
        int x = path.getX();
        int y = path.getY();
        if (output == "RIGHT"){
            if (roomLayout[x][y] != 2 && roomLayout[x][y] != 3){
                layout.addRoom1(x*w, y*h);
                roomLayout[x][y] = 1;
            }
        }
        else if (output == "DOWN"){
            layout.addRoom2(x*w, (y-1)*h);
            layout.addRoom3(x*w, y*h);
            roomLayout[x][y-1] = 2;
            roomLayout[x][y] = 3;
        }
        return carryOn ;
    }

    private boolean caseDown(SolutionPath path, int w, int h){
        String output = path.moveDown() ; 
        boolean carryOn = processPathOutput(output);
        int x = path.getX();
        int y = path.getY();
        if (output == "DOWN"){
            layout.addRoom2(x*w, (y-1)*h);
            layout.addRoom3(x*w, y*h);
            roomLayout[x][y-1] = 2;
            roomLayout[x][y] = 3;
        }
        return carryOn ;
    }

    private boolean processPathOutput(String s){
        switch(s){
            case("LEFT"):
                return true ;
            case("RIGHT"):
                return true ;
            case("DOWN"):
                return true ;
            case("STOP"):
                return false ;
            default :
                return true ;
        }
    }

    public AsciiCharacterData[][] generateCharGrid(){
        return this.layout.generateCharGrid();
    }
    
    private void fillVoidRooms(){
        int w = this.layout.getRoomWidth();
        int h = this.layout.getRoomHeight();
        for (int x = 0 ; x<8 ; x++){
            for (int y = 0 ; y<6 ; y++){
                if (roomLayout[x][y] == 0){
                    layout.addRoom0(x*w, y*h);
                }
            }
        }
    }

    private static void seeRoomLayout(){
        World world = new World(0);
        for (int x = 0 ; x<6 ; x++){
            for (int y = 0 ; y<8 ; y++){
                System.out.print(world.roomLayout[y][x] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        seeRoomLayout();
    }
}
