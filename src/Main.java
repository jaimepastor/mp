import Controller.GameController;
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Game.fxml"));
        Scene mainScene = new Scene(loader.load(), 1280, 720);
        GameController gController = loader.getController();

        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        Player p = new Player("HIME", gController);
        gController.setModel(p);
    }
}
