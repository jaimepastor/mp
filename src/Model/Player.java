package Model;

import java.util.ArrayList;

import Controller.GameController;

/**
 * Player is the main model class and where all the model-related methods are located.
 *
 * @Author Jaime Alfonso R. Pastor 11726024
 * @Version 1.00
 */
public class Player {
	private String name;
	private Lot lot;
	private double OC;
	private int xp;
	private int level;
	private Type[] types;
	private int curType;
	private ArrayList<Tool> tools;
	private ArrayList<Crop> seeds;
	private int noOfFertilizers;
	private GameController gameController;

    /**
     * Constructor for Player class. Instantiates and initializes Lot and Tools. Instantiates seeds.
     * @param name represents name of player
     * @param gc represents associated Controller
     */
	public Player(String name, GameController gc) {
		this.name = name;
		this.lot = new Lot();
		this.OC = 500;
		this.xp = 0;
		this.level = 0;
		this.curType = 0;
		this.tools = new ArrayList<>();
		this.seeds = new ArrayList<>();
		this.noOfFertilizers = 5;
		this.gameController = gc;
		initializeFarmerTypes();
		initializeTools();
	}

    /**
     * Initializes every Type of Farmer and associated bonuses.
     */
	private void initializeFarmerTypes() {
		this.types = new Type[4];
		this.types[0] = new Type("Farmer", 0, 0, 0, 0, 0, false);
		this.types[1] = new Type("Registered Farmer", 10, 2, 0, 5, 200, true);
		this.types[2] = new Type("Distinguished Farmer", 15, 3, 1, 10, 250, true);
		this.types[3] = new Type("Honorable Farmer", 20, 5, 2, 15, 350, true);
	}

    /**
     * Initializes every Tool and associated descriptions.
     */
	private void initializeTools() {
		this.tools.add(new Pickaxe("Used for destroying rocks obstructing tiles."));
		this.tools.add(new WateringCan("Waters a specific crop; \nCan dispense an infinite amount of water."));
		this.tools.add(new Plow("Prepares a specific title for planting; \nAlso removes withered plants."));
		this.tools.add(new Fertilizer("Not actually a tool, but is bought in finite amounts and fertilizes a specific tile; \nCannot be placed on a tile with a plant;"));
	}

    /**
     * Checks if current xp has reached or went over xp needed for next level, then updates Controller.
     */

	public void updateLevel() {
		if (xp >= 5 * (level + 1)) {
			//display YAY YOU LEVELLED UP!!
			this.xp = this.xp - (5 * (level + 1));//reset xp to 0 plus overloaded xp
			level++;
        }
		gameController.update();
	}

    /**
     * Checks if farmer is eligible for upgrading their status.
     */
	public void updateFarmerType() {
		if (curType < 3) {
			if (level >= types[curType + 1].getLevelReq())
				if (OC >= types[curType + 1].getRegFee()) {
					curType++;
					OC = OC - types[curType].getRegFee();
					gameController.update();
				} else {
                    gameController.displayFail("You are missing " + (types[curType + 1].getRegFee() - OC) + " OC!");
                }
            else
                gameController.displayLevelFail(types[curType + 1].getLevelReq() - level);
		} else {
			gameController.displayStatus("Cannot upgrade Farmer type anymore!");
		}
	}

    /**
     * Computes how many seeds of a specified type the farmer has.
     * @param seedName represents what type of seed to be counted.
     * @return returns integer number of seeds found.
     */
    public int computeNoOfSeedType(String seedName){
        int x = 0;//no of found seeds
        for(int i = 0; i < seeds.size(); i++)
            if(seeds.get(i).getCropName().equalsIgnoreCase(seedName) == true)
                x++;

        return x;
    }

