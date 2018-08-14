package Model;

import java.util.ArrayList;

import Controller.GameController;

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


	public Player(String name, GameController gc) {
		this.name = name;
		this.lot = new Lot();
		this.OC = 10000;
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

	private void initializeFarmerTypes() {
		this.types = new Type[4];
		this.types[0] = new Type("Farmer", 0, 0, 0, 0, 0, false);
		this.types[1] = new Type("Registered Farmer", 10, 2, 0, 5, 200, true);
		this.types[2] = new Type("Distinguished Farmer", 15, 3, 1, 10, 250, true);
		this.types[3] = new Type("Honorable Farmer", 20, 5, 2, 15, 350, true);
	}

	private void initializeTools() {
		this.tools.add(new Pickaxe("Pickaxe", "Picks axes"));
		this.tools.add(new WateringCan("Watering Can", "Waters cans"));
		this.tools.add(new Plow("Plow", "P's lows"));
		this.tools.add(new Fertilizer("Fertilizer", "Fertis lizers"));
	}

	public void updateLevel() {
		if (xp == 5 * (level + 1)) {
			//display YAY YOU LEVELLED UP!!
			level++;
			this.xp = this.xp - (5 * (level + 1));//reset xp to 0 plus overloaded xp
			//send info to controller
			//
		}
	}

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
			//display cannot upgrade anymore!
		}
	}

    public int computeNoOfSeedType(String seedName){
        int x = 0;//no of found seeds
        for(int i = 0; i < seeds.size(); i++)
            if(seeds.get(i).getCropName().equalsIgnoreCase(seedName) == true)
                x++;

        return x;
    }

    public Crop getCrop(String name){
        for(int i = 0; i < seeds.size(); i++){
            if(seeds.get(i).getCropName().equalsIgnoreCase(name)){
                return seeds.remove(i);
            }
        }

        return null;
    }

	public void buySeeds(Crop crop) {
		if(crop.getSeedCost() > OC)
			gameController.displayFail("You are missing " + (crop.getSeedCost() - OC) + " OC!");
		else{
			seeds.add(crop);
			OC = OC - crop.getSeedCost();
			gameController.displayInfo("New seed! Information:\n" + seeds.get(seeds.size()-1).toString());
			gameController.update();
		}
	}

	public void buyFertilizer(){
		if(10 > OC)
		    gameController.displayFail("You are missing " + (10 - OC) + " OC!");
		else{
            noOfFertilizers++;
            OC -= 10;
            gameController.update();
        }
    }

	public void plantSeeds(Tile tile, String crop, String type) {

        int i = tile.getCoordinate();
        if (tile.getPlowStatus() == true) {
            if(tile.getSpaceStatus() == true)
            	if (computeNoOfSeedType(crop) > 0)
            		if(type == "Fruit Tree")
						if(tile.treeValid(lot.getTile(i - 10), lot.getTile(i - 9), lot.getTile(i + 1), lot.getTile(i + 11), lot.getTile(i + 10), lot.getTile(i + 9), lot.getTile(i - 1), lot.getTile(i - 11), tile) == true) {
							tile.setHeldCrop(getCrop(crop));
							lot.getTile(i - 10).setSpaceStatus(false);
							lot.getTile(i - 9).setSpaceStatus(false);
							lot.getTile(i + 1).setSpaceStatus(false);
							lot.getTile(i + 11).setSpaceStatus(false);
							lot.getTile(i + 10).setSpaceStatus(false);
							lot.getTile(i + 9).setSpaceStatus(false);
							lot.getTile(i - 1).setSpaceStatus(false);
							lot.getTile(i - 11).setSpaceStatus(false);
							tile.setSpaceStatus(false);
							xp++;
							gameController.displaySuccess();
                            gameController.activateCrop(i, crop);

                            updateLevel();
                            gameController.update();
                        }
						else gameController.displayFail("There is a filled tile!. check the tiles above, below, and beside");
					else {
							tile.setHeldCrop(getCrop(crop));
							tile.setSpaceStatus(false);
							xp++;
							gameController.displaySuccess();
							gameController.activateCrop(i, crop);

							updateLevel();
							gameController.update();
            		}
                else
                    gameController.displayFail("You don't have any " + crop + " seeds." + computeNoOfSeedType(crop));
            else
                gameController.displayFail("Tile has something inside it!");
        } else
			gameController.displayFail("Tile needs to plowed be first!");
	}

	public void harvestCrop(Tile tile) {
		System.out.println("HARVESTED LESTS GOOOOOOO");
		xp = tile.getHeldCrop().getXpResult() * tile.getHeldCrop().getNoPrdctsPrdced();
		OC += tile.getHeldCrop().computeSellingPrice(types[curType].getEarnBuyBonus(), tile.getNoOfWaters(), tile.getNoOfFertilizes());
		tile.resetTile();
		gameController.update();
	}

	public void useTool(String tool, Tile tile){
	    switch(tool){
            case "pickaxe" : if(tile.getRockStatus() == false){
                    gameController.displayFail("Cannot use Pickaxe");
                } else {
            		tools.get(0).useTool(tile, gameController);
            		xp += 5;
				}
                    break;
            case "wateringCan" :
                if(tile.getHeldCrop() == null){
                    gameController.displayFail("Cannot use Watering Can!\nPlant a crop first before watering.");
                } else if (tile.getNoOfWaters() >= tile.getHeldCrop().getHighWaterNeeded()){
                    gameController.displayFail("No more fertilizer is allowed.");
                } else{
                    tools.get(1).useTool(tile, gameController);
                    xp++;
                }
                    break;
            case "plow" : if(tile.getRockStatus() == true) {
                    gameController.displayFail("Tile still has rock!");
                } else if(tile.getPlowStatus() == true && tile.getWitherStatus() == false && tile.getSpaceStatus() == true) {
                    gameController.displayFail("Tile is already plowed.");
                } else {
                    tools.get(2).useTool(tile, gameController);
                    xp++;
                }
                    break;
            case "fertilizer" :
                if(tile.getHeldCrop() == null){
                    gameController.displayFail("Cannot use Fertilizer!\nPlant a crop first before fertilizing.");
                } else if (noOfFertilizers == 0){
                	gameController.displayFail("You don't have any fertilizers!");
				} else if (tile.getNoOfFertilizes() >= tile.getHeldCrop().getHighFertilizerNeeded()){
                    gameController.displayFail("No more fertilizer is allowed.");
                } else {
                    tools.get(3).useTool(tile, gameController);
                    noOfFertilizers--;
                    xp++;
                }
                    break;
        }

	}
	public void setLevel(int level){
	    this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public double getOC(){
	    return OC;
    }

    public int getCurType() {
        return curType;
    }

    public int getNoOfFertilizers() {
		return noOfFertilizers;
	}

	public String getFarmerType(){
		return types[curType].getType();
	}

    public Type[] getTypes() {
        return types;
    }

    public ArrayList<Tool> getTools() {
		return tools;
	}

	public ArrayList<Crop> getSeeds() {
		//seeds.add(new Crop("Turnip", "Vegetable", 1, 5, 3, 5, 7, 9, 10, 20, 20));
		return seeds;
	}

	public Lot getLot() {
		return lot;
	}
}