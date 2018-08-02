package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class GameController {
    @FXML private TilePane lot;
    @FXML private ImageView pickaxe;
    @FXML private ImageView wateringCan;
    @FXML private ImageView plow;
    @FXML private ImageView fertilizer;
    @FXML private TextArea textArea;
    @FXML private TilePane seedDisplay;

    private Player p;

    public void initialize(){
        wateringCan.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                p.buySeeds();
            }
        });

        for(int i = 0; i < 50; i++)
            lot.getChildren().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    textArea.setText(p.getLot().toString().replace("[","").replace("]", ""));
                }
            });

    }

    public void setModel(Player p){
        this.p = p;

    }
}
