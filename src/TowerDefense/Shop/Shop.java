package TowerDefense.Shop;

import TowerDefense.Entity.Tower.MachineGunTower;
import TowerDefense.Entity.Tower.NormalTower;
import TowerDefense.Entity.Tower.SniperTower;
import TowerDefense.GameStage;
import TowerDefense.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Shop {

    private GameStage gameStage;
    private Main main;

    private FXMLLoader fxmlLoader;

    public Shop(AnchorPane pane) {

        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("shop.fxml"));
            Parent root = fxmlLoader.load();
            pane.getChildren().add(root);

            ShopController controller = fxmlLoader.getController();

            Button normalTower = controller.getNormalTowerButton();
            Button sniperTower = controller.getSniperTowerButton();
            Button machinegunTower = controller.getMachinegunTowerButton();

            normalTower.setOnAction((ActionEvent e) -> {
                if (gameStage.getMoney() >= NormalTower.PRICE) {
                    gameStage.setSelectedTower(new NormalTower(0, 0));
                }
            });

            sniperTower.setOnAction((ActionEvent e) -> {
                if (gameStage.getMoney() >= SniperTower.PRICE) {
                    gameStage.setSelectedTower(new SniperTower(0, 0));
                }
            });

            machinegunTower.setOnAction((ActionEvent e) -> {
                if (gameStage.getMoney() >= MachineGunTower.PRICE) {
                    gameStage.setSelectedTower(new MachineGunTower(0, 0));
                }
            });
            controller.getExit().setOnAction((ActionEvent e) -> {
                Platform.exit();
                System.exit(0);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGameListener(GameStage gameStage) {
        this.gameStage = gameStage;
    }

    public void setMainListener(Main main) {
        this.main = main;
    }

}