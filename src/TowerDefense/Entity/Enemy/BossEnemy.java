package TowerDefense.Entity.Enemy;


import javafx.scene.image.Image;

import java.io.FileInputStream;

public class BossEnemy extends Enemy {
    public static final Image BossEnemyImage = new Image("file:img/background.png");
    public BossEnemy(double x, double y) {
        super(x, y, 5, 1, 1,0, BossEnemyImage);
    }
}
