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


	public Player(String name) {
		this.name = name;
		this.lot = new Lot();
		this.OC = 100;
		this.xp = 0;
		this.level = 1;
		this.isRegistered = false;
		this.curType = 0;
		this.tools = new ArrayList<Tool>();
		this.seeds = new ArrayList<Crop>();
		this.noOfFertilizers = 5;

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
		this.tools.add(new Pickaxe("nigeria"));
		this.tools.add(new WateringCan("nigeria"));
		this.tools.add(new Plow("nigeria"));
		this.tools.add(new Fertilizer("nigeria"));
	}

	private void displaySeeds() {
		//display each crop
		Random r = new Random();
		//add bonus limits to wn an fn
		//change in reference to controller
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
		//change to display stuff in view instead
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
					//present choice of levelling up
					//if yes, level up (includes curType++) with display, if no return to menu
				} else {
					//display not enough coins
				}
		} else {
			//display cannot upgrade anymore!
		}
	}

	public void buySeeds() {
		displaySeeds();
		//control
	}

	public void plantSeeds(Tile tile) {
		//connect to controller what to return
		Crop c = new Crop("Turnip", "xD", 1, 1, 0, 1, 1, 5, 6, 0, 1);
		//controller should return c?? which represents what crop user chose
		if (seeds.contains(c) == true)
			for (int i = 0; i < seeds.size(); i++)
				if (seeds.get(i).equals(c)) {
					tile.setHeldCrop(seeds.remove(i));
				} else
					System.out.println("nani");
		//controller -> seed does not exist booboooo
	}

	public void harvestCrop(Tile tile) {

	}
}