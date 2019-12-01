package TowerDefense.GameOver;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameOverController {
    @FXML
    private Button Replay;

    @FXML
    private Button Exit;

    @FXML
    private Button muteButton;

    @FXML
    private Text HighestLevel;

    public Button getReplay() {
        return Replay;
    }

    public Button getExit() {
        return Exit;
    }

    public Button getMuteButton() {
        return muteButton;
    }

    public Text getHighestLevel() {
        return HighestLevel;
    }

    @FXML
    public void initialize() {
        assert Replay != null : "fx:id=\"Replay\" was null check your FXML ";
        assert Exit != null : "fx:id=\"Exit\" was null check your FXML ";
    }
}
