package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import java.util.Random;

public class GameController {
    @FXML private TilePane lot;
    @FXML private TilePane seedDisplay;
    @FXML private TilePane plantDisplay;
    @FXML private TilePane buttonDisplay;
    @FXML private AnchorPane actionPane;
    @FXML private ImageView pickaxe;
    @FXML private ImageView wateringCan;
    @FXML private ImageView plow;
    @FXML private ImageView fertilizer;
    @FXML private ImageView seeds;
    @FXML private Label infoStuff;
    @FXML private Label name;
    @FXML private Label level;
    @FXML private Label xp;
    @FXML private Label type;
    @FXML private Label oc;
    @FXML private Label statusStuff;
    @FXML private Button actionPaneBuy;
    @FXML private Button actionPaneCancel;
    @FXML private Button actionPaneUse;
    @FXML private Button upgrade;
    @FXML private ImageView turnip;
    @FXML private ImageView carrot;
    @FXML private ImageView tomato;
    @FXML private ImageView potato;
    @FXML private ImageView rose;
    @FXML private ImageView tulip;
    @FXML private ImageView stargazer;
    @FXML private ImageView sunflower;
    @FXML private ImageView mango;
    @FXML private ImageView apple;
    @FXML private ImageView banana;
    @FXML private ImageView orange;

    private Random r = new Random();
    private Player p;
    private String imgSource;//keeps the source of click action
    private String actionSource;

    private Image unplowedTile = new Image("/View/tile.png");
    private Image rockTile = new Image("/View/tileWithRock.png");
    private Image plowedTile = new Image("/View/plowedTile.png");
    private Image plowedWateredTile = new Image("/View/plowedWateredTile.png");
    private Image fertilizedPlowedTile = new Image("/View/fertilizedPlowedTile.png");
    private Image fertilizedPlowedWateredTile = new Image("/View/fertilizedPlowedWateredTile.png");
    private Image plant1 = new Image("/View/plantStage1.png");

