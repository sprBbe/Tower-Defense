package TowerDefense;

import TowerDefense.Entity.Bullet;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.Tile.Mountain;
import TowerDefense.Entity.Tile.Road.Road;
import TowerDefense.Entity.Tile.Tower.Tower;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class GameField {
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Bullet> bullets;
    private Mountain mountain;
    private Road road;
    private Tower selectedTower;

    public GameField(){
        this.mountain=new Mountain();
        this.road=new Road();
    }

    public Mountain getMountain() {
        return mountain;
    }
}
