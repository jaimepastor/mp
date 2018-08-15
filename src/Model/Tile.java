package Model;

import Controller.GameController;

/**
 * Class for the individual Tiles.
 */
public class Tile
{
    //private int xCoord;
    //private int yCoord;
    private int coordinate;
    private boolean plowStatus;//true means its plowed
    private boolean waterStatus;//true means its watered as required
    private boolean fertilizeStatus;// true means its fertilized as required
    private boolean spaceStatus;//true means there is space
    private boolean rockStatus;//true means there is a rock
    private boolean witherStatus;//plant is withered??
    private Crop heldCrop;
    private int noOfWaters;
    private int noOfFertilizes;
    private double sellingPrice;

    /**
     * Constructor for the Tiles.
     * @param coordinate represents coordinate of Tile.
     * @param rock represents if tile has rock.
     */
    public Tile(int coordinate, boolean rock){
        //this.xCoord = xCoord;
        //this.yCoord = yCoord;
        this.coordinate = coordinate;
        this.plowStatus = false;
        this.waterStatus = false;
        this.fertilizeStatus = false;
        this.rockStatus = rock;
        this.spaceStatus = !rock;
        this.witherStatus = false;
        this.heldCrop = null;
        this.noOfFertilizes = 0;
        this.noOfWaters = 0;
        this.sellingPrice = 0;
    }

    /**
     * Setter for Plow Status
     * @param plowStatus represents plow status of the tile in boolean
     */
    public void setPlowStatus(boolean plowStatus) {
        this.plowStatus = plowStatus;
    }

    /**
     * Setter for Water Status
     * @param waterStatus represents water status of the tile in boolean
     */
    public void setWaterStatus(boolean waterStatus) {
        this.waterStatus = waterStatus;
    }

    /**
     * Setter for Space Status
     * @param spaceStatus represents presence of space in the tile in boolean
     */
    public void setSpaceStatus(boolean spaceStatus) {
        this.spaceStatus = spaceStatus;
    }

    /**
     * Setter for Rock Status
     * @param rockStatus represents presence of rocks int the tile in boolean
     */
    public void setRockStatus(boolean rockStatus) {
        this.rockStatus = rockStatus;
    }

    /**
     * Changes the status of the Tile to withered, indicating that the Crop should be in withered state.
     * @param gc
     */
    public void witherTile(GameController gc) {
        this.witherStatus = true;
        gc.displayStatus(heldCrop.getCropName() + " in tile " + (coordinate + 1) + " has withered! Plow it for " + (heldCrop.getSeedCost() / 10.0));
    }

    /**
     * Setter for Fertilized Status
     * @param fertilizeStatus represents fertilize status of the tile in boolean
     */
    public void setFertilizeStatus(boolean fertilizeStatus) {
        this.fertilizeStatus = fertilizeStatus;
    }

    /**
     * Setter for the Held Crop of the Tile.
     * @param heldCrop represents the Crop that the Tile will hold.
     */
    public void setHeldCrop(Crop heldCrop) {
        this.heldCrop = heldCrop;
    }

    /**
     * Setter for Number of times the Tile was watered.
     * @param noOfWaters represents the number of times this action occurred.
     */
    public void setNoOfWaters(int noOfWaters) {
        this.noOfWaters = noOfWaters;
    }

    /**
     * Setter for Number of times the Tile was fertilized.
     * @param noOfFertilizes represents the number of times this action occurred.
     */
    public void setNoOfFertilizes(int noOfFertilizes) {
        this.noOfFertilizes = noOfFertilizes;
    }

    /**
     * Getter for the coordinate of this Tile.
     * @return returns int value of the coordinate.
     */
    public int getCoordinate(){
        return coordinate;
    }

    /**
     * Getter for the Plow Status of the Tile.
     * @return returns the boolean value of the plow status.
     */
    public boolean getPlowStatus(){
        return this.plowStatus;
    }


    /**
     * Getter for the Space Status of the Tile.
     * @return returns the boolean value of the Space status.
     */
    public boolean getSpaceStatus(){
        return this.spaceStatus;
    }

    /**
     * Getter for the RockStatus of the Tile.
     * @return returns the boolean value of the Rock status.
     */
    public boolean getRockStatus(){
        return this.rockStatus;
    }

    /**
     * Getter for the Wither Status of the Tile.
     * @return returns the boolean value of the Wither status.
     */
    public boolean getWitherStatus(){
        return this.witherStatus;
    }

    /**
     * Getter for the Number of Fertilizes on the Tile.
     * @return returns the int value of that number.
     */
    public int getNoOfFertilizes() {
        return noOfFertilizes;
    }

    /**
     * Getter for the Number of Waters on the Tile.
     * @return returns the int value of that number.
     */
    public int getNoOfWaters() {
        return noOfWaters;
    }

    /**
     * Getter for the Crop on the Tile.
     * @return returns the Crop.
     */
    public Crop getHeldCrop() {
        return heldCrop;
    }

    /**
     * Resets the Tile to what it was when the Lot was first instantiated and the tiles were initialized.
     */
    public void resetTile(){
        this.spaceStatus = true;
        this.plowStatus = false;
        this.waterStatus = false;
        this.fertilizeStatus = false;
        this.witherStatus = false;
        this.noOfWaters = 0;
        this.noOfFertilizes = 0;
        this.sellingPrice = 0;
        this.heldCrop = null;
    }

    /**
     * Overwritten method for the Object superclass toString.
     * @return returns the coordinate, plowStatus, waterStaatus, rockStatus, spaceStatus, witherStatus, and cropName values in a formatted String.
     */
    public String toString(){
        String information = "Coordinate: " + (coordinate + 1) + "\nIs Plowed: " + Boolean.toString(plowStatus) + "\nIs Watered: " + Boolean.toString(waterStatus)
                + "\nHas Rock: " + Boolean.toString(rockStatus) + "\nHas Space: " + Boolean.toString(spaceStatus) + "\nIs Crop Withered: " + Boolean.toString(witherStatus) + "\nCurrent Crop: ";
        if(heldCrop == null)
            return information.concat("null");
        else
           return information.concat(heldCrop.getCropName());
    }
}