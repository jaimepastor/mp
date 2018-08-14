package Model;

import java.util.Random;

public class Lot
{
    private Tile[] tiles;

    public Lot(){
        tiles = new Tile[50];
        initializeTiles();
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tile getTile(int coordinate){
        return tiles[coordinate];
    }

    private void initializeTiles(){
        Random r = new Random();
        boolean rock = false;
        for(int y = 0; y < 50; y++)
            tiles[y] = new Tile(y, r.nextBoolean());//ROCKDIMIZER
    }
}