    /**
     * Takes the specified crop from the list of crops the farmer has.
     * @param name represents name of Crop to get
     * @return returns Crop or null, if Crop does not exist.
     */
    public Crop getCrop(String name){
        for(int i = 0; i < seeds.size(); i++){
            if(seeds.get(i).getCropName().equalsIgnoreCase(name)){
                return seeds.remove(i);
            }
        }

        return null;
    }

    /**
     * Allows farmer to buy seeds.
     * @param crop represents the specific crop to be bought.
     */
	public void buySeeds(Crop crop) {
		if(crop.getSeedCost() > OC)
			gameController.displayFail("You are missing " + (crop.getSeedCost() - OC) + " OC!");
		else{
			seeds.add(crop);
			OC -=(crop.getSeedCost() - types[curType].getEarnBuyBonus());
			gameController.displayInfo("New seed! Information:\n" + seeds.get(seeds.size()-1).toString());
			gameController.update();
		}
	}

	/**
     * Buys fertilizer, as long as farmer has enough OC.
	 */
	public void buyFertilizer(){
		if(10 > OC)
		    gameController.displayFail("You are missing " + (10 - OC) + " OC!");
		else{
            noOfFertilizers++;
            OC -= (10 - types[curType].getEarnBuyBonus());
            gameController.update();
        }
    }

    /**
     * Allows farmer to plant seeds on the specified tile.
     * @param tile represents what tile the seed will be planted on.
     * @param crop represents the name of crop to be planted.
     * @param type represents the type of crop to be planted. (Either Vegetable, Flower, or Fruit Tree).
     */

	public void plantSeeds(Tile tile, String crop, String type) {
        Crop c;
        int i = tile.getCoordinate();
        if (tile.getPlowStatus() == true) {
            if(tile.getSpaceStatus() == true)
            	if (computeNoOfSeedType(crop) > 0){
                    if(type == "Fruit Tree")
                        if(lot.treeValid(tile) == true) {
                            c = getCrop(crop);
                            tile.setHeldCrop(c);
                            lot.disableTiles(tile, gameController);
                            tile.setSpaceStatus(false);
                            xp++;
                            gameController.displaySuccess();
                            gameController.activateCrop(i, crop);

                            updateLevel();
                            gameController.update();
                        }
                        else
                            gameController.displayFail("There is a filled tile!. check the tiles above, below, and beside");
                    else {
                        c = getCrop(crop);
                        tile.setHeldCrop(c);
                        tile.setSpaceStatus(false);
                        xp++;
                        gameController.displaySuccess();
                        gameController.activateCrop(i, crop);

                        updateLevel();
                        gameController.update();
                    }
                }
                else
                    gameController.displayFail("You don't have any " + crop + " seeds.");
            else
                gameController.displayFail("Tile has something inside it!");
        } else
			gameController.displayFail("Tile needs to plowed be first!");
	}

    /**
     * Harvests crop inside the specified tile.
     * @param tile represents the tile that has the crop to be harvested.
     */
	public void harvestCrop(Tile tile) {
		int hc = tile.getHeldCrop().getHarvestCost();
		int sc = tile.getHeldCrop().getSeedCost();
		double profit = (tile.getHeldCrop().computeSellingPrice(tile.getNoOfWaters(), tile.getNoOfFertilizes()) - hc - sc) * tile.getHeldCrop().getNoPrdctsPrdced();
		int npp = tile.getHeldCrop().getNoPrdctsPrdced();
        xp = tile.getHeldCrop().getXpResult() * tile.getHeldCrop().getNoPrdctsPrdced();
        //if statement for tree
        if(tile.getHeldCrop().getType().equalsIgnoreCase("fruit tree")){
            lot.enableTiles(tile, gameController);
        }
        OC += profit;
        gameController.displayStatus("SUCCESSFUL HARVEST!\n\n" + npp + "were harvested.\n" + profit + "OC was earned.");
        tile.resetTile();
		gameController.update();
	}