    public void initialize(){
        actionPane.setVisible(false);
        seedDisplay.setVisible(false);

        pickaxe.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(0).getInformation());

                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
            }
        });
        wateringCan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(1).getInformation());

                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
            }
        });

        plow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(2).getInformation());

                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
            }
        });

        fertilizer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(3).getInformation() + "\nNo of Fertilizers: " + p.getNoOfFertilizers());
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
            }
        });

        seeds.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                seedDisplay.setVisible(true);
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
                actionPaneUse.setVisible(false);
            }
        });

        turnip.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new Vegetable("Turnip", "Vegetable",
                        (1  - (p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100.0)), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, 1, 5, 6, 0, 1).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        carrot.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new Vegetable("Carrot", "Vegetable",
                        (1.5 - (1.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, r.nextInt(2) + 1, 10, 9, 0, 2).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        tomato.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Vegetable("Tomato", "Vegetable",
                        (2.5 - (2.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 3, 4 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, r.nextInt(3) + 1, 20, 15, 0, 3).toString() + p.computeNoOfSeedType("tomato"));
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
            }
        });
        potato.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new Vegetable("Potato", "Vegetable",
                        5 - (5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 4, 5 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, r.nextInt(6) + 1, 25, 13, 0, 4).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        rose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new Flower("Rose", "Flower",
                        1 - (p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 5, 5, 2, 1).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        tulip.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new Flower("Tulip", "Flower",
                        (1.5 - (1.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 7, 7, 2, 3).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        stargazer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new Flower("Stargazer", "Flower",
                        (2.5 - (2.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 10, 9, 2, 5).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        sunflower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new Flower("Sunflower", "Flower",
                        (3.5 - (3.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 20, 19, 2, 7).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        mango.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new FruitTree("Mango", "Fruit Tree",
                        7 - (7 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 7, 7 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 4, 4 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(6) + 5, 50, 4, 0, 2).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        apple.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new FruitTree("Apple", "Fruit Tree",
                        7 - (7 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 7, 8 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),5, 5 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(4) + 7, 55, 3.5, 0, 4).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        banana.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new FruitTree("Banana", "Fruit Tree",
                        8 - (8 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 8, 8 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),5, 5 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(6) + 10, 60, 3.5, 0, 6).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        orange.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                ImageView i = (ImageView) event.getSource();
                imgSource = i.getId();
                infoStuff.setText(new FruitTree("Orange", "Fruit Tree",
                        8 - (8 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 8, 8  + p.getTypes()[p.getCurType()].getWtrFrtBonus(),6, 6 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(3) + 13, 65, 4.5, 0, 8).toString() + p.computeNoOfSeedType(imgSource));
            }
        });

        for(int i = 0; i < 50; i++) {
            final int x = i;
            buttonDisplay.getChildren().get(x).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    infoStuff.setText(p.getLot().getTile(x).toString());
                }
            });
        }

        actionPaneBuy.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println((1  - (p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100.0)));
                seedDisplay.setVisible(false);
                actionPane.setVisible(false);
                switch (imgSource) {
                    case "turnip":
                        p.buySeeds(new Vegetable("Turnip", "Vegetable",
                                (1  - (p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100.0)), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, 1, 5, 6, 0, 1));
                        break;
                    case "carrot" :
                        p.buySeeds(new Vegetable("Carrot", "Vegetable",
                                (1.5 - (1.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, r.nextInt(2) + 1, 10, 9, 0, 2));
                        break;
                    case "tomato" :
                        p.buySeeds(new Vegetable("Tomato", "Vegetable",
                                (2.5 - (2.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 3, 4 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, r.nextInt(3) + 1, 20, 15, 0, 3));
                        break;
                    case "potato" :
                        p.buySeeds(new Vegetable("Potato", "Vegetable",
                            5 - (5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 4, 5 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 1, r.nextInt(6) + 1, 25, 13, 0, 4));
                        break;
                    case "rose" :
                        p.buySeeds(new Flower("Rose", "Flower",
                            1 - (p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 5, 5, 2, 1));
                        break;
                    case "tulip" :
                        p.buySeeds(new Flower("Tulip", "Flower",
                                (1.5 - (1.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 7, 7, 2, 3));
                        break;
                    case "stargazer" :
                        p.buySeeds(new Flower("Stargazer", "Flower",
                                (2.5 - (2.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),0, 1 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 10, 9, 2, 5));
                        break;
                    case "sunflower" :
                        p.buySeeds(new Flower("Sunflower", "Flower",
                                (3.5 - (3.5 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100)), 2, 3 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),1, 2 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 2, 1, 20, 19, 2, 7));
                        break;
                    case "mango" :
                        p.buySeeds(new FruitTree("Mango", "Fruit Tree",
                            7 - (7 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 7, 7 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 4, 4 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(6) + 5, 50, 4, 0, 2));
                        break;
                    case "apple" :
                        p.buySeeds(new FruitTree("Apple", "Fruit Tree",
                            7 - (7 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 7, 8 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),5, 5 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(4) + 7, 55, 3.5, 0, 4));
                        break;
                    case "banana" :
                        p.buySeeds(new FruitTree("Banana", "Fruit Tree",
                            8 - (8 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 8, 8 + p.getTypes()[p.getCurType()].getWtrFrtBonus(),5, 5 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(6) + 10, 60, 3.5, 0, 6));
                        break;
                    case "orange" :
                        p.buySeeds(new FruitTree("Orange", "Fruit Tree",
                            8 - (8 * p.getTypes()[p.getCurType()].getHrvstTimeBonus() / 100), 8, 8  + p.getTypes()[p.getCurType()].getWtrFrtBonus(),6, 6 + p.getTypes()[p.getCurType()].getWtrFrtBonus(), 3, r.nextInt(3) + 13, 65, 4.5, 0, 8));
                        break;
                    case "fertilizer" :
                        p.buyFertilizer();
                        infoStuff.setText("Bought one new fertilizer!");
                        break;
                }
            }
        });

        actionPaneUse.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText("CHOOSE A TILE!");
                actionPane.setVisible(false);
                actionMode(imgSource);
            }
        });

        actionPaneCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(false);
                seedDisplay.setVisible(false);
                resetTiles();
            }
        });

        upgrade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                p.updateFarmerType();
            }
        });
    }

    public void update(){//called on every change of xp and OC change
        level.setText("" + p.getLevel());
        xp.setText("XP : " + p.getXp() + " / " + (5 * (p.getLevel() + 1)));
        type.setText("Type: " + p.getFarmerType());
        oc.setText("OC: " + p.getOC());
        if(p.getLevel() >= p.getTypes()[p.getCurType() + 1].getLevelReq()){
            upgrade.setVisible(true);
        }
    }
    public void setModel(Player p) {//initializes field with player information
        this.p = p;
        name.setText(p.getName());
        level.setText("" + p.getLevel());
        xp.setText("XP : " + p.getXp() + " / " + (5 * (p.getLevel() + 1)));
        type.setText("Type: " + p.getFarmerType());
        oc.setText("OC: " + p.getOC());
        for(int i = 0; i < 50; i++){
            if(p.getLot().getTile(i).getRockStatus()){
                ((ImageView)lot.getChildren().get(i)).setImage(rockTile);
            }
        }
}

    public void displayLevelFail(int kulang){//displays amount of missing level
        String extra;
        if(kulang == 1)
            extra = " more level to to be eligible for upgrading.";
        else
            extra = " more levels to be eligible for upgrading.";
        statusStuff.setText("You need " + kulang + extra);
    }
    public void displayFail(String text){
        statusStuff.setText(text);
    }//displays error text, probably should be in another label

    public void displayInfo(String info){
        infoStuff.setText(info);
    }//displays information for label, can be for seed and tool

    public void displaySuccess(){
        statusStuff.setText("SUCCESS B");
    }

    public void resetTiles(){//changes tiles back to show information only
        for(int i = 0; i < 50; i++) {
            final int x = i;
            buttonDisplay.getChildren().get(x).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    infoStuff.setText(p.getLot().getTile(x).toString());
                }
            });
        }
        infoStuff.setText("i love hime");
    }

    public void actionMode(String tool){//changes behavior of each button tile
        actionPane.setVisible(true);
        actionPaneBuy.setVisible(false);
        actionPaneUse.setVisible(false);
        actionPaneCancel.setVisible(true);
        for(int i = 0; i < 50; i++){
            final int x = i;
            buttonDisplay.getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    switch(tool){
                        case "turnip" :
                        case "carrot" :
                        case "tomato" :
                        case "potato" : p.plantSeeds(p.getLot().getTile(x), tool, "Vegetable");
                            break;
                        case "rose" :
                        case "tulip" :
                        case "stargazer" :
                        case "sunflower" : p.plantSeeds(p.getLot().getTile(x), tool, "Flower");
                            break;
                        case "mango" :
                        case "apple" :
                        case "banana" :
                        case "orange" : p.plantSeeds(p.getLot().getTile(x), tool, "Fruit Tree");
                            break;
                        case "pickaxe" : p.useTool(tool, p.getLot().getTile(x));
                            break;
                        case "wateringCan" : p.useTool(tool, p.getLot().getTile(x));
                            break;
                        case "plow" : p.useTool(tool, p.getLot().getTile(x));
                            break;
                        case "fertilizer" : p.useTool(tool, p.getLot().getTile(x));
                            break;
                    }
                }
            });
        }
    }

    public void activateCrop(int coord, String crop){//set visibility of specified crop to true
        ((ImageView)plantDisplay.getChildren().get(coord)).setImage(plant1);
        System.out.println("");
        //p.getLot().getTile(coord).getHeldCrop().getHarvestTime()
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep((long)(1000));//sleeps the thread until harvest time
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                if(p.getLot().getTile(coord).getNoOfWaters() >= p.getLot().getTile(coord).getHeldCrop().getWaterNeeded() &&
                    p.getLot().getTile(coord).getNoOfFertilizes() >= p.getLot().getTile(coord).getHeldCrop().getFertilizerNeeded()){
                    ((ImageView)plantDisplay.getChildren().get(coord)).setImage(new Image("/View/" + crop + ".png"));
                }
                else{
                    System.out.println("MALI GAGO");
                    ((ImageView)plantDisplay.getChildren().get(coord)).setImage(null);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    public void changeTile(int coord, String source){//change lot tile image
        switch(source){
            case "pickaxe" :
                ((ImageView)lot.getChildren().get(coord)).setImage(unplowedTile);
                break;
            case "wateringCan" :
                if(p.getLot().getTile(coord).getNoOfFertilizes() >= p.getLot().getTile(coord).getHeldCrop().getFertilizerNeeded())
                    ((ImageView)lot.getChildren().get(coord)).setImage(fertilizedPlowedWateredTile);//FIX GET NO OF FERTILIZERS
                else
                    ((ImageView)lot.getChildren().get(coord)).setImage(plowedWateredTile);
                break;
            case "plow" : ((ImageView)lot.getChildren().get(coord)).setImage(plowedTile);
                break;
            case "fertilizer" :
                if(p.getLot().getTile(coord).getNoOfWaters() >= p.getLot().getTile(coord).getHeldCrop().getWaterNeeded())
                    ((ImageView)lot.getChildren().get(coord)).setImage(fertilizedPlowedWateredTile);
                else
                    ((ImageView)lot.getChildren().get(coord)).setImage(fertilizedPlowedTile);
                break;
        }
    }
}