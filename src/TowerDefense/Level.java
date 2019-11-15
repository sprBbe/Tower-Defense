package TowerDefense;

import TowerDefense.Entity.Enemy.*;

public class Level implements Runnable {
    private final GameStage gameStage;
    private double level;

    public Level(int level, GameStage gameStage) {
        this.gameStage = gameStage;
        this.level = level;
    }

    private double transitions[][] = {{0.85, 0, 0, 0,},
            {0.075, 0.45, 0.45, 0.1,},
            {0.075, 0.45, 0.45, 0.1,},
            {0, 0.1, 0.1, 0.8}};

    private double e1_strength = 1;
    private double e2_strength = 1.25;
    private double e3_strength = 1.25;
    private double e4_strength = 1.5;

    private static double enemyDensity[];

    public static void mult(double a[][], double b[], double c[]) {
        c[0] = a[0][0] * b[0] + a[0][1] * b[1] + a[0][2] * b[2] + a[0][3] * b[3];
        c[1] = a[1][0] * b[0] + a[1][1] * b[1] + a[1][2] * b[2] + a[1][3] * b[3];
        c[2] = a[2][0] * b[0] + a[2][1] * b[1] + a[2][2] * b[2] + a[2][3] * b[3];
        c[3] = a[3][0] * b[0] + a[3][1] * b[1] + a[3][2] * b[2] + a[3][3] * b[3];
    }

    private void updateEnemyDensityMatrix() {
        if (enemyDensity != null) {
            double result[] = new double[4];
            mult(transitions, enemyDensity, result);
            enemyDensity = result;
        } else {
            double result[] = {1, 0, 0, 0};
            enemyDensity = result;
        }
    }

    public void run() {
        double a = 1;
        double b = 1.5;
        double k = -1;

        double sx = -1 * Config.TILE_SIZE;
        double sy = 8 * Config.TILE_SIZE;

        double count = a * Math.pow(b, (double) level + k);

        updateEnemyDensityMatrix();

        while (count >= 0) {
            double temp = Math.random();

            if (temp < enemyDensity[0]) {
                gameStage.addEnemy(new NormalEnemy(sx, sy));
                count -= e1_strength;
            } else if (temp < enemyDensity[0] + enemyDensity[1]) {
                gameStage.addEnemy(new SmallerEnemy(sx, sy));
                count -= e2_strength;
            } else if (temp < enemyDensity[0] + enemyDensity[1] + enemyDensity[2]) {
                gameStage.addEnemy(new TankerEnemy(sx, sy));
                count -= e3_strength;
            } else {
                gameStage.addEnemy(new BossEnemy(sx, sy));
                count -= e4_strength;
            }

            long endTick = Main.CURRENT_GAME_TICK + 100;
            try {
                while (endTick > Main.CURRENT_GAME_TICK) {
                    Thread.yield();
                }
            } catch (Exception e) {
            }
        }

        gameStage.onLevelDone();
    }


}
