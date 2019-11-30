package TowerDefense.Entity.GameTile;

import TowerDefense.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class Bush extends GameTile {
    public static final String IMAGE_URL = "file:img/Retina/towerDefense_tile130.png";
    public double rotationAngle;
    public Bush(double x, double y) {
        super(x, y);
        img = new Image(IMAGE_URL);
        rotationAngle=0;
    }
    @Override
    public void draw(GraphicsContext gc) {
        double xi = getX() - Config.TILE_SIZE / 2;
        double yi = getY() - Config.TILE_SIZE / 2;
        if (rotationAngle <=360) rotationAngle++;
        else rotationAngle =0;

        Rotate r = new Rotate(rotationAngle, getX(), getY());
        gc.save();
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(img, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        gc.restore();
    }
}
