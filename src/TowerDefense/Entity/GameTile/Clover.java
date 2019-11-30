package TowerDefense.Entity.GameTile;

import TowerDefense.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class Clover extends GameTile {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile132.png";

    public Clover(double x, double y) {
        super(x, y);
        img = new Image(IMAGE_URL);
    }


}
