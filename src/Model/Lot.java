package Model;

import Controller.GameController;
import java.util.Random;

/**
 * Lot class that holds all the Tiles.
 */
public class Lot
{
    private Tile[] tiles;

    /**
     * Constructor for Lot. Instantiates and Initializes an array of 50 Tiles.
     */
    public Lot(){
        tiles = new Tile[50];
        initializeTiles();
    }

    /**
     * Gets tiles given coordinate
     * @param coordinate represents the coordinate of tile requested.
     * @return returns Tile requested.
     */
    public Tile getTile(int coordinate){
        return tiles[coordinate];
    }

    /**
     * Changes surrounding tiles to tree branches
     * @param current represents center tile of tree
     * @param gc represents associated Controller
     */
    public void disableTiles(Tile current, GameController gc){
        int curCoord = current.getCoordinate();
        switch(curCoord){
            case 0 :
                tiles[curCoord + 10].setSpaceStatus(false);
                gc.changeTile(curCoord + 10, "tree");
                tiles[curCoord + 11].setSpaceStatus(false);
                gc.changeTile(curCoord + 11, "tree");
                tiles[curCoord + 1].setSpaceStatus(false);
                gc.changeTile(curCoord + 1, "tree");
                break;
            case 9 :
                tiles[curCoord + 10].setSpaceStatus(false);
                gc.changeTile(curCoord + 10, "tree");
                tiles[curCoord + 9].setSpaceStatus(false);
                gc.changeTile(curCoord + 9, "tree");
                tiles[curCoord - 1].setSpaceStatus(false);
                gc.changeTile(curCoord - 1, "tree");
                break;
            case 40 :
                tiles[curCoord - 10].setSpaceStatus(false);
                gc.changeTile(curCoord - 10, "tree");
                tiles[curCoord - 9].setSpaceStatus(false);
                gc.changeTile(curCoord - 9, "tree");
                tiles[curCoord + 1].setSpaceStatus(false);
                gc.changeTile(curCoord + 1, "tree");
                break;
            case 49 :
                tiles[curCoord - 10].setSpaceStatus(false);
                gc.changeTile(curCoord - 10, "tree");
                tiles[curCoord - 11].setSpaceStatus(false);
                gc.changeTile(curCoord - 11, "tree");
                tiles[curCoord - 1].setSpaceStatus(false);
                gc.changeTile(curCoord - 1, "tree");
                break;
            case 10 : case 20 : case 30 : //left side
                tiles[curCoord - 10].setSpaceStatus(false);
                gc.changeTile(curCoord - 10, "tree");
                tiles[curCoord - 9].setSpaceStatus(false);
                gc.changeTile(curCoord - 9, "tree");
                tiles[curCoord + 1].setSpaceStatus(false);
                gc.changeTile(curCoord + 1, "tree");
                tiles[curCoord + 11].setSpaceStatus(false);
                gc.changeTile(curCoord + 11, "tree");
                tiles[curCoord + 10].setSpaceStatus(false);
                gc.changeTile(curCoord + 10, "tree");
                break;
            case 19 : case 29 : case 39 : //right side
                tiles[curCoord - 10].setSpaceStatus(false);
                gc.changeTile(curCoord - 10, "tree");
                tiles[curCoord - 11].setSpaceStatus(false);
                gc.changeTile(curCoord - 11, "tree");
                tiles[curCoord - 1].setSpaceStatus(false);
                gc.changeTile(curCoord - 1, "tree");
                tiles[curCoord + 9].setSpaceStatus(false);
                gc.changeTile(curCoord + 9, "tree");
                tiles[curCoord + 10].setSpaceStatus(false);
                gc.changeTile(curCoord + 10, "tree");
                break;
            case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 : //top side
                tiles[curCoord - 1].setSpaceStatus(false);
                gc.changeTile(curCoord - 1, "tree");
                tiles[curCoord + 9].setSpaceStatus(false);
                gc.changeTile(curCoord + 9, "tree");
                tiles[curCoord + 10].setSpaceStatus(false);
                gc.changeTile(curCoord + 10, "tree");
                tiles[curCoord + 11].setSpaceStatus(false);
                gc.changeTile(curCoord + 11, "tree");
                tiles[curCoord + 1].setSpaceStatus(false);
                gc.changeTile(curCoord + 1, "tree");
                break;
            case 41 : case 42 : case 43 : case 44 : case 45 : case 46 : case 47 : case 48 : //bottom side
                tiles[curCoord - 1].setSpaceStatus(false);
                gc.changeTile(curCoord - 1, "tree");
                tiles[curCoord - 11].setSpaceStatus(false);
                gc.changeTile(curCoord - 11, "tree");
                tiles[curCoord - 10].setSpaceStatus(false);
                gc.changeTile(curCoord - 10, "tree");
                tiles[curCoord - 9].setSpaceStatus(false);
                gc.changeTile(curCoord - 9, "tree");
                tiles[curCoord + 1].setSpaceStatus(false);
                gc.changeTile(curCoord + 1, "tree");
                break;
            default : //everything inside
                tiles[curCoord - 1].setSpaceStatus(false);
                gc.changeTile(curCoord - 1, "tree");
                tiles[curCoord - 11].setSpaceStatus(false);
                gc.changeTile(curCoord - 11, "tree");
                tiles[curCoord - 10].setSpaceStatus(false);
                gc.changeTile(curCoord - 10, "tree");
                tiles[curCoord - 9].setSpaceStatus(false);
                gc.changeTile(curCoord - 9, "tree");
                tiles[curCoord + 1].setSpaceStatus(false);
                gc.changeTile(curCoord + 1, "tree");
                tiles[curCoord + 9].setSpaceStatus(false);
                gc.changeTile(curCoord + 9, "tree");
                tiles[curCoord + 10].setSpaceStatus(false);
                gc.changeTile(curCoord + 10, "tree");
                tiles[curCoord + 11].setSpaceStatus(false);
                gc.changeTile(curCoord + 11, "tree");
                break;
        }
    }

