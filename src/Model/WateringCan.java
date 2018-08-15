package Model;

import Controller.GameController;

/**
 * Specific Class for the WateringCan Tool.
 */
public class WateringCan extends Tool
{
    /**
     * Constructor for the Plow tool
     * @param information represents information related to the Tool.
     */
    public WateringCan(String information){
        super(information);
    }

    /**
     * Overwritten Abstract method for useTool
     * @param tile represents tile to be acted on
     * @param gc represents Controller associated with the model.
     */
    @Override
    public void useTool(Tile tile, GameController gc){
        tile.setNoOfWaters(tile.getNoOfWaters() + 1);
        if(tile.getNoOfWaters() >= tile.getHeldCrop().getWaterNeeded()){
            tile.setWaterStatus(true);
            gc.changeTile(tile.getCoordinate(), "wateringCan");
        }

    }
}