package TowerDefense;

public final class Config {
    //Name of Game
    public static final String GAME_NAME = "Tower Defense made by BBe and BCC";

    //Size of the tile, in pixel.
    public static final double TILE_SIZE = 64;

    //Num of horizontal tiles
    public static final double TILE_HORIZONTAL = 16;

    //Num of vertical tiles
    public static final double TILE_VERTICAL = 10;

    //Num of tiles
    public static final double TILE_MAP_COUNT = TILE_HORIZONTAL * TILE_VERTICAL;

    //Size of the screen
    public static final double SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;

    //Size of the screen
    public static final double SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;

    //Map image
    public static final String[][] MAP_SPRITES = new String[][] {
            { "024", "024", "003", "047", "047", "047", "004", "024", "024", "024" },
            { "024", "024", "025", "299", "001", "002", "023", "024", "024", "024" },
            { "024", "024", "025", "023", "024", "025", "023", "024", "024", "024" },
            { "003", "047", "048", "023", "024", "025", "023", "024", "024", "024" },
            { "025", "299", "001", "027", "024", "025", "046", "047", "047", "047" },
            { "025", "023", "024", "024", "024", "026", "001", "001", "001", "001" },
            { "025", "023", "024", "024", "024", "024", "024", "024", "024", "024" },
    };
}
