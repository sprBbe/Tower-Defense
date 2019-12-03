package TowerDefense.Entity.Enemy;

import javafx.scene.image.Image;

public class WhiteTank extends Enemy{
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile302.png";

    public WhiteTank(double x, double y) {
        super(x, y, 120, 2);
        img = new Image(IMAGE_URL);
        setDir('E');
        reward = 30;
    }
}

