package Model;

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
    private int cropBonus;
    private boolean witherStatus;
    private int witherTime;
    private int prdctStayTime;
    private int xpResult;

    public Crop(String sn, String type, double ht, int wn, int hwn, int fn, int hfn, int hc, int npp, int sc, double bp, int cb, int xp){
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

    public int getHighWaterNeeded() {
        return highWaterNeeded;
    }

    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    public int getHighFertilizerNeeded() {
        return highFertilizerNeeded;
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

    public String getCropName(){
        return cropName;
    }
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


