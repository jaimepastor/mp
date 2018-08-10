package Model;

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
        this.sellingPrice = 0;
    }

    public boolean treeValid(Tile up, Tile upRight, Tile right, Tile downRight, Tile down, Tile downLeft, Tile left, Tile upLeft, Tile current){
        switch(current.getCoordinate()){
            case 0 : if (down.getSpaceStatus() == true && right.getSpaceStatus() == true && downRight.getSpaceStatus() == true)//upper left corner
                    return true;
                break;
            case 9 :  if(down.getSpaceStatus() == true && left.getSpaceStatus() == true && downLeft.getSpaceStatus() == true)//upper right corner
                    return true;
                break;
            case 40 : if(up.getSpaceStatus() == true && right.getSpaceStatus() == true && upRight.getSpaceStatus() == true)//lower left corner
                    return true;
                break;
            case 49 : if(up.getSpaceStatus() == true && left.getSpaceStatus() == true && upLeft.getSpaceStatus() == true)//lower right corner
                    return true;
                break;
            case 10 : case 20 : case 30 : //left side
                if(up.getSpaceStatus() == true && down.getSpaceStatus() == true && right.getSpaceStatus() == true && upRight.getSpaceStatus() == true && downRight.getSpaceStatus() == true)
                    return true;
                break;
            case 19 : case 29 : case 39 : //right side
                if(up.getSpaceStatus() == true && down.getSpaceStatus() == true && left.getSpaceStatus() == true && upLeft.getSpaceStatus() == true && downLeft.getSpaceStatus() == true)
                    return true;
                break;
            case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 : case 8 : //top side
                if(down.getSpaceStatus() == true && left.getSpaceStatus() == true && right.getSpaceStatus() == true && downLeft.getSpaceStatus() == true && downRight.getSpaceStatus() == true)
                    return true;
                break;
            case 41 : case 42 : case 43 : case 44 : case 45 : case 46 : case 47 : case 48 : //bottom side
                if(up.getSpaceStatus() == true && left.getSpaceStatus() == true && right.getSpaceStatus() == true && upLeft.getSpaceStatus() == true && upRight.getSpaceStatus() == true)
                    return true;
                break;
            default : //everything inside
                if(up.getSpaceStatus() == true && down.getSpaceStatus() == true && right.getSpaceStatus() == true && left.getSpaceStatus() == true &&
                        upRight.getSpaceStatus() == true && downRight.getSpaceStatus() == true && downLeft.getSpaceStatus() == true && upLeft.getSpaceStatus() == true)
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

    public void setFertilizeStatus(boolean fertilizeStatus) {
        this.fertilizeStatus = fertilizeStatus;
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

    public boolean getFertilizeStatus() {
        return fertilizeStatus;
    }

    public int getNoOfFertilizes() {
        return noOfFertilizes;
    }

    public int getNoOfWaters() {
        return noOfWaters;
    }

    public Crop getHeldCrop() {
        return heldCrop;
    }

    private double computeSellingPrice(Type type){
        this.sellingPrice = type.getEarnBuyBonus() + heldCrop.getBasePrice() + noOfWaters * (heldCrop.getBasePrice() / 4.0) + noOfFertilizes * (heldCrop.getBasePrice() / 2.0) + heldCrop.getCropBonus();
        return sellingPrice;
    }

    public String toString(){
        String information = "Coordinate: " + coordinate + "\nIs Plowed: " + Boolean.toString(plowStatus) + "\nIs Watered: " + Boolean.toString(waterStatus)
                + "\nHas Rock: " + Boolean.toString(rockStatus) + "\nHas Space: " + Boolean.toString(spaceStatus) + "\nIs Crop Withered: " + Boolean.toString(witherStatus) + "\nCurrent Crop: ";
        if(heldCrop == null)
            information.concat("null");
        else
            information.concat(/*heldCrop.getSeedName()*/"JOWI");

        return information;
    }
}