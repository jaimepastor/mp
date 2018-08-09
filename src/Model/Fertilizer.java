package Model;

import Controller.GameController;

public class Fertilizer extends Tool {

    public Fertilizer(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile, GameController gc) {
        if(tile.getHeldCrop().getNoOfFertilizes() >= tile.getHeldCrop().getFertilizerNeeded()){
            tile.setFertilizeStatus(true);
            gc.changeTile(tile.getCoordinate(), "fertilizer");
        }

        tile.getHeldCrop().setNoOfFertilizes(tile.getHeldCrop().getNoOfFertilizes() + 1);
    }
}