    /**
     * Reverts surrounding tiles to unplowed Tiles
     * @param current represents center tile of tree
     * @param gc represents associated Controller
     */
    public void enableTiles(Tile current, GameController gc){
        int curCoord = current.getCoordinate();
        switch(curCoord){
            case 0 :
                tiles[curCoord + 10].setSpaceStatus(true);
                gc.changeTile(curCoord + 10, "removeTree");
                tiles[curCoord + 11].setSpaceStatus(true);
                gc.changeTile(curCoord + 11, "removeTree");
                tiles[curCoord + 1].setSpaceStatus(true);
                gc.changeTile(curCoord + 1, "removeTree");
                break;
            case 9 :
                tiles[curCoord + 10].setSpaceStatus(true);
                gc.changeTile(curCoord + 10, "removeTree");
                tiles[curCoord + 9].setSpaceStatus(true);
                gc.changeTile(curCoord + 9, "removeTree");
                tiles[curCoord - 1].setSpaceStatus(true);
                gc.changeTile(curCoord - 1, "removeTree");
                break;
            case 40 :
                tiles[curCoord - 10].setSpaceStatus(true);
                gc.changeTile(curCoord - 10, "removeTree");
                tiles[curCoord - 9].setSpaceStatus(true);
                gc.changeTile(curCoord - 9, "removeTree");
                tiles[curCoord + 1].setSpaceStatus(true);
                gc.changeTile(curCoord + 1, "removeTree");
                break;
            case 49 :
                tiles[curCoord - 10].setSpaceStatus(true);
                gc.changeTile(curCoord - 10, "removeTree");
                tiles[curCoord - 11].setSpaceStatus(true);
                gc.changeTile(curCoord - 11, "removeTree");
                tiles[curCoord - 1].setSpaceStatus(true);
                gc.changeTile(curCoord - 1, "removeTree");
                break;
            case 10 : case 20 : case 30 : //left side
                tiles[curCoord - 10].setSpaceStatus(true);
                gc.changeTile(curCoord - 10, "removeTree");
                tiles[curCoord - 9].setSpaceStatus(true);
                gc.changeTile(curCoord - 9, "removeTree");
                tiles[curCoord + 1].setSpaceStatus(true);
                gc.changeTile(curCoord + 1, "removeTree");
                tiles[curCoord + 11].setSpaceStatus(true);
                gc.changeTile(curCoord + 11, "removeTree");
                tiles[curCoord + 10].setSpaceStatus(true);
                gc.changeTile(curCoord + 10, "removeTree");
                break;
            case 19 : case 29 : case 39 : //right side
                tiles[curCoord - 10].setSpaceStatus(true);
                gc.changeTile(curCoord - 10, "removeTree");
                tiles[curCoord - 11].setSpaceStatus(true);
                gc.changeTile(curCoord - 11, "removeTree");
                tiles[curCoord - 1].setSpaceStatus(true);
                gc.changeTile(curCoord - 1, "removeTree");
                tiles[curCoord + 9].setSpaceStatus(true);
                gc.changeTile(curCoord + 9, "removeTree");
                tiles[curCoord + 10].setSpaceStatus(true);
                gc.changeTile(curCoord + 10, "removeTree");
                break;
            case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 : //top side
                tiles[curCoord - 1].setSpaceStatus(true);
                gc.changeTile(curCoord - 1, "removeTree");
                tiles[curCoord + 9].setSpaceStatus(true);
                gc.changeTile(curCoord + 9, "removeTree");
                tiles[curCoord + 10].setSpaceStatus(true);
                gc.changeTile(curCoord + 10, "removeTree");
                tiles[curCoord + 11].setSpaceStatus(true);
                gc.changeTile(curCoord + 11, "removeTree");
                tiles[curCoord + 1].setSpaceStatus(true);
                gc.changeTile(curCoord + 1, "removeTree");
                break;
            case 41 : case 42 : case 43 : case 44 : case 45 : case 46 : case 47 : case 48 : //bottom side
                tiles[curCoord - 1].setSpaceStatus(true);
                gc.changeTile(curCoord - 1, "removeTree");
                tiles[curCoord - 11].setSpaceStatus(true);
                gc.changeTile(curCoord - 11, "removeTree");
                tiles[curCoord - 10].setSpaceStatus(true);
                gc.changeTile(curCoord - 10, "removeTree");
                tiles[curCoord - 9].setSpaceStatus(true);
                gc.changeTile(curCoord - 9, "removeTree");
                tiles[curCoord + 1].setSpaceStatus(true);
                gc.changeTile(curCoord + 1, "removeTree");
                break;
            default : //everything inside
                tiles[curCoord - 1].setSpaceStatus(true);
                gc.changeTile(curCoord - 1, "removeTree");
                tiles[curCoord - 11].setSpaceStatus(true);
                gc.changeTile(curCoord - 11, "removeTree");
                tiles[curCoord - 10].setSpaceStatus(true);
                gc.changeTile(curCoord - 10, "removeTree");
                tiles[curCoord - 9].setSpaceStatus(true);
                gc.changeTile(curCoord - 9, "removeTree");
                tiles[curCoord + 1].setSpaceStatus(true);
                gc.changeTile(curCoord + 1, "removeTree");
                tiles[curCoord + 9].setSpaceStatus(true);
                gc.changeTile(curCoord + 9, "removeTree");
                tiles[curCoord + 10].setSpaceStatus(true);
                gc.changeTile(curCoord + 10, "removeTree");
                tiles[curCoord + 11].setSpaceStatus(true);
                gc.changeTile(curCoord + 11, "removeTree");
                break;
        }
    }

