package Model;

import java.util.ArrayList;
import java.util.Random;

import Controller.GameController;

public class Player {
	private String name;
	private Lot lot;
	private int OC;
	private int xp;
	private int level;
	private boolean isRegistered;
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
		this.level = 15 ;
		this.isRegistered = false;
		this.curType = 1;
		this.tools = new ArrayList<>();
		this.seeds = new ArrayList<>();
		this.noOfFertilizers = 5;
		this.gameController = gc;

		this.gameController = gc;
		initializeFarmerTypes();
		initializeTools();
	}

	private void initializeFarmerTypes() {
		this.types = new Type[4];
		this.types[0] = new Type("Farmer", 0, 0, 0, 0, 0);
		this.types[1] = new Type("Registered Farmer", 10, 2, 0, 5, 200);
		this.types[2] = new Type("Distinguished Farmer", 15, 3, 1, 10, 250);
		this.types[3] = new Type("Honorable Farmer", 20, 5, 2, 15, 350);
	}

	private void initializeTools() {
		this.tools.add(new Pickaxe("Pickaxe", "Picks axes"));
		this.tools.add(new WateringCan("Watering Can", "Waters cans"));
		this.tools.add(new Plow("Plow", "P's lows"));
		this.tools.add(new Fertilizer("Fertilizer", "Fertis lizers"));
	}

	private void displaySeeds() {
		//display each crop
		Random r = new Random();
		//add bonus limits to wn an fn
		//change in reference to controller
		/*
		System.out.println(new Crop("Turnip", "Vegetable", 1, 1, 0, 1, 1, 5, 6, 0, 1).toString());
		System.out.println(new Crop("Carrot", "Vegetable", 1.5, 1, 0, 1, r.nextInt(2) + 1, 10, 9, 0, 2).toString());
		System.out.println(new Crop("Tomato", "Vegetable", 2.5, 3, 1, 1, r.nextInt(3) + 1, 20, 15, 0, 3).toString());
		System.out.println(new Crop("Potato", "Vegetable", 5, 4, 2, 1, r.nextInt(6) + 1, 25, 13, 0, 4).toString());
		System.out.println(new Crop("Rose", "Flower", 1, 1, 0, 2, 1, 5, 5, 2, 1).toString());
		System.out.println(new Crop("Tulip", "Flower", 1.5, 2, 0, 2, 1, 7, 7, 2, 3).toString());
		System.out.println(new Crop("Stargazer", "Flower", 2.5, 2, 0, 2, 1, 10, 9, 2, 5).toString());
		System.out.println(new Crop("Sunflower", "Flower", 3.5, 2, 1, 2, 1, 20, 19, 2, 7).toString());
		System.out.println(new Crop("Mango", "Fruit Tree", 7, 7, 4, 3, r.nextInt(6) + 5, 50, 4, 0, 2).toString());
		System.out.println(new Crop("Apple", "Fruit Tree", 7, 7, 5, 3, r.nextInt(4) + 7, 55, 3.5, 0, 4).toString());
		System.out.println(new Crop("Banana", "Fruit Tree", 8, 8, 5, 3, r.nextInt(6) + 10, 60, 3.5, 0, 6).toString());
		System.out.println(new Crop("Orange", "Fruit Tree", 8, 8, 6, 3, r.nextInt(3) + 13, 65, 4.5, 0, 8).toString());
		*///change to display stuff in view instead
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
            if(seeds.get(i).getSeedName().equalsIgnoreCase(seedName) == true)
                x++;

        return x;
    }

    public Crop getCrop(String name){
        for(int i = 0; i < seeds.size(); i++){
            if(seeds.get(i).getSeedName().equalsIgnoreCase(name)){
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

	public void plantSeeds(Tile tile, String crop) {

        Crop c = getCrop(crop);
        if (c != null) {
            if(tile.getSpaceStatus() == true)
                if(tile.getPlowStatus() == true){
                    tile.setHeldCrop(getCrop(name));
                    xp++;
                    gameController.displaySuccess();
                }
                else
                    gameController.displayFail(("Tile needs to be first!"));
            else
                gameController.displayFail("Tile has something inside it!");
        } else
            gameController.displayFail("You don't have any " + name + "seeds.");
		//controller -> seed does not exist booboooo
	}

	public void harvestCrop(Tile tile) {

	}

	public void useTool(String tool, Tile tile){
	    boolean pwede = true;
	    switch(tool){
            case "pickaxe" : if(tile.getRockStatus() == false){
                gameController.displayFail("Cannot use Pickaxe");
                }
                    break;
            case "wateringCan" : if(tile.getHeldCrop().getNoOfWaters() >= tile.getHeldCrop().getWaterNeeded()){
                gameController.displayFail("Cannot use Watering Can");
                }
                    break;
            case "plow" : if(tile.getPlowStatus() == true){
                gameController.displayFail("Cannot use Plow");
                }
                    break;
            case "fertilizer" : if(tile.getHeldCrop().getNoOfFertilizes() >= tile.getHeldCrop().getFertilizerNeeded()){
                gameController.displayFail("Cannot use Fertilizer");
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

    public int getOC(){
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