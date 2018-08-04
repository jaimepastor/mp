package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import java.util.Random;

public class GameController {
    @FXML private TilePane lot;
    @FXML private TilePane seedDisplay;
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
    @FXML private Button actionPaneBuy;
    @FXML private Button actionPaneCancel;
    @FXML private Button actionPaneUse;
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
    private String source;

    public void initialize(){
        actionPane.setVisible(false);
        seedDisplay.setVisible(false);

        pickaxe.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(0).getInformation());

                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
            }
        });
        wateringCan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(1).getInformation());

                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
            }
        });

        plow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(2).getInformation());

                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
            }
        });

        fertilizer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                infoStuff.setText(p.getTools().get(3).getInformation());

                actionPane.setVisible(true);
                actionPaneBuy.setVisible(false);
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
                infoStuff.setText(new Crop("Turnip", "Vegetable", 1, 1, 0, 1, 1, 5, 6, 0, 1).toString());
                ImageView i = (ImageView) event.getSource();
                source = i.getId();
            }
        });

        carrot.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Carrot", "Vegetable", 1.5, 1, 0, 1, r.nextInt(2) + 1, 10, 9, 0, 2).toString());
            }
        });

        tomato.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Tomato", "Vegetable", 2.5, 3, 1, 1, r.nextInt(3) + 1, 20, 15, 0, 3).toString());
            }
        });

        potato.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Potato", "Vegetable", 5, 4, 2, 1, r.nextInt(6) + 1, 25, 13, 0, 4).toString());
            }
        });

        rose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Rose", "Flower", 1, 1, 0, 2, 1, 5, 5, 2, 1).toString());
            }
        });

        tulip.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Tulip", "Flower", 1.5, 2, 0, 2, 1, 7, 7, 2, 3).toString());
            }
        });

        stargazer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Stargazer", "Flower", 2.5, 2, 0, 2, 1, 10, 9, 2, 5).toString());
            }
        });

        sunflower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Sunflower", "Flower", 3.5, 2, 1, 2, 1, 20, 19, 2, 7).toString());
            }
        });
        mango.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Mango", "Fruit Tree", 7, 7, 4, 3, r.nextInt(6) + 5, 50, 4, 0, 2).toString());
            }
        });

        apple.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Apple", "Fruit Tree", 7, 7, 5, 3, r.nextInt(4) + 7, 55, 3.5, 0, 4).toString());
            }
        });

        banana.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Banana", "Fruit Tree", 8, 8, 5, 3, r.nextInt(6) + 10, 60, 3.5, 0, 6).toString());
            }
        });

        orange.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(true);
                actionPaneBuy.setVisible(true);
                actionPaneUse.setVisible(true);
                infoStuff.setText(new Crop("Orange", "Fruit Tree", 8, 8, 6, 3, r.nextInt(3) + 13, 65, 4.5, 0, 8).toString());
            }
        });

        for(int i = 0; i < 50; i++) {
            final int x = i;
            lot.getChildren().get(x).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("" + x % 10 + "" + x / 10);
                    System.out.println("" + p.getLot().getTile(x / 10, x % 10));
                }
            });
        }


        actionPaneBuy.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                seedDisplay.setVisible(false);
                actionPane.setVisible(false);
                infoStuff.setText("i love hime");
                switch (source) {
                    case "turnip":
                        p.getSeeds().add(new Crop("Turnip", "Vegetable", 1 * 60 - (1 * 60 * p.getTypes()[p.getCurType()].getHrvstTimeBonus(), 1, )));
                        break;
                }
            }
        });

        actionPaneCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(false);
                seedDisplay.setVisible(false);
                infoStuff.setText("i love hime");
            }
        });

    }

    public void updateLevel(){

    }
    public void setModel(Player p){
        this.p = p;
        name.setText(p.getName());
        level.setText("" + p.getLevel());
        xp.setText("XP : " + p.getXp() + " / " + (5 * (p.getLevel() + 1)));
        type.setText("Type: " + p.getFarmerType());
        oc.setText("OC: " + p.getOC());
















    }
}