    /**
     * Checks if surrounding tiles can allow a tree to be planted
     * @param current represents Aspiring center tile for tree
     * @return returns boolean value of whether planting a tree is allowed on the current tile.
     */
    public boolean treeValid(Tile current){
        int curCoord = current.getCoordinate();
        switch(curCoord){
            case 0 : if (tiles[curCoord + 10].getSpaceStatus() == true && tiles[curCoord + 1].getSpaceStatus() == true && tiles[curCoord + 11].getSpaceStatus() == true)//upper left corner
                return true;
                break;
            case 9 :  if(tiles[curCoord + 10].getSpaceStatus() == true && tiles[curCoord - 1].getSpaceStatus() == true && tiles[curCoord + 9].getSpaceStatus() == true)//upper right corner
                return true;
                break;
            case 40 : if(tiles[curCoord - 10].getSpaceStatus() == true && tiles[curCoord + 1].getSpaceStatus() == true && tiles[curCoord - 9].getSpaceStatus() == true)//lower left corner
                return true;
                break;
            case 49 : if(tiles[curCoord - 10].getSpaceStatus() == true && tiles[curCoord - 1].getSpaceStatus() == true && tiles[curCoord - 11].getSpaceStatus() == true)//lower right corner
                return true;
                break;
            case 10 : case 20 : case 30 : //left side
                if(tiles[curCoord - 10].getSpaceStatus() == true && tiles[curCoord + 10].getSpaceStatus() == true && tiles[curCoord + 1].getSpaceStatus() == true && tiles[curCoord - 9].getSpaceStatus() == true && tiles[curCoord + 11].getSpaceStatus() == true)
                    return true;
                break;
            case 19 : case 29 : case 39 : //right side
                if(tiles[curCoord - 10].getSpaceStatus() == true && tiles[curCoord + 10].getSpaceStatus() == true && tiles[curCoord - 1].getSpaceStatus() == true && tiles[curCoord - 11].getSpaceStatus() == true && tiles[curCoord + 9].getSpaceStatus() == true)
                    return true;
                break;
            case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 : //top side
                if(tiles[curCoord + 10].getSpaceStatus() == true && tiles[curCoord - 1].getSpaceStatus() == true && tiles[curCoord + 1].getSpaceStatus() == true && tiles[curCoord + 9].getSpaceStatus() == true && tiles[curCoord + 11].getSpaceStatus() == true)
                    return true;
                break;
            case 41 : case 42 : case 43 : case 44 : case 45 : case 46 : case 47 : case 48 : //bottom side
                if(tiles[curCoord - 10].getSpaceStatus() == true && tiles[curCoord - 1].getSpaceStatus() == true && tiles[curCoord + 1].getSpaceStatus() == true && tiles[curCoord - 11].getSpaceStatus() == true && tiles[curCoord - 9].getSpaceStatus() == true)
                    return true;
                break;
            default : //everything inside
                if(tiles[curCoord - 10].getSpaceStatus() == true && tiles[curCoord + 10].getSpaceStatus() == true && tiles[curCoord + 1].getSpaceStatus() == true && tiles[curCoord - 1].getSpaceStatus() == true &&
                        tiles[curCoord - 9].getSpaceStatus() == true && tiles[curCoord + 11].getSpaceStatus() == true && tiles[curCoord + 9].getSpaceStatus() == true && tiles[curCoord - 11].getSpaceStatus() == true)
                    return true;
                break;
        }

        return false;
    }

    /**
     * Initializes the Tiles.
     */
    private void initializeTiles(){
        Random r = new Random();
        boolean rock = false;
        for(int y = 0; y < 50; y++)
            tiles[y] = new Tile(y, r.nextBoolean());//ROCKDIMIZER
    }
}