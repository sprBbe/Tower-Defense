package TowerDefense;

import TowerDefense.Entity.Enemy.Enemy;
import TowerDefense.Entity.Tile.Tower.Tower;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.util.Iterator;

public class GameStage extends Canvas {
    private GameField gameField;
    private double money;
    private Image[] gridSet;
    private Tower selectedTower;
    private Button levelButton;

    public GameStage(int width, int height){
        super(width, height);
        this.money=50;
        this.gameField=new GameField();
        init();
    }

    public void setLevelButton(Button levelButton) {
        this.levelButton = levelButton;
    }

    public void setSelectedTower(Tower selectedTower) {
        this.selectedTower = selectedTower;
    }

    private final int[][] grid = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 5, 1, 1, 1, 1, 1, 1, 1, 6, 0, 0, 0, 0 }, { 0, 0, 0, 4, 9, 3, 3, 3, 3, 3, 10, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 4, 2, 0, 0, 0, 0, 0, 4, 2, 0, 0, 0, 0 }, { 0, 0, 0, 4, 2, 0, 0, 5, 1, 1, 11, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 4, 2, 0, 0, 4, 9, 3, 3, 7, 0, 0, 0, 0 }, { 0, 0, 0, 4, 2, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 11, 2, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0 }, { 3, 3, 3, 3, 7, 0, 0, 4, 12, 1, 1, 1, 1, 1, 1, 1 },
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

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    private void init() {
        gridSet = new Image[13];
        gridSet[0] = new Image("file:img/Retina/towerDefense_tile162.png");
        gridSet[1] = new Image("file:img/Retina/towerDefense_tile254.png");
        gridSet[2] = new Image("file:img/Retina/towerDefense_tile230.png");
        gridSet[3] = new Image("file:img/Retina/towerDefense_tile208.png");
        gridSet[4] = new Image("file:img/Retina/towerDefense_tile232.png");
        gridSet[5] = new Image("file:img/Retina/towerDefense_tile210.png");
        gridSet[6] = new Image("file:img/Retina/towerDefense_tile211.png");
        gridSet[7] = new Image("file:img/Retina/towerDefense_tile234.png");
        gridSet[8] = new Image("file:img/Retina/towerDefense_tile233.png");
        gridSet[9] = new Image("file:img/Retina/towerDefense_tile207.png");
        gridSet[10] = new Image("file:img/Retina/towerDefense_tile209.png");
        gridSet[11] = new Image("file:img/Retina/towerDefense_tile255.png");
        gridSet[12] = new Image("file:img/Retina/towerDefense_tile253.png");
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
        // DRAW TOWERS
        synchronized (gameField.getTowers()) {
            for (Tower temp : gameField.getTowers()) {
                temp.draw(gc);
            }
        }


        gc.fillText("Money: " + money, 100, 100);
    }

    public void update() {
        synchronized (gameField.getEnemies()) {
            Iterator<Enemy> eIterator = gameField.getEnemies().iterator();

            while (eIterator.hasNext()) {
                Enemy e = eIterator.next();

                if (e.isDead()) {
                    eIterator.remove();
                    money += e.getReward();
                    e = null;
                    continue;
                }

                e.move(route);
            }
        }
        for (Tower t : gameField.getTowers()) {

        }
    }
}
