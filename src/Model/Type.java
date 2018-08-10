package Model;

public class Type
{
    private String type;
    private int levelReq;
    private int earnBuyBonus;
    private int wtrFrtBonus;
    private int hrvstTimeBonus;
    private int regFee;
    private boolean isRegistered;

    public Type(String type, int req, int EBB, int WFB, int HTB, int regFee, boolean reg)
    {
        this.type = type;
        this.levelReq = req;
        this.earnBuyBonus = EBB;
        this.wtrFrtBonus = WFB;
        this.hrvstTimeBonus = HTB;
        this.regFee = regFee;
        this.isRegistered = reg;
    }

    public void displayInfo() {
        System.out.println("Type: " + type + "\nLevel Requirement: " + levelReq + "\nEarn | Buy Bonus: " + earnBuyBonus + "\nWater | Fertilizer Bonus: " + wtrFrtBonus
                            + "\nHarvest Time Bonus: -" + hrvstTimeBonus + "%\nRegistration Fee: " + regFee);
    }

    public String getType() {
        return type;
    }

    public int getLevelReq() {
        return levelReq;
    }

    public int getEarnBuyBonus() {
        return earnBuyBonus;
    }

    public int getWtrFrtBonus() {
        return wtrFrtBonus;
    }

    public int getHrvstTimeBonus() {
        return hrvstTimeBonus;
    }

    public int getRegFee() {
        return regFee;
    }
}