    /**
     * Performs the action associated with the specified tool on the specified tile.
     * @param tool represents the name of tool to be used.
     * @param tile represents the tile to be acted on.
     */
	public void useTool(String tool, Tile tile) {
        switch (tool) {
            case "pickaxe":
                if (tile.getRockStatus() == false) {
                    if (tile.getHeldCrop() == null)
                        gameController.displayFail("Cannot use Pickaxe!\nThere is no rock to pick");
                    else if (tile.getSpaceStatus() == false)
                        gameController.displayFail("Cannot use Pickaxe!\nThere is a root in the way!");
                } else {
                    tools.get(0).useTool(tile, gameController);
                    xp += 3;
                    updateLevel();
                    gameController.update();
                }
                break;
            case "wateringCan":
                if (tile.getHeldCrop() == null) {
                    if (tile.getSpaceStatus() == true)
                        gameController.displayFail("Cannot use Watering Can!\nPlant a crop first before watering.");
                    else if (tile.getSpaceStatus() == false)
                        if (tile.getRockStatus() == true)
                            gameController.displayFail("Cannot use Watering Can!\nA rock is in the way.");
                        else
                            gameController.displayFail("Cannot use Watering Can!\nA root is in the way.");
                } else if (tile.getNoOfWaters() >= tile.getHeldCrop().getHighWaterNeeded()) {
                    gameController.displayFail("No more water is needed.");
                } else {
                    tools.get(1).useTool(tile, gameController);
                    xp++;
                    updateLevel();
                    gameController.update();
                }
                break;
            case "plow":
                if (tile.getRockStatus() == true) {
                    gameController.displayFail("Tile still has rock!");
                } else if (tile.getPlowStatus() == true && tile.getWitherStatus() == false && tile.getSpaceStatus() == true) {
                    gameController.displayFail("Tile is already plowed.");
                } else {
                    tools.get(2).useTool(tile, gameController);
                    System.out.println(tile.getWitherStatus() + " withered");
                    if (tile.getWitherStatus() == true) {
                        OC -= ((double) tile.getHeldCrop().getSeedCost()) / 10.0;
                    }
                    xp++;
                    updateLevel();
                    gameController.update();
                }
                break;
            case "fertilizer":
                if (tile.getHeldCrop() != null) {
                    gameController.displayFail("Cannot use Fertilizer!\nYou can only fertilize before planting a crop.");
                } else if (noOfFertilizers == 0) {
                    gameController.displayFail("You don't have any fertilizers!");
                } else {
                    tools.get(3).useTool(tile, gameController);
                    noOfFertilizers--;
                    xp++;
                    updateLevel();
                    gameController.update();
                }
                break;
        }
    }

    /**
     * Getter for the name attribute.
     * @return String name attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the xp attribute.
     * @return integer xp attribute
     */
    public int getXp() {
        return xp;
    }

    /**
     * Getter for the level attribute.
     * @return integer level attribute.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter for the OC attribute.
     * @return double OC attribute.
     */
    public double getOC(){
	    return OC;
    }

    /**
     * Getter for the current type of the farmer.
     * @return integer current type attribute.
     */
    public int getCurType() {
        return curType;
    }

    /**
     * Getter for the Number of Fertilizers.
     * @return returns integer Number of Fertilizers.
     */
    public int getNoOfFertilizers() {
		return noOfFertilizers;
	}

    /**
     * Method to get the current type of the farmer, in String format.
     * @return returns String format of farmer type.
     */
	public String getFarmerType(){
		return types[curType].getType();
	}

    /**
     * Returns array of Types, specific array element to be called at method call of this method.
     * @return returns Array of Type
     */
    public Type[] getTypes() {
        return types;
    }

    /**
     * Allows access to farmer's list of tools.
     * @return returns ArrayList of Tools.
     */
    public ArrayList<Tool> getTools() {
		return tools;
	}

    /**
     * Allows access to Farmer's Lot.
     * @return returns Lot of Farmer.
     */
	public Lot getLot() {
		return lot;
	}
}