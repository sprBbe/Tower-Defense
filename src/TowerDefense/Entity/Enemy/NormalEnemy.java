package TowerDefense.Entity.Enemy;

import javafx.scene.image.Image;

import java.io.FileInputStream;

public class NormalEnemy extends Enemy {
    public static final Image NormalEnemyImage = new Image("file:img/background.png");
    public NormalEnemy(double x, double y) {
        super(x, y, 5, 1, 1,0, NormalEnemyImage);
    }
}
