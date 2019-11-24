package TowerDefense.Entity.Enemy;

import TowerDefense.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class AirPlane extends Enemy {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile270.png";
    double gx;
    double gy;

    public AirPlane(double x, double y) {
        super(x, y, 20, 1.5);
        img = new Image(IMAGE_URL);
        reward = 20;
        gx = getX();
        gy = getY();
        rotationAngle = Math.toDegrees(Math.atan((9*Config.TILE_SIZE-gy)/(16*Config.TILE_SIZE)));
    }

    @Override
    public void move(char[][] grid) {
        setX(getX() + speed*Math.cos(Math.toRadians(rotationAngle)));
        setY(getY() + speed*Math.sin(Math.toRadians(rotationAngle)));
        distance += speed;
    }
}
