package Model;

import Controller.GameController;

/**
 * Specific Class for the Fertilizer Tool.
 */
public class Plow extends Tool
{
    /**
     * Constructor for the Plow tool
     * @param information represents information related to the Tool.
     */
    public Plow(String information){
        super(information);
    }

    /**
     * Overwritten Abstract method for useTool
     * @param tile represents tile to be acted on
     * @param gc represents Controller associated with the model.
     */
    @Override
    public void useTool(Tile tile, GameController gc){
        System.out.println(tile.getSpaceStatus() + "space");
        if(tile.getSpaceStatus() == true)//if tile has no plant inside
            if(tile.getRockStatus() == false) {//if tile has no rock inside
                tile.setPlowStatus(true);
                gc.changeTile(tile.getCoordinate(), "plow");
            }
            else if(tile.getRockStatus() == true)//if tile has rock
                System.out.println("may rock gago");
        else if(tile.getSpaceStatus() == false){//if tile has a plant inside
                System.out.println("kjsdfjdshf");
                System.out.println(tile.getWitherStatus() + "wither");
            if(tile.getWitherStatus() == true) {
                    System.out.print("harvested without products");
                    tile.setSpaceStatus(true);
                    gc.displayStatus("jowi is a winner");
                }
        }
    }
}