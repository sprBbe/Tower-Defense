package TowerDefense.Entity.Bullet;

import TowerDefense.Config;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class Bullet extends GameEntity {
    int damage;
    Enemy enemy;

    double speed, rotationAngle;

    Image img;
    Image flames;

    public Bullet(double x, double y, Enemy enemy) {
        super(x, y);
        this.enemy = enemy;
        this.speed = 4;
        this.damage = 1;

        double dx = enemy.getX() - getX();
        double dy = enemy.getY() - getY();

        double angle = Math.atan2(dy, dx);

        rotationAngle = Math.toDegrees(angle) + 90;
        img = new Image("file:img/Retina/towerDefense_tile300.png");
    }

    @Override
    public void draw(GraphicsContext gc) {

        double xi = getX() - Config.TILE_SIZE / 2;
        double yi = getY() - Config.TILE_SIZE / 2;

        double dy = (double) Config.TILE_SIZE * .40 + Math.sin(Math.toRadians(rotationAngle + 180));

        Rotate r;

        if (flames != null) {
            r = new Rotate(rotationAngle + 180, getX(), getY());
            gc.save();
            gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
            gc.drawImage(flames, xi, yi - dy, Config.TILE_SIZE, Config.TILE_SIZE);
            gc.restore();
        }

        r = new Rotate(rotationAngle, getX(), getY());
        gc.save();
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(img, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        gc.restore();
    }

    public void move() {

        if (!enemy.isDead()) {
            double dx = enemy.getX() - getX();
            double dy = enemy.getY() - getY();

            double angle = Math.atan2(dy, dx);

            rotationAngle = Math.toDegrees(angle) + 90;

            setX(getX() + speed * Math.cos(angle));
            setY(getY() + speed * Math.sin(angle));
        } else {
            double angle = Math.toRadians(rotationAngle - 90);

            setX(getX() + speed * Math.cos(angle));
            setY(getY() + speed * Math.sin(angle));
        }

    }

    public void doDamage() {
        enemy.takeDamage(damage);
    }

    public boolean collided() {

        if (enemy.isDead()) {
            return false;
        }

        return distance(enemy) <= 5;
    }

    public boolean offScreen() {
        return (getX() < -Config.TILE_SIZE || getX() > Config.TILE_SIZE * 17 || getY() < -Config.TILE_SIZE || getY() > 17 * Config.TILE_SIZE);
    }

}
