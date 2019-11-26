package TowerDefense;

import TowerDefense.Entity.Bullet.Bullet;
import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.Tower.Tower;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.List;

import static TowerDefense.InputHandler.collides;
import static TowerDefense.InputHandler.handleMouseClick;

public class GameStage extends Canvas {
    private GameField gameField;
    private double money;
    private int levelNum, live, mx, my;
    private Image[] gridSet;
    private Tower selectedTower;
    private Button levelButton;
    private boolean contained;

    public GameStage(int width, int height){
        super(width, height);
        this.money=50;
        this.live = 2;
        this.gameField=new GameField();
        levelNum=1;
        contained=true;
        init();
    }

    public void setLevelButton(Button levelButton) {
        this.levelButton = levelButton;
        this.levelButton.setOnAction((ActionEvent e) -> {
            //gameField.getBullets().clear();
            Thread lv = new Thread(new Level(levelNum++, this));
            //lv.setDaemon(true);
            lv.start();
            this.levelButton.setVisible(false);
        });
    }

    public int getLive() {
        return live;
    }

    public void onLevelDone() {
        levelButton.setVisible(true);
    }

    public void addEnemy(Enemy enemy) {
        gameField.addEnemy(enemy);
    }

    public void setSelectedTower(Tower selectedTower) {
        this.selectedTower = selectedTower;
    }

    private final int[][] grid = new int[][] {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 5, 1, 1, 1, 1, 1, 1, 1, 6, 0, 0, 0, 0 },
            { 0, 0, 0, 4, 9, 3, 3, 3, 3, 3, 10, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 4, 2, 0, 0, 0, 0, 0, 4, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 4, 2, 0, 0, 5, 1, 1, 11, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 4, 2, 0, 0, 4, 9, 3, 3, 7, 0, 0, 0, 0 },
            { 0, 0, 0, 4, 2, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 11, 2, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 3, 3, 3, 3, 7, 0, 0, 4, 12, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0, 0, 0, 8, 3, 3, 3, 3, 3, 3, 3, 3 } };

    private final char[][] route = new char[][] {
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'S', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'S', 'X', 'X', 'W', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'E', 'X', 'X', 'N', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

    public void buyTower(int cost) {
        money -= cost;
    }

    public double getMoney() {
        return money;
    }
    private void init() {
        gridSet = new Image[13];
        gridSet[0] = new Image("file:img/Retina/towerDefense_tile162.png");
        gridSet[1] = new Image("file:img/Retina/towerDefense_tile047.png");
        gridSet[2] = new Image("file:img/Retina/towerDefense_tile023.png");
        gridSet[3] = new Image("file:img/Retina/towerDefense_tile001.png");
        gridSet[4] = new Image("file:img/Retina/towerDefense_tile025.png");
        gridSet[5] = new Image("file:img/Retina/towerDefense_tile003.png");
        gridSet[6] = new Image("file:img/Retina/towerDefense_tile004.png");
        gridSet[7] = new Image("file:img/Retina/towerDefense_tile027.png");
        gridSet[8] = new Image("file:img/Retina/towerDefense_tile026.png");
        gridSet[9] = new Image("file:img/Retina/towerDefense_tile299.png");
        gridSet[10] = new Image("file:img/Retina/towerDefense_tile002.png");
        gridSet[11] = new Image("file:img/Retina/towerDefense_tile048.png");
        gridSet[12] = new Image("file:img/Retina/towerDefense_tile046.png");
        setOnMouseMoved((MouseEvent e) -> {
            mx = (int) e.getX();
            my = (int) e.getY();
        });

        setOnMouseExited((MouseEvent e) -> {
            contained = false;
        });

        setOnMouseEntered((MouseEvent e) -> {
            contained = true;
        });

        setOnMouseClicked((MouseEvent e) -> {
            selectedTower = handleMouseClick(e, grid, gameField.getTowers(), selectedTower, this);
        });
        }

    public void repaint() {
        GraphicsContext gc = getGraphicsContext2D();

        gc.clearRect(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        // DRAW BACKGROUND MAP
        // -------------------
        for (int i = 0; i < Config.TILE_HORIZONTAL; i++) {
            for (int j = 0; j < Config.TILE_VERTICAL; j++) {
                gc.drawImage(gridSet[grid[j][i]], i * Config.TILE_SIZE, j * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);
            }
        }
        // -------------------
        // DRAW BULLETS
        List<Bullet> tempBullet = gameField.getBullets();
        synchronized (tempBullet) {
            for (Bullet b : tempBullet) {
                b.draw(gc);
            }
        }
        // DRAW TOWERS
        List<Tower> tempTower = gameField.getTowers();
        synchronized (tempTower) {
            for (Tower temp : tempTower) {
                temp.draw(gc);
            }
        }
        // DRAW ENEMIES
        List<Enemy> tempEnemy = gameField.getEnemies();
        synchronized (tempEnemy) {
            for (Enemy temp : tempEnemy) {
                temp.draw(gc);
            }
        }


        // DRAW THE SELECTED TOWER
        if (selectedTower != null && contained) {
            if (grid[my / (int)Config.TILE_SIZE][mx / (int)Config.TILE_SIZE] == 0 && !collides(gameField.getTowers(), mx, my)) {
                selectedTower.draw(gc, mx, my);

                int range = selectedTower.getRange();
                gc.setStroke(Color.RED);
                gc.strokeOval(mx - range, my - range, range * 2, range * 2);
            } else {
                gc.fillOval(mx, my, 5, 5);
            }
        }

        gc.fillText("Money: " + money + "\n"+"Live: " + live , 100, 100);
    }

    public void update() {
        List<Tower> tempTower = gameField.getTowers();
        List<Enemy> tempEnemy = gameField.getEnemies();
        List<Bullet> tempBullet = gameField.getBullets();
        for (Tower t : tempTower) {

            Enemy frontEnemy = null;

            for (Enemy e : tempEnemy) {
                if (e.distance(t) < t.getRange()) {
                    if (frontEnemy == null) {
                        frontEnemy = e;
                    } else if (e.getDistanceTraveled() > frontEnemy.getDistanceTraveled()) {
                        frontEnemy = e;
                    }
                }
            }

            if (frontEnemy != null && t.canFire()) {
                tempBullet.add(t.fire(frontEnemy));
            }

            t.updateAngle();
        }

        synchronized (tempEnemy) {
            Iterator<Enemy> eIterator = tempEnemy.iterator();

            while (eIterator.hasNext()) {
                Enemy e = eIterator.next();
                //Nếu enemy chết thì cộng tiền thưởng và xoá nó
                if (e.isDead()) {
                    eIterator.remove();
                    money += e.getReward();
                    e = null;
                    continue;
                }
                if (e.offScreen()) {
                    eIterator.remove();
                    live -= 1;
                    e = null;
                    continue;
                }
                e.move(route);
            }
        }

        synchronized (tempBullet) {
            Iterator<Bullet> bIterator = tempBullet.iterator();

            while (bIterator.hasNext()) {
                Bullet b = bIterator.next();

                b.move();

                if (b.collided()) {
                    b.doDamage();
                    bIterator.remove();
                    b = null;
                } else if (b.offScreen()) {
                    bIterator.remove();
                    b = null;
                }
            }
        }
    }
}
