package TowerDefense;

import TowerDefense.Entity.Bullet;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.Tower.Tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameField {
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Bullet> bullets;
    private Tower selectedTower;

    public GameField(){
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
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
