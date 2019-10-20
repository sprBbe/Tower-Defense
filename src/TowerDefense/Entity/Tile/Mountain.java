package TowerDefense.Entity.Tile;

import TowerDefense.Config;
import TowerDefense.Entity.Tile.GameTile;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class Mountain extends GameTile{
    private Image img;
    public Mountain(double x, double y) {
        super(x, y);
    }
    public static final Image mountainImage = new Image("file:img/background.png");

    public Mountain(){
        super(0,0);
        this.img = mountainImage;
    }

    public Image getImg() {
        return img;
    }

    public Image getMountainImage() {
        return img;
    }
}
