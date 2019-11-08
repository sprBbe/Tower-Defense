package TowerDefense.Entity.Tile;

import TowerDefense.Entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameTile extends GameEntity {
    public GameTile(double x, double y) {
        super(x, y);
    }
    public abstract void draw(GraphicsContext gc);
}
