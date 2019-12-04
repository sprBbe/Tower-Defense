package TowerDefense;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private AnchorPane leftPane;

    @FXML
    private AnchorPane rightPane;

    public AnchorPane getLeftPane() {
        return leftPane;
    }

    public AnchorPane getRightPane() {
        return rightPane;
    }

    @FXML
    private Button startButton;

    @FXML
    private Button quitButton;

    @FXML
    private Button muteButton;

    @FXML
    private Button Tutorial;

    public Button getMuteButton() {
        return muteButton;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    public Button getTutorial() {
        return Tutorial;
    }

    @FXML
    public void initialize() {
        assert leftPane != null : "fx:id=\"leftPane\" was null check your FXML ";
        assert rightPane != null : "fx:id=\"rightPane\" was null check your FXML ";
    }
}
