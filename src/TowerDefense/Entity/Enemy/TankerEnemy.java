package TowerDefense.Entity.Enemy;


import javafx.scene.image.Image;

public class TankerEnemy extends Enemy {
    public static final String IMAGE_URL = "";
    public static final Image NormalEnemyImage = new Image(IMAGE_URL);
    public TankerEnemy(double x, double y) {
        super(x, y, 5, 1, 1,0, NormalEnemyImage);
    }
}
