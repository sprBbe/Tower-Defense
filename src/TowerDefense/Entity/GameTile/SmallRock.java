package TowerDefense.Entity.GameTile;

import javafx.scene.image.Image;

public class SmallRock extends GameTile {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile135.png";
    public SmallRock(double x, double y) {
        super(x, y);
        img = new Image(IMAGE_URL);
        rotationAngle = (Math.random() * ((360 - 0) + 1)) + 0;
    }
}
