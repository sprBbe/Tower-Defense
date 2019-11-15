package TowerDefense;

import TowerDefense.Entity.GameEntity;
import TowerDefense.Entity.Tower.MachineGunTower;
import TowerDefense.Entity.Tower.NormalTower;
import TowerDefense.Entity.Tower.SniperTower;
import TowerDefense.Entity.Tower.Tower;
import javafx.scene.input.MouseEvent;
import java.util.List;


public class InputHandler {

	public static Tower handleMouseClick(MouseEvent e, int[][] grid, List<Tower> towers, Tower selectedTower, GameStage gameStage) {
		if (selectedTower == null) {
			return null;
		}
		
		int mx = (int) e.getX();
		int my = (int) e.getY();
		
		if (grid[my / (int)Config.TILE_SIZE][mx / (int)Config.TILE_SIZE] == 0 && !collides(towers, mx, my)) {
			if (selectedTower instanceof NormalTower) {
				gameStage.buyTower(NormalTower.PRICE);
				towers.add(new NormalTower(mx, my));
				return null;
			} else if (selectedTower instanceof SniperTower) {
				gameStage.buyTower(SniperTower.PRICE);
				towers.add(new SniperTower(mx, my));
				return null;
			} else if (selectedTower instanceof MachineGunTower) {
				gameStage.buyTower(MachineGunTower.PRICE);
				towers.add(new MachineGunTower(mx, my));
				return null;
			}
		}
		
		return selectedTower;
	}

	public static boolean collides(Iterable<Tower> list, int mx, int my) {

		for (GameEntity entity : list) {
			if (entity.distance(mx, my) < (double) Config.TILE_SIZE * .6) {
				return true;
			}
		}

		return false;
	}
}
