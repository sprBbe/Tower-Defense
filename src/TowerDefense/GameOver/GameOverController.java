package TowerDefense.GameOver;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameOverController {
    @FXML
    private Button Replay;

    @FXML
    private Button Exit;

    public Button getReplay() {
        return Replay;
    }

    public Button getExit() {
        return Exit;
    }

    @FXML
    public void initialize() {
        assert Replay != null : "fx:id=\"Replay\" was null check your FXML ";
        assert Exit != null : "fx:id=\"Exit\" was null check your FXML ";
    }
}
