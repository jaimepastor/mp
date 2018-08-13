package Model;

import Controller.GameController;

public class WateringCan extends Tool
{
    public WateringCan(String name, String information){
        super(name, information);
    }

    @Override
    public void useTool(Tile tile, GameController gc){
        tile.setNoOfWaters(tile.getNoOfWaters() + 1);
        if(tile.getNoOfWaters() >= tile.getHeldCrop().getWaterNeeded()){
            tile.setWaterStatus(true);
            gc.changeTile(tile.getCoordinate(), "wateringCan");
        }

    }
}