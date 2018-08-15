package Model;

import Controller.GameController;

/**
 * Player is the main model class and where all the model-related methods are located.
 *
 * @Author Jaime Alfonso R. Pastor 11726024
 * @Version 1.00
 */
public abstract class Tool
{
    private String information;

    /**
     * Abstract Constructor for Tool superclass
     * @param information
     */
    public Tool(String information){
        this.information = information;
    }

    /**
     * Getter for Information on Tool.
     * @return
     */
    public String getInformation() {
        return information;
    }

    /**
     * Abstract method for useTool
     * @param tile represents tile to be acted on
     * @param gc represents Controller associated with the model.
     */
    public abstract void useTool(Tile tile, GameController gc);
}