package TowerDefense.Entity.Enemy;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class BossEnemy extends Enemy {
    public static final String IMAGE_URL = "file:img/PNG/Retina/towerDefense_tile246.png";

    public BossEnemy(int x, int y) {
        super(x, y, 20, 2.5);
        img = new Image(IMAGE_URL);
        setDir('E');
        reward = 10;
    }
}
