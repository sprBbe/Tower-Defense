package TowerDefense;

import TowerDefense.GameOver.GameOver;
import TowerDefense.Shop.Shop;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class Main extends Application implements Runnable{
    private Stage primary;
    private FXMLLoader fxmlLoader;
    private GameStage gameStage;
    public Timeline animationLoop;
    private Thread thread;
    public MediaPlayer mediaPlayer;
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

        //Instantiating Media class
        Media media = new Media(new File("img/Sounds/game-tower-defense.mp3").toURI().toString());

        //Instantiating MediaPlayer class
        mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setAutoPlay(true);

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

        controller.getMuteButton().setOnAction((ActionEvent e) -> {
            if (mediaPlayer.isMute()){
                mediaPlayer.setMute(false);
                controller.getMuteButton().setText("Mute");
            }
            else {
                mediaPlayer.setMute(true);
                controller.getMuteButton().setText("Unmute");
            }
        });
        //---------------------

        // Set the frame rate to ~60 FPS
        animationLoop = new Timeline();
        animationLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(Duration.seconds(0.017), (ActionEvent event) -> {
            if (gameStage != null) {
                gameStage.repaint();
                if(gameStage.getLive()<=0)endGame();
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
        double next_game_tick = System.currentTimeMillis();
        int loops;

        while (running) {
            loops = 0;
            while (System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP) {
                // This loop is to update the game. Not to draw it.
                gameStage.update();
                next_game_tick += SKIP_TICKS;
                loops++;
                CURRENT_GAME_TICK++;
            }
        }
    }

    public void startGame() {
        running = true;

        gameStage = new GameStage((int)Config.SCREEN_WIDTH,(int)Config.SCREEN_HEIGHT);
        Controller controller = fxmlLoader.getController();
        controller.getLeftPane().getChildren().clear();
        controller.getRightPane().getChildren().clear();
        controller.getLeftPane().getChildren().add(gameStage);

        Button levelButton=new Button("Next Level");
        levelButton.setLayoutX(10);
        levelButton.setLayoutY(10);

        controller.getLeftPane().getChildren().add(levelButton);
        gameStage.setLevelButton(levelButton);

        Shop shop = new Shop(controller.getRightPane(), gameStage,this);

        primary.sizeToScene();

        thread = new Thread(this, "Game Loop");
        thread.start();
    }

    public void endGame() {

        running = false;
        //System.out.printf("Đã chạy");
        this.animationLoop.stop();
        Controller controller = fxmlLoader.getController();
        controller.getRightPane().getChildren().clear();
        new GameOver(controller.getRightPane(),gameStage, this);
        primary.sizeToScene();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
