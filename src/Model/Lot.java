package Model;

import java.util.Random;

public class Lot
{
    private Tile[][] tiles;

    public Lot(){
        tiles = new Tile[5][10];
        initializeTiles();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(int yCoord, int xCoord){
        return tiles[yCoord][xCoord];
    }

    private void initializeTiles(){
        Random r = new Random();
        for(int y = 0; y < 5; y++)
            for(int x = 0; x < 10; x++)
                tiles[y][x] = new Tile(y, x, r.nextBoolean());//ROCKDIMIZER
    }
}