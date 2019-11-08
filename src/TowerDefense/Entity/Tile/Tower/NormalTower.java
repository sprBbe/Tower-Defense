package TowerDefense.Entity.Tile.Tower;

import TowerDefense.Config;
import javafx.scene.image.Image;

public class NormalTower extends Tower {
    public static final int PRICE = 10;
    public static final int RANGE = (int)Config.TILE_SIZE * 2;
    public static final String BASE_IMAGE_URL = "file:img/PNG/Retina/towerDefense_tile180.png";
    public static final String IMAGE_URL = "file:img/PNG/Retina/towerDefense_tile249.png";
    public NormalTower(double x, double y) {
        super(x, y);
        baseImg = new Image(BASE_IMAGE_URL);
        img = new Image(IMAGE_URL);
        range = RANGE;
        damage = 1;
        shotSpeed = 100;
    }
}
