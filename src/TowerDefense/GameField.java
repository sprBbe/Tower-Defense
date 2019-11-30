package TowerDefense;

import TowerDefense.Entity.Bullet.Bullet;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.GameTile.GameTile;
import TowerDefense.Entity.Tower.Tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameField {
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Bullet> bullets;
    private List<GameTile> tiles;

    public GameField(){
        towers = Collections.synchronizedList(new ArrayList<>());
        enemies = Collections.synchronizedList(new ArrayList<>());
        bullets = Collections.synchronizedList(new ArrayList<>());
        tiles = new ArrayList<GameTile>();
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

    public List<GameTile> getTiles() {
        return tiles;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
