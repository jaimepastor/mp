package Model;

import Model.Crop;

public class Tile
{
    //private int xCoord;
    //private int yCoord;
    private int coordinate;
    private boolean plowStatus;//true means its plowed
    private boolean waterStatus;//true means its watered as required
    private boolean spaceStatus;//true means there is space
    private boolean rockStatus;//true means there is a rock
    private boolean witherStatus;//plant is withered??
    private Crop heldCrop;

    public Tile(int coordinate, boolean rock){
        //this.xCoord = xCoord;
        //this.yCoord = yCoord;
        this.coordinate = coordinate;
        this.plowStatus = false;
        this.waterStatus = false;
        this.rockStatus = rock;
        this.spaceStatus = !rock;
        this.witherStatus = false;
        this.heldCrop = null;
    }

    public boolean treeValid(Tile up, Tile right, Tile down, Tile left, Tile current){
        switch(current.getCoordinate()){
            case 0 : if (down.getSpaceStatus() == true && right.getSpaceStatus() == true)
                    return true;
                break;
            case 9 :  if(down.getSpaceStatus() == true && left.getSpaceStatus() == true)
                    return true;
                break;
            case 40 : if(up.getSpaceStatus() == true && right.getSpaceStatus() == true)
                    return true;
                break;
            case 49 : if(up.getSpaceStatus() == true && left.getSpaceStatus() == true)
                    return true;
                break;
            case 10 : case 20 : case 30 :
                if(up.getSpaceStatus() == true && down.getSpaceStatus() == true && right.getSpaceStatus() == true)
                    return true;
                break;
            case 19 : case 29 : case 39 :
                if(up.getSpaceStatus() == true && down.getSpaceStatus() == true && left.getSpaceStatus() == true)
                    return true;
                break;
            case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 :
                if(down.getSpaceStatus() == true && left.getSpaceStatus() == true && right.getSpaceStatus() == true)
                    return true;
                break;
            case 41 : case 42 : case 43 : case 44 : case 45 : case 46 : case 47 : case 48 :
                if(up.getSpaceStatus() == true && left.getSpaceStatus() == true && right.getSpaceStatus() == true)
                    return true;
                break;
            default :
                if(up.getSpaceStatus() == true && down.getSpaceStatus() == true && right.getSpaceStatus() == true && left.getSpaceStatus() == true)
                    return true;
                break;
        }

        return false;
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

    /*public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }*/

    public int getCoordinate(){
        return coordinate;
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
        return "Coordinate: " + coordinate + "\nIs Plowed: " + Boolean.toString(plowStatus) + "\nIs Watered: " + Boolean.toString(waterStatus)
                + "\nHas Rock: " + Boolean.toString(rockStatus) + "\nHas Space: " + Boolean.toString(spaceStatus) + "\nIs Crop Withered: " + Boolean.toString(witherStatus) + "\nCurrent Crop: "/* + heldCrop.getSeedName()*/;
    }
}