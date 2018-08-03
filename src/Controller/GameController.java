package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class GameController {
    @FXML private GridPane lotGrid;
    @FXML private ImageView pickaxe;
    @FXML private ImageView wateringCan;
    @FXML private ImageView plow;
    @FXML private ImageView fertilizer;
    @FXML private TilePane seedDisplay;
    @FXML private Label stuffInfo;
    @FXML private AnchorPane actionPane;

    private Player p;

    public void initialize(){
        pickaxe.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                p.buySeeds();
            }
        });
        wateringCan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stuffInfo.setText(p.getTools().get(1).getInformation());
            }
        });

        for(int i = 0; i < 50; i++)
            lotGrid.getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    p.buySeeds();
                }
            });



        /*addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    textField.setText(p.getLot().getTile(1, 1).toString().replace("[","").replace("]", ""));
                }
    });*/

    }

    public void setModel(Player p){
        this.p = p;

    }
}