package Model;

/**
 * Subclass for the Fruit Tree type of Crop
 */
public class FruitTree extends Crop {
    /**
     * Constructor for FruitTree class
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
    public FruitTree(String sn, String type, double ht, int wn, int hwn, int fn, int hfn, int hc, int npp, int sc, double bp, int cb, int xp, int flb) {
        super(sn, type, ht, wn, hwn, fn, hfn, hc, npp, sc, bp, cb, xp, flb);
    }
}
