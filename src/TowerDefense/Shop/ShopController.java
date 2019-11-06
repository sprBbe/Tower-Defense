package TowerDefense.Shop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ShopController {

    @FXML
    private Button normalTowerButton;

    @FXML
    private Button sniperTowerButton;

    @FXML
    private Button machinegunTowerButton;

    public Button getNormalTowerButton() {
        return normalTowerButton;
    }

    public Button getSniperTowerButton() {
        return sniperTowerButton;
    }

    public Button getMachinegunTowerButton() {
        return machinegunTowerButton;
    }


    @FXML
    public void initialize() {
        assert normalTowerButton != null : "fx:id=\"normalTowerButton\" was null check your FXML ";
        assert sniperTowerButton != null : "fx:id=\"sniperTowerButton\" was null check your FXML ";
        assert machinegunTowerButton != null : "fx:id=\"machinegunTowerButton\" was null check your FXML ";
    }
}
