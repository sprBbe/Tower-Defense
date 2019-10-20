package TowerDefense.Entity.Enemy;

import TowerDefense.Entity.GameEntity;
import javafx.scene.image.Image;

public abstract class Enemy extends GameEntity {
    private double health, reward,speed,armor;
    private Image img;
    public Enemy(double x, double y,double health,double reward,double speed,double armor, Image img){
        super(x,y);
        this.armor=armor;
        this.health=health;
        this.reward=reward;
        this.speed=speed;
        this.img=img;
    }
    public boolean isDead() {
        return health <= 0;
    }
    public void takeDamage(int damage) {
        health -= damage;
    }
}
