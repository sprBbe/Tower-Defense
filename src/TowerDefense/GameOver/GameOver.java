package TowerDefense.GameOver;

import TowerDefense.Controller;
import TowerDefense.GameStage;
import TowerDefense.Main;
import TowerDefense.Shop.ShopController;
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
            //Controller controller = fxmlLoader.getController();
            controller.getReplay().setOnAction((ActionEvent e) -> {
                main.animationLoop.play();
                main.startGame();
            });

            controller.getExit().setOnAction((ActionEvent e) -> {
                Platform.exit();
                System.exit(0);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
