package TowerDefense.Entity.Enemy;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class TankerEnemy extends Enemy {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile247.png";

    public TankerEnemy(double x, double y) {
        super(x, y, 25, .5);
        img = new Image(IMAGE_URL);
        setDir('E');
        reward = 8;
    }
}
