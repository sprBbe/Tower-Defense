package TowerDefense.Shop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;

public class ShopController {

    @FXML
    private Button normalTowerButton;

    @FXML
    private Button sniperTowerButton;

    @FXML
    private Button machinegunTowerButton;

    @FXML
    private Button Exit;

    public Button getNormalTowerButton() {
        return normalTowerButton;
    }

    public Button getSniperTowerButton() {
        return sniperTowerButton;
    }

    public Button getMachinegunTowerButton() {
        return machinegunTowerButton;
    }

    public ButtonBase getExit() {return Exit; }

    @FXML
    public void initialize() {
        assert normalTowerButton != null : "fx:id=\"normalTowerButton\" was null check your FXML ";
        assert sniperTowerButton != null : "fx:id=\"sniperTowerButton\" was null check your FXML ";
        assert machinegunTowerButton != null : "fx:id=\"machinegunTowerButton\" was null check your FXML ";
    }


}
