package TowerDefense.Entity.Enemy;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class SmallerEnemy extends Enemy {
    public static final String IMAGE_URL = "file:img/PNG/Retina/towerDefense_tile248.png";

    public SmallerEnemy(int x, int y) {
        super(x, y, 5, 3);
        img = new Image(IMAGE_URL);
        setDir('E');
        reward = 3;
    }
}
