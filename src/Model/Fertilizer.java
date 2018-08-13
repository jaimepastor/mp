package Model;

import Controller.GameController;

public class Fertilizer extends Tool {

    public Fertilizer(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile, GameController gc) {
        if(tile.getNoOfFertilizes() >= tile.getHeldCrop().getFertilizerNeeded()){//ITS IN TILE
            tile.setFertilizeStatus(true);
            gc.changeTile(tile.getCoordinate(), "fertilizer");
        }

        tile.setNoOfFertilizes(tile.getNoOfFertilizes() + 1);
    }
}
