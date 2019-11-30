package TowerDefense.Entity.GameTile;

import javafx.scene.image.Image;

public class CircleBush extends GameTile {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile133.png";

    public CircleBush(double x, double y) {
        super(x, y);
        img = new Image(IMAGE_URL);
    }
}
