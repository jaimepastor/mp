package Model;

/**
 * Superclass for all the crops.
 */
public class Crop
{
    private String cropName;
    private String type;
    private double harvestTime;
    private int waterNeeded;
    private int highWaterNeeded;
    private int fertilizerNeeded;
    private int highFertilizerNeeded;
    private int harvestCost;
    private int noPrdctsPrdced;
    private int seedCost;
    private double basePrice;
    private double sellingPrice;
    private double cropBonus;
    private boolean witherStatus;
    private int witherTime;
    private int prdctStayTime;
    private int xpResult;
    private int farmerLevelBonus;

    /**
     * Constructor for Crop class
     * @param sn Seed or Crop Name
     * @param type Type of Seed or Crop
     * @param ht Harvest Time in minutes, with harvest time bonus applied
     * @param wn Water Needed, lower requirement
     * @param hwn High Water Needed, higher requirement
     * @param fn Fertilizer Needed, lower requirement
     * @param hfn High Fertilizer Needed, higher Requirement
     * @param hc Harvest Cost
     * @param npp Number of Products Produced
     * @param sc Seed Cost
     * @param bp Base Price
     * @param cb Crop Bonus
     * @param xp Individual xp rewarded on harvest.
     * @param flb Farmer Level Bonus, given by Farmer
     */
    public Crop(String sn, String type, double ht, int wn, int hwn, int fn, int hfn, int hc, int npp, int sc, double bp, int cb, int xp, int flb){
        this.cropName = sn;
        this.type = type;
        this.harvestTime = ht * 60;//converts harvest time to seconds
        this.waterNeeded = wn;
        this.highWaterNeeded = hwn;
        this.fertilizerNeeded = fn;
        this.highFertilizerNeeded = hfn;
        this.harvestCost = hc;
        this.noPrdctsPrdced = npp;
        this.seedCost = sc;
        this.cropBonus = cb;
        this.xpResult = xp;
        this.basePrice = bp;
        this.witherStatus = false;
        this.witherTime = 0;
        this.prdctStayTime = 0;
        this.sellingPrice = 0;
        this.farmerLevelBonus = flb;

    }

    /**
     * Getter for Crop type
     * @return String of Crop type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for Harvest Time, with bonus applied already.
     * @return double value of Harvest Time.
     */
    public double getHarvestTime() {
        return harvestTime;
    }

    /**
     * Getter for lower requirement for watering
     * @return int value of lower water needed
     */
    public int getWaterNeeded() {
        return waterNeeded;
    }

    /**
     * Getter for higher requirement for watering
     * @return int value of higher water needed
     */
    public int getHighWaterNeeded() {
        return highWaterNeeded;
    }

    /**
     * Getter for lower fertilizer for watering
     * @return int value of lower fertilizer needed
     */
    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }


    /**
     * Getter for higher requirement for watering
     * @return int value of higher water needed
     */
    public int getHighFertilizerNeeded() {
        return highFertilizerNeeded;
    }

    /**
     * Getter for the Harvest Cost attribute.
     * @return returns int value of Harvest Cost.
     */
    public int getHarvestCost() {
        return harvestCost;
    }

    /**
     * Getter for the NoPrdctsPrdced attribute.
     * @return returns int value of NoPrdctsPrdced.
     */
    public int getNoPrdctsPrdced() {
        return noPrdctsPrdced;
    }

    /**
     * Getter for the Seed Cost attribute.
     * @return returns int value of Seed Cost.
     */
    public int getSeedCost() {
        return seedCost;
    }

    /**
     * Getter for the Base Oruce attribute.
     * @return returns double value of Base PRice.
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Getter for the Crop Bonus attribute.
     * @return returns double value of Crop Bonys.
     */
    public double getCropBonus() {
        return cropBonus;
    }

    /**
     * Getter for the XP Result attribute.
     * @return returns int value of XP Result.
     */
    public int getXpResult() {
        return xpResult;
    }

    /**
     * Computes Selling Prices given the Number of Waters and Feritlizes on the Tile holding the Crop.
     * @param noOfWaters represents Number of Waters on the Tile
     * @param noOfFertilizes represents Number of Fertilizes on the Tile
     * @return returns the computed Selling Price given the formula sp = flb + bp + wb + fb + cb.
     */
    public double computeSellingPrice(int noOfWaters, int noOfFertilizes){
        double wb, fb;

        if(noOfWaters >= highWaterNeeded)
            wb = 1.0 * highWaterNeeded * basePrice / 4;
        else
            wb = 1.0 * noOfWaters * basePrice / 4;

        if(noOfFertilizes >= highFertilizerNeeded)
            fb = 1.0 * highFertilizerNeeded * basePrice / 4;
        else
            fb = 1.0 * highFertilizerNeeded * basePrice / 4;

        this.sellingPrice = farmerLevelBonus + basePrice + wb + fb + cropBonus;

        return sellingPrice;
    }

    /**
     * Getter for the Crop Name.
     * @return
     */
    public String getCropName(){
        return cropName;
    }

    /**
     * Overwritten method of toString.
     * @return returns String assortment of name, type, harvest Time, base price, seedcost, lower fertilizer and water needed, and xp result.
     */
    @Override
    public String toString() {
        return  "Seed Name: " + cropName +
                "\nCrop type: " + type +
                "\nHarvest Time: " + harvestTime +
                "\nBase Price: " + basePrice +
                "\nSeed Cost: " + seedCost +
                "\nNeeded amount of Fertilizer: " + fertilizerNeeded +
                "\nNeeded amount of Water: " + waterNeeded +
                "\nXP Result: " + xpResult + "\n";

    }
}


