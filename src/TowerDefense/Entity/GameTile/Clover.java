package TowerDefense.Entity.GameTile;

import javafx.scene.image.Image;

public class Clover extends GameTile {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile132.png";
    public Clover(double x, double y) {
        super(x, y);
        img = new Image(IMAGE_URL);
    }
}
