package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    HomeScreen HOME=new HomeScreen();
    playgame GAMESCREEN=new playgame();
    PauseScreen PAUSED=new PauseScreen();
    ObstacleHitScreen HIT=new ObstacleHitScreen();
    SavedGameScreen SAVEDGAMES=new SavedGameScreen();
    HighScoreScreen HIGHSCORE=new HighScoreScreen();

    public void start(Stage stage) throws Exception {
        try {
            stage.setScene(Load_Environment(stage));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try{
            ResourceManager.Load("highscore",0);
        } catch (Exception e) {
            int[] aaa=new int[2];
            aaa[0]=0;
            aaa[1]=0;
                ResourceManager.Save2(aaa,"highscore");
        }

        Group root = new Group();
        Group roo2=new Group();

        roo2.getChildren().add(root);
        stage.setTitle("Home Screen");
        stage.show();
    }
    public Scene Load_Environment(Stage MainStage) throws Exception {

        return(HOME.SHOW(MainStage,GAMESCREEN,PAUSED,SAVEDGAMES,HIGHSCORE,HIT));
    }

    public static void main(String args[]){
        launch(args);
    }
}