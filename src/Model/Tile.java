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

    public Tile(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.plowStatus = false;
        this.waterStatus = false;
        this.spaceStatus = true;
        this.rockStatus = false;
        this.witherStatus = false;
        this.heldCrop = null;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
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
}