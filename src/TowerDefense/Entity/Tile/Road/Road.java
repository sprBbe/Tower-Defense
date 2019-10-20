package TowerDefense.Entity.Tile.Road;

import TowerDefense.Entity.Tile.GameTile;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class Road extends GameTile {
    Image img;
    public static final Image mountainImage = new Image("file:img/background.png");
    public Road(){
        super(0,0);
        this.img = mountainImage;
    }

    public Road(double x, double y) {
        super(x, y);
    }
}
