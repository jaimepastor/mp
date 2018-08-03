package Model;

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

    public Tile getTile(int xCoord, int yCoord){
        return tiles[xCoord][yCoord];
    }

    private void initializeTiles(){
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 10; j++)
                tiles[i][j] = new Tile(i, j);
    }
}