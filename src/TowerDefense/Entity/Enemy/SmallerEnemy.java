package TowerDefense.Entity.Enemy;


import javafx.scene.image.Image;

import java.io.FileInputStream;

public class SmallerEnemy extends Enemy {
    public static final Image SmallerEnemyImage = new Image("file:img/background.png");
    public SmallerEnemy(double x, double y) {
        super(x, y, 5, 1, 1,0, SmallerEnemyImage);
    }
}
