package TowerDefense.Entity.Enemy;

import javafx.scene.image.Image;

public class GreenTank extends Enemy {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile301.png";

    public GreenTank(double x, double y) {
        super(x, y, 55, .5);
        img = new Image(IMAGE_URL);
        setDir('E');
        reward = 30;
    }
}
