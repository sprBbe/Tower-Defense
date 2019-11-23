package TowerDefense.Entity.Tower;

import TowerDefense.Config;
import TowerDefense.Entity.Bullet.Bullet;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.GameEntity;
import TowerDefense.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public abstract class Tower extends GameEntity {
    int shotSpeed, range, damage;
    long lastShotTime;
    double rotationAngle = 0;

    Enemy lastEnemy;
    Image img, baseImg, blankImg;

    public Tower(double x, double y) {
        super(x, y);
    }
    public int getRange() {
        return range;
    }

    public boolean canFire() {
        int dt = (int)(Main.CURRENT_GAME_TICK - lastShotTime);

        return dt >= shotSpeed;
    }
    public abstract Bullet fire(Enemy e);

    public void draw(GraphicsContext gc){
        double xi = getX() - Config.TILE_SIZE / 2;
        double yi = getY() - Config.TILE_SIZE / 2;

        if (baseImg != null) {
            gc.drawImage(baseImg, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        }

        Rotate r = new Rotate(rotationAngle, getX(), getY());
        gc.save();
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());

        if (!canFire() && blankImg != null) {
            gc.drawImage(blankImg, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        } else {
            gc.drawImage(img, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        }

        gc.restore();
    }
    public void draw(GraphicsContext gc, int x, int y) {
        double xi = x - Config.TILE_SIZE / 2;
        double yi = y - Config.TILE_SIZE / 2;

        if (baseImg != null) {
            gc.drawImage(baseImg, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        }

        gc.drawImage(img, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
    }

    public void updateAngle() {
        if (lastEnemy != null) {
            double dx = lastEnemy.getX() - getX();
            double dy = lastEnemy.getY() - getY();

            rotationAngle = Math.toDegrees(Math.atan2(dx, -dy));
        }
    }
}
