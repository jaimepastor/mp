package Model;

/**
 * Class which is an outline for each bonus per farmer type
 */
public class Type
{
    private String type;
    private int levelReq;
    private int earnBuyBonus;
    private int wtrFrtBonus;
    private long hrvstTimeBonus;
    private int regFee;
    private boolean isRegistered;

    /**
     * Constructor for the Type
     * @param type represents the type of the farmer
     * @param req represents level requirement of the farmer type
     * @param EBB represents the Earning and Buying Bonus
     * @param WFB represents the Water and Fertilizes Bonus
     * @param HTB represents the Harvest Time Bonus
     * @param regFee represents the Registration Fee
     * @param reg represents whether the Farmer type is registered.
     */
    public Type(String type, int req, int EBB, int WFB, long HTB, int regFee, boolean reg)
    {
        this.type = type;
        this.levelReq = req;
        this.earnBuyBonus = EBB;
        this.wtrFrtBonus = WFB;
        this.hrvstTimeBonus = HTB;
        this.regFee = regFee;
        this.isRegistered = reg;
    }

    /**
     * Getter for the Farmer type.
     * @return returns String value of the type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for the Level Requirement for the Farmer Type.
     * @return returns int value of the Level Requirement.
     */
    public int getLevelReq() {
        return levelReq;
    }

    /**
     * Getter for the Earning and Buying Bonus.
     * @return returns int value for the earning and buying bonus.
     */
    public int getEarnBuyBonus() {
        return earnBuyBonus;
    }

    /**
     * Getter for the Water and Fertilizer Bonus
     * @return returns the int value for the bonus.
     */
    public int getWtrFrtBonus() {
        return wtrFrtBonus;
    }

    /**
     * Getter for the Harvest Time Bonus.
     * @return returns the int value for the bonus.
     */
    public long getHrvstTimeBonus() {
        return hrvstTimeBonus;
    }

    /**
     * Getter for the Registration Fee.
     * @return returns the int value for the Registration Fee.
     */
    public int getRegFee() {
        return regFee;
    }
}