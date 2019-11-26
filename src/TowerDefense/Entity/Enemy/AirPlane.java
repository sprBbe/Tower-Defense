package TowerDefense.Entity.Enemy;

import TowerDefense.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class AirPlane extends Enemy {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile270.png";
    public static final String IMAGE_SHADOW = "file:img/Retina/towerDefense_tile293.png";
    protected Image shadow;
    double gx;
    double gy;

    public AirPlane(double x, double y) {
        super(x, y, 20, 1.5);
        img = new Image(IMAGE_URL);
        shadow = new Image(IMAGE_SHADOW);
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

    @Override
    public void draw(GraphicsContext gc) {
        double xi = getX() - Config.TILE_SIZE / 2;
        double yi = getY() - Config.TILE_SIZE / 2;

        Rotate r = new Rotate(rotationAngle, getX(), getY());
        gc.save();
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(shadow, xi-Config.TILE_SIZE/2, yi-Config.TILE_SIZE/2, Config.TILE_SIZE, Config.TILE_SIZE);
        gc.drawImage(img, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        gc.restore();
    }
}
