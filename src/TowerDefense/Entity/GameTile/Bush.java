package TowerDefense.Entity.GameTile;

import javafx.scene.image.Image;

public class Bush extends GameTile {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile130.png";

    public Bush(double x, double y) {
        super(x, y);
        img = new Image(IMAGE_URL);
    }
}
