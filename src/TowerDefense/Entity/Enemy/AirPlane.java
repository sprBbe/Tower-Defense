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
        super(x, y, 20, 2.5);
        img = new Image(IMAGE_URL);
        reward = 10;
        gx = getX();
        gy = getY();
        rotationAngle = Math.toDegrees(Math.atan((576-gy)/1024));
    }

    @Override
    public void move(char[][] grid) {
        setX(getX() + speed*Math.cos(Math.toRadians(rotationAngle)));
        setY(getY() + speed*Math.sin(Math.toRadians(rotationAngle)));
    }
}
