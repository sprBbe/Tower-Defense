package TowerDefense;

import TowerDefense.Entity.Enemy.*;

public class Level implements Runnable {
    private final GameStage gameStage;
    private double level;

    public Level(int level, GameStage gameStage) {
        this.gameStage = gameStage;
        this.level = level;
    }

    public void run() {
        double sx = 0 * Config.TILE_SIZE;
        double sy = 8 * Config.TILE_SIZE;

        double count = level * 10;

        while (count >= 0) {
            if (count >= 100) {
                gameStage.addEnemy(new AirBus(0, (Math.random() * ((Config.TILE_SIZE*9 - 0) + 1)) + 0));
                count -= 100;
            } else if (count >= 60) {
                gameStage.addEnemy(new Tank(sx, sy));
                count -= 60;
            } else if (count >= 35){
                gameStage.addEnemy(new AirPlane(0, (Math.random() * ((Config.TILE_SIZE*9 - 0) + 1)) + 0));
                count -= 35;
            }else if (count >= 25){
                gameStage.addEnemy(new BossEnemy(sx, sy));
                count -= 25;
            }else if (count >= 20) {
                gameStage.addEnemy(new TankerEnemy(sx, sy));
                count -= 20;
            }else if (count >= 12){
                gameStage.addEnemy(new SmallerEnemy(sx, sy));
                count -= 12;
            }else {
                gameStage.addEnemy(new NormalEnemy(sx, sy));
                count -= 3;
            }
            long endTick = Main.CURRENT_GAME_TICK + 100;
            try {
                while (endTick > Main.CURRENT_GAME_TICK) {
                    Thread.yield();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        gameStage.onLevelDone();
    }


}
