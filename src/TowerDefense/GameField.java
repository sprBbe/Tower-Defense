package TowerDefense;

import TowerDefense.Entity.Bullet;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.Tile.Road.Road;
import TowerDefense.Entity.Tile.Tower.Tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameField {
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Bullet> bullets;
    private Road road;
    private Tower selectedTower;

    public GameField(){
        this.road=new Road();
        towers = Collections.synchronizedList(new ArrayList<>());
        enemies = Collections.synchronizedList(new ArrayList<>());
        bullets = Collections.synchronizedList(new ArrayList<>());
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }
    public void addEnemy(Enemy simpleEnemy) {
        enemies.add(simpleEnemy);
    }
}
