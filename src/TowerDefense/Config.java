package TowerDefense;

public final class Config {
    //Name of Game
    public static final String GAME_NAME = "Tower Defense";

    //Size of the tile, in pixel.
    public static final int TILE_SIZE = 32;

    //Num of horizontal tiles
    public static final int TILE_HORIZONTAL = 30;

    //Num of vertical tiles
    public static final int TILE_VERTICAL = 20;

    //Num of tiles
    public static final int TILE_MAP_COUNT = TILE_HORIZONTAL * TILE_VERTICAL;

    //Size of the screen
    public static final int SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;

    //Size of the screen
    public static final int SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;
}
