package TowerDefense;

import TowerDefense.Shop.Shop;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.IOException;


public class Main extends Application implements Runnable {
    private Stage primary;
    private FXMLLoader fxmlLoader;
    private GameStage gameStage;
    private boolean running = false;

    // Game Loop Variables
    private final int TICKS_PER_SECOND = 100;
    private final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    private final int MAX_FRAMESKIP = 5;

    public static long CURRENT_GAME_TICK = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primary = primaryStage;
        primaryStage.setTitle(Config.GAME_NAME);

        // Load the scene from FXML
        fxmlLoader = new FXMLLoader(getClass().getResource("TowerDefense.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        //----Catch event of button in main menu----
        Controller controller = fxmlLoader.getController();
        controller.getStartButton().setOnAction((ActionEvent e) -> {
            startGame();
        });

        controller.getQuitButton().setOnAction((ActionEvent e) -> {
            Platform.exit();
            System.exit(0);
        });
        //---------------------

        // Set the frame rate to ~60 FPS
        Timeline animationLoop = new Timeline();
        animationLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(Duration.seconds(0.017), (ActionEvent event) -> {
            if (gameStage != null) {
                gameStage.repaint();
            }
        });

        animationLoop.getKeyFrames().add(kf);

        primaryStage.show();

        // Start the Game Loop and the animation loops
        animationLoop.play();
        primaryStage.show();
    }

    @Override
    public void run() {

    }

    private void startGame() {

        gameStage=new GameStage(1024,640);
        Controller controller=fxmlLoader.getController();
        controller.getLeftPane().getChildren().clear();
        controller.getLeftPane().getChildren().add(gameStage);

        Button levelButton=new Button("NextLevel");
        levelButton.setLayoutX(10);
        levelButton.setLayoutY(10);

        controller.getLeftPane().getChildren().add(levelButton);
        gameStage.setLevelButton(levelButton);

        Shop shop = new Shop(controller.getRightPane());
        shop.setGameListener(gameStage);
        shop.setMainListener(this);

        primary.sizeToScene();

        new Thread(this, "Game Loop").start();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
