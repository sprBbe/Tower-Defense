package TowerDefense.Entity.Tower;

import TowerDefense.Config;
import TowerDefense.Entity.Bullet.Bullet;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Main;
import javafx.scene.image.Image;

public class MachineGunTower  extends Tower {
    public static final int PRICE = 30;
    public static final int RANGE = (int)Config.TILE_SIZE * 3;
    public static final String BASE_IMAGE_URL = "file:img/Retina/towerDefense_tile182.png";
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile250.png";

    public MachineGunTower(int x, int y) {
        super(x, y);
        baseImg = new Image(BASE_IMAGE_URL);
        img = new Image(IMAGE_URL);
        range = RANGE;
        damage = 10;
        shotSpeed = 20;
    }

    @Override
    public Bullet fire(Enemy e) {
        lastShotTime = Main.CURRENT_GAME_TICK;
        lastEnemy = e;

        double dy = (double) Config.TILE_SIZE * .3 * Math.sin(Math.toRadians(rotationAngle - 90));
        double dx = (double) Config.TILE_SIZE * .3 * Math.cos(Math.toRadians(rotationAngle - 90));

        return new Bullet(getX() + dx, getY() + dy, e);
    }
}
