package Model;

import Model.Crop;

public class Tile
{
    private int xCoord;
    private int yCoord;
    private boolean plowStatus;
    private boolean waterStatus;
    private boolean spaceStatus;
    private boolean rockStatus;
    private boolean witherStatus;
    private Crop heldCrop;

    public Tile(int yCoord, int xCoord, boolean rock){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.plowStatus = false;
        this.waterStatus = false;
        this.spaceStatus = true;
        this.rockStatus = rock;
        this.witherStatus = false;
        this.heldCrop = null;
    }

    public void setPlowStatus(boolean plowStatus) {
        this.plowStatus = plowStatus;
    }

    public void setWaterStatus(boolean waterStatus) {
        this.waterStatus = waterStatus;
    }

    public void setSpaceStatus(boolean spaceStatus) {
        this.spaceStatus = spaceStatus;
    }

    public void setRockStatus(boolean rockStatus) {
        this.rockStatus = rockStatus;
    }

    public void setWitherStatus(boolean witherStatus) {
        this.witherStatus = witherStatus;
    }

    public void setHeldCrop(Crop heldCrop) {
        this.heldCrop = heldCrop;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public boolean getPlowStatus(){
        return this.plowStatus;
    }

    public boolean getWaterStatus(){
        return this.waterStatus;
    }

    public boolean getSpaceStatus(){
        return this.spaceStatus;
    }

    public boolean getRockStatus(){
        return this.rockStatus;
    }

    public boolean getWitherStatus(){
        return this.witherStatus;
    }

    public Crop getHeldCrop() {
        return heldCrop;
    }

    public String toString(){
        return "xCoord: " + xCoord + "\nyCoord: " + yCoord + "\nIs Plowed: " + Boolean.toString(plowStatus) + "\nIs Watered: " + Boolean.toString(waterStatus)
                + "\nHas Rock: " + Boolean.toString(rockStatus) + "\nHas Space: " + Boolean.toString(spaceStatus) + "\nIs Crop Withered: " + Boolean.toString(witherStatus) + "\nCurrent Crop: "/* + heldCrop.getSeedName()*/;
    }
}