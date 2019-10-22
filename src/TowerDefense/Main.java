package TowerDefense;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameStage gameStage=new GameStage();
        Pane root = new Pane();
        Image image = new Image("file:img/background.png");
        ImageView imageView2 = new ImageView(gameStage.getGameField().getMountain().getMountainImage());
        root.getChildren().addAll(imageView2);

        //Parent root = FXMLLoader.load(getClass().getResource("TowerDefense.fxml"));
        primaryStage.setTitle(Config.GAME_NAME);
        primaryStage.setScene(new Scene(root, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
