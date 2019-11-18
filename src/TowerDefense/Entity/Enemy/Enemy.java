package TowerDefense.Entity.Enemy;

import TowerDefense.Config;
import TowerDefense.Entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public abstract class Enemy extends GameEntity {
    protected double health, reward,speed,rotationAngle,distance;
    protected Image img;
    protected char dir;


    public Enemy(double x, double y, double health, double speed) {
        super(x, y);
        this.health = health;
        this.speed = speed;
        distance = 0;
    }
    public double getDistanceTraveled() {
        return distance;
    }
    public void setDir(char dir) {
        this.dir = dir;
    }

    public double getReward() {
        return reward;
    }

    public boolean isDead() {
        return health <= 0;
    }
    public void takeDamage(int damage) {
        health -= damage;
    }

    public void move(char[][] grid) {
        int gx, gy;

        switch(dir) {
            case 'N':
                gx = (int)((getX() - Config.TILE_SIZE / 2) / Config.TILE_SIZE);
                gy = (int)(getY() / Config.TILE_SIZE);
                //System.out.printf(gx +"N"+ getX()+" " + gy+" "+ getY()+"\n");
                break;
            case 'S':
                gx = (int)((getX() - Config.TILE_SIZE / 2) / Config.TILE_SIZE);
                gy = (int)(getY() / Config.TILE_SIZE) - 1;
                //System.out.printf(gx +"s"+ getX()+" " + gy+" "+ getY()+"\n");
                break;
            case 'E':
                gx = (int)(getX() / Config.TILE_SIZE) - 1;
                gy = (int)((getY() - Config.TILE_SIZE / 2) / Config.TILE_SIZE);
                //System.out.printf(gx +"e"+ getX()+" " + gy+" "+ getY()+"\n");
                break;
            case 'W':
                gx = (int)(getX() / Config.TILE_SIZE);
                gy = (int)((getY() - Config.TILE_SIZE / 2) / Config.TILE_SIZE);
                //System.out.printf(gx +"W"+ getX()+" " + gy+" "+ getY()+"\n");
                break;
            default:
                gx = (int)((getX() - Config.TILE_SIZE / 2) / Config.TILE_SIZE);
                gy = (int)((getY() - Config.TILE_SIZE / 2) / Config.TILE_SIZE);
                break;
        }

        if (gx < 0) { gx = 0; }
        if (gy < 0) { gy = 0; }

        char newDir = grid[gy][gx];

        if (newDir != 'X') {
            dir = newDir;
        }

        switch(dir) {
            case 'N':
                setY(getY() - speed);
                rotationAngle = -90;
                break;
            case 'S':
                setY(getY() + speed);
                rotationAngle = 90;
                break;
            case 'E':
                setX(getX() + speed);
                rotationAngle = 0;
                break;
            case 'W':
                setX(getX() - speed);
                rotationAngle = 180;
                break;
            default:
                break;
        }

        distance += speed;
    }
    @Override
    public void draw(GraphicsContext gc) {

        double xi = getX() - Config.TILE_SIZE / 2;
        double yi = getY() - Config.TILE_SIZE / 2;

        Rotate r = new Rotate(rotationAngle, getX(), getY());
        gc.save();
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(img, xi, yi, Config.TILE_SIZE, Config.TILE_SIZE);
        gc.restore();
    }

    public boolean offScreen() {
        return (getX() >= 16 * Config.TILE_SIZE);
    }
}
