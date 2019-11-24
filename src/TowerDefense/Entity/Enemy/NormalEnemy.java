package TowerDefense.Entity.Enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class NormalEnemy extends Enemy {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile245.png";

    public NormalEnemy(double x, double y) {
        super(x, y, 5, 1);
        img = new Image(IMAGE_URL);
        setDir('E');
        reward = 5;
    }
}
