package TowerDefense.Entity.Tile.Tower;

import TowerDefense.Entity.Tile.GameTile;

public abstract class Tower extends GameTile {
    private int shotSpeed, range, damage;
    public Tower(double x, double y) {
        super(x, y);
    }
}
