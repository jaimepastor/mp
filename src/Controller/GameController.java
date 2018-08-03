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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class GameController {
    @FXML private GridPane lotGrid;
    @FXML private TilePane seedDisplay;
    @FXML private AnchorPane actionPane;
    @FXML private ImageView pickaxe;
    @FXML private ImageView wateringCan;
    @FXML private ImageView plow;
    @FXML private ImageView fertilizer;
    @FXML private Label infoStuff;
    @FXML private Button actionPaneBuy;
    @FXML private Button actionPaneCancel;
    @FXML private Button actionPaneUse;

    private Player p;

    public void initialize(){
        actionPane.setVisible(false);

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

        for(int i = 0; i < 50; i++)
            lotGrid.getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    p.buySeeds();
                }
            });

        actionPaneCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionPane.setVisible(false);
            }
        });
    }

    public void setModel(Player p){
        this.p = p;

    }
}