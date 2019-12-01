package TowerDefense.GameOver;

import TowerDefense.GameStage;
import TowerDefense.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class GameOver {
    private GameStage gameStage;
    private Main main;

    private FXMLLoader fxmlLoader;

    public GameOver(AnchorPane pane, GameStage gameStage, Main main) {

        try {
            String beforeString = readContentFromFile("src/TowerDefense/GameOver/HighestLevel");
            int beforeInt = Integer.valueOf(beforeString);
            int highestLevel = 0;
            if (gameStage.getLevelNum()>beforeInt) {
                highestLevel = gameStage.getLevelNum();
                overwriteContentToFile("src/TowerDefense/GameOver/HighestLevel",Integer.toString(highestLevel));
            }
            else highestLevel = beforeInt;

            fxmlLoader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
            Parent root = fxmlLoader.load();
            pane.getChildren().add(root);

            GameOverController controller = fxmlLoader.getController();
            controller.getHighestLevel().setText("Highest Level: "+ highestLevel);

            if (main.mediaPlayer.isMute()){
                controller.getMuteButton().setText("Unmute");
            }
            else {
                controller.getMuteButton().setText("Mute");
            }
            //Controller controller = fxmlLoader.getController();
            controller.getReplay().setOnAction((ActionEvent e) -> {
                main.animationLoop.play();
                main.startGame();
            });

            controller.getExit().setOnAction((ActionEvent e) -> {
                Platform.exit();
                System.exit(0);
            });
            controller.getMuteButton().setOnAction((ActionEvent e) -> {
                if (main.mediaPlayer.isMute()){
                    main.mediaPlayer.setMute(false);
                    controller.getMuteButton().setText("Mute");
                }
                else {
                    main.mediaPlayer.setMute(true);
                    controller.getMuteButton().setText("Unmute");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readContentFromFile(String path) throws Exception{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String temp = "", str = "";
            while ((temp = br.readLine()) != null) {
                str += temp;
                //str+="\n";
            }
            br.close();
            fr.close();
            return str;
    }

    // Xoá nội dung ở trong file và ghi xâu mới vào
    public static void overwriteContentToFile(String path, String str)throws Exception{
            FileWriter wr = new FileWriter(path);
            BufferedWriter bf = new BufferedWriter(wr);
            bf.write(str);
            bf.close();
    }
}
