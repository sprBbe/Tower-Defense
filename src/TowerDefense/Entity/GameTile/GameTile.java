package TowerDefense.Entity.GameTile;


import TowerDefense.Config;
import TowerDefense.Entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public abstract class GameTile extends GameEntity {
    protected Image img;
    public double rotationAngle;
    public GameTile(double x, double y) {
        super(x, y);
    }

    public void draw(GraphicsContext gc) {
        double xi = getX() - Config.TILE_SIZE / 2;
        double yi = getY() - Config.TILE_SIZE / 2;

        Rotate r = new Rotate(rotationAngle, getX(), getY());
        gc.save();
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(img, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        gc.restore();
    }
}
