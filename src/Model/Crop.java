package Model;

public class Crop
{
    private String seedName;
    private String type;
    private double harvestTime;
    private int waterNeeded;
    private int fertilizerNeeded;
    private int harvestCost;
    private int noPrdctsPrdced;
    private int seedCost;
    private double basePrice;
    private double sellingPrice;
    private int noOfWaters;
    private int noOfFertilizes;
    private int cropBonus;
    private boolean witherStatus;
    private int witherTime;
    private int prdctStayTime;
    private int xpResult;

    public Crop(String sn, String type, double ht, int wn, int fn, int hc, int npp, int sc, double bp, int cb, int xp){
        this.seedName = sn;
        this.type = type;
        this.harvestTime = ht * 60;//converts harvest time to seconds
        this.waterNeeded = wn;
        this.fertilizerNeeded = fn;
        this.harvestCost = hc;
        this.noPrdctsPrdced = npp;
        this.seedCost = sc;
        this.cropBonus = cb;
        this.xpResult = xp;
        this.basePrice = bp;

        this.noOfFertilizes = 0;
        this.noOfWaters = 0;
        this.witherStatus = false;
        this.witherTime = 0;
        this.prdctStayTime = 0;
        this.sellingPrice = 0;
    }
    private double computeSellingPrice(Type type){
        this.sellingPrice = type.getEarnBuyBonus() + basePrice + noOfWaters * (basePrice / 4.0) + noOfFertilizes * (basePrice / 2.0) + cropBonus;
        return sellingPrice;
    }

    public void setNoOfWaters(int noOfWaters) {
        this.noOfWaters = noOfWaters;
    }

    public void setNoOfFertilizes(int noOfFertilizes) {
        this.noOfFertilizes = noOfFertilizes;
    }

    public String getType() {
        return type;
    }

    public double getHarvestTime() {
        return harvestTime;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    public int getHarvestCost() {
        return harvestCost;
    }

    public int getNoPrdctsPrdced() {
        return noPrdctsPrdced;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getSellingPrice(Type type) {
        return computeSellingPrice(type);
    }

    public int getNoOfWaters() {
        return noOfWaters;
    }

    public int getNoOfFertilizes() {
        return noOfFertilizes;
    }

    public int getCropBonus() {
        return cropBonus;
    }

    public boolean isWitherStatus() {
        return witherStatus;
    }

    public int getWitherTime() {
        return witherTime;
    }

    public int getPrdctStayTIme() {
        return prdctStayTime;
    }

    public int getXpResult() {
        return xpResult;
    }

    public String getSeedName(){
        return seedName;
    }
    @Override
    public String toString() {
        return  "Seed Name: " + seedName +
                "\nCrop type: " + type +
                "\nHarvest Time: " + harvestTime +
                "\nBase Price: " + basePrice +
                "\nSeed Cost: " + seedCost +
                "\nNeeded amount of Fertilizer: " + fertilizerNeeded +
                "\nNeeded amount of Water: " + waterNeeded +
                "\nXP Result: " + xpResult + "\n";

    }
}


