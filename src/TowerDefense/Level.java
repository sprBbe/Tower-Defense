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
		double sx = -1 * Config.TILE_SIZE;
		double sy = 8 * Config.TILE_SIZE;
		while(gameStage.getGameField().getEnemies().size()<10) {
				gameStage.addEnemy(new NormalEnemy(sx, sy));
		}

		gameStage.onLevelDone();
	}



}