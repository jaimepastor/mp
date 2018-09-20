package Model;

import Controller.GameController;

/**
 * Specific Class for the Fertilizer Tool.
 */
public class Fertilizer extends Tool {

    /**
     * Constructor for the Fertilizer tool
     * @param information represents information related to the Tool.
     */
    public Fertilizer(String information){
        super(information);
    }

    /**
     * Overwritten Abstract method for useTool
     * @param tile represents tile to be acted on
     * @param gc represents Controller associated with the model.
     */
    @Override
    public void useTool(Tile tile, GameController gc) {
        tile.setNoOfFertilizes(tile.getNoOfFertilizes() + 1);//ITS IN TILE
        tile.setFertilizeStatus(true);
        gc.changeTile(tile.getCoordinate(), "fertilizer");

    }
}
