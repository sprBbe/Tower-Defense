package TowerDefense.Entity.GameTile;

import javafx.scene.image.Image;

public class StarBush extends GameTile {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile134.png";
    public StarBush(double x, double y, double rotationAngle) {
        super(x, y);
        img = new Image(IMAGE_URL);
        this.rotationAngle=rotationAngle;
    }
}
