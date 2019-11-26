package TowerDefense.GameOver;

import TowerDefense.GameStage;
import TowerDefense.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GameOver {
    private GameStage gameStage;
    private Main main;

    private FXMLLoader fxmlLoader;

    public GameOver(AnchorPane pane, GameStage gameStage, Main main) {

        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
            Parent root = fxmlLoader.load();
            pane.getChildren().add(root);

            GameOverController controller = fxmlLoader.getController();
            if (main.mediaPlayer.isMute()){
                controller.getMuteButton().setText("Unmute");
            }
            else {
                controller.getMuteButton().setText("Mute");
            }
            //Controller controller = fxmlLoader.getController();
            controller.getReplay().setOnAction((ActionEvent e) -> {
                main.animationLoop.play();
                main.startGame();
            });

            controller.getExit().setOnAction((ActionEvent e) -> {
                Platform.exit();
                System.exit(0);
            });
            controller.getMuteButton().setOnAction((ActionEvent e) -> {
                if (main.mediaPlayer.isMute()){
                    main.mediaPlayer.setMute(false);
                    controller.getMuteButton().setText("Mute");
                }
                else {
                    main.mediaPlayer.setMute(true);
                    controller.getMuteButton().setText("Unmute");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
