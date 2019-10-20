package TowerDefense;

public class GameStage {
    private GameField gameField;
    private double money;

    public GameStage(){
        this.money=50;
        this.gameField=new GameField();
    }

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
}
