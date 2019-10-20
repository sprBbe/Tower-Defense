package TowerDefense.Entity.Enemy;


import javafx.scene.image.Image;

import java.io.FileInputStream;

public class TankerEnemy extends Enemy {
    public static final Image TankerEnemyImage = new Image("file:img/background.png");
    public TankerEnemy(double x, double y) {
        super(x, y, 5, 1, 1,0, TankerEnemyImage);
    }
}
