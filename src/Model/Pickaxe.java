package Model;

import Controller.GameController;

/**
 * Specific Class for the Fertilizer Tool.
 */
public class Pickaxe extends Tool
{
    /**
     * Constructor for the Pickaxe tool
     * @param information represents information related to the Tool.
     */
    public Pickaxe(String information){
        super(information);
    }

    /**
     * Overwritten Abstract method for useTool
     * @param tile represents tile to be acted on
     * @param gc represents Controller associated with the model.
     */
    @Override
    public void useTool(Tile tile, GameController gc){
        tile.setRockStatus(false);
        tile.setSpaceStatus(true);
        gc.changeTile(tile.getCoordinate(), "pickaxe");
    }
}