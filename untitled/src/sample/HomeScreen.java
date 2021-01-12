package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.util.Random;

public class HomeScreen {
    public Scene SHOW(Stage MainStage,playgame PLAYGAME,PauseScreen PAUSED,SavedGameScreen SAVEDGAMES,HighScoreScreen HIGHSCORE,ObstacleHitScreen HIT) throws Exception
    {
        Stage theStage=new Stage();
        theStage.setTitle("Home");
        Group root = new Group();
        Scene theScene = new Scene(root);
        Pane pane=new Pane();
        StackPane holder=new StackPane();
        Canvas canvas = new Canvas( 1280, 658 );
        holder.getChildren().add(canvas);
        theStage.setScene(theScene);
        root.getChildren().add(holder);
        holder.setStyle("-fx-background-color: grey");
        Button StartGame=new Button();
        StartGame.setLayoutX(455);
        StartGame.setLayoutY(70);
        Button ResumeGame=new Button();
        ResumeGame.setLayoutX(430);
        ResumeGame.setLayoutY(380);
        Button BlackWhite=new Button();
        BlackWhite.setLayoutX(520);
        BlackWhite.setLayoutY(390);
        Button HighScore=new Button();
        HighScore.setLayoutX(610);
        HighScore.setLayoutY(380);
        Button ExitGame=new Button();
        ExitGame.setLayoutX(700);
        ExitGame.setLayoutY(380);
        pane.getChildren().add(StartGame);
        pane.getChildren().add(ResumeGame);
        pane.getChildren().add(ExitGame);
        pane.getChildren().add(HighScore);
        pane.getChildren().add(BlackWhite);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(41,41,41));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Image logo=new Image("Logo.jpg");
        Image High=new Image("highh.jpg");
        Image Quit=new Image("quit.jpg");
        Image Resume=new Image("pause.jpg");
        Image Name=new Image("name.jpg");
        Image Black=new Image("Bwlogo.jpg");
        ImageView logo_v=new ImageView(logo);
        ImageView High_v=new ImageView(High);
        ImageView quit_v=new ImageView(Quit);
        ImageView resume_v=new ImageView(Resume);
        ImageView name_v=new ImageView(Name);
        ImageView Black_v=new ImageView(Black);
        logo_v.setFitHeight(300);
        High_v.setFitHeight(85);
        quit_v.setFitHeight(90);
        resume_v.setFitHeight(90);
        name_v.setFitWidth(250);
        Black_v.setFitWidth(75);
        logo_v.setPreserveRatio(true);
        High_v.setPreserveRatio(true);
        quit_v.setPreserveRatio(true);
        resume_v.setPreserveRatio(true);
        name_v.setPreserveRatio(true);
        Black_v.setPreserveRatio(true);
        name_v.setX(490);
        name_v.setY(490);
        pane.getChildren().add(name_v);
        StartGame.setPrefSize(80, 80);
        ResumeGame.setPrefSize(80, 80);
        HighScore.setPrefSize(80, 80);
        ExitGame.setPrefSize(80, 80);
        StartGame.setGraphic(logo_v);
        ResumeGame.setGraphic(resume_v);
        ExitGame.setGraphic(quit_v);
        HighScore.setGraphic(High_v);
        BlackWhite.setGraphic(Black_v);
        pane.getChildren().add(logo_v);
        StartGame.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        ExitGame.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        ResumeGame.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        HighScore.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        BlackWhite.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        ExitGame.setOnAction(e -> {
            try {
                Platform.exit();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        HighScore.setOnAction(e -> {
            try {
                MainStage.setScene(HIGHSCORE.SHOW(MainStage,SAVEDGAMES,PLAYGAME,this,PAUSED,HIT));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        ResumeGame.setOnAction(e -> { // saved game
            try {
                MainStage.setScene(SAVEDGAMES.SHOW(MainStage,SAVEDGAMES,PLAYGAME,HIGHSCORE,this,PAUSED,HIT));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        BlackWhite.setOnAction(e -> { // saved game
            try {
                Obstacle obb[]=new Obstacle[10];
                for(int i=0;i<obb.length;i++)
                {
                    Random r = new Random();
                    int a=r.nextInt(4);
                    switch(a)
                    {
                        case 0:
                            obb[i]=new circle(0);
                            break;
                        case 1:
                            obb[i]=new triangle(0);
                            break;
                        case 2:
                            obb[i]=new Line(0);
                            break;
                        case 3:
                            obb[i]=new sample.Rectangle(0);
                            break;
                    }
                    obb[i].setYcord(obb[i].getYcord()-i*500);
                }
                ball ball =new ball(0);
                BlackWhitePlay BWPlay=new BlackWhitePlay();
                MainStage.setScene(BWPlay.SHOW(ball,MainStage,PAUSED,SAVEDGAMES,HIGHSCORE,this,obb,HIT,PLAYGAME,0));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        StartGame.setOnAction(e -> {
            try {
                 Obstacle ob[]=new Obstacle[10];
                for(int i=0;i<ob.length;i++)
                {
                    Random r = new Random();
                    int a=r.nextInt(4);
                    switch(a)
                    {
                        case 0:
                            ob[i]=new circle();
                            break;
                        case 1:
                            ob[i]=new triangle();
                            break;
                        case 2:
                            ob[i]=new Line();
                            break;
                        case 3:
                            ob[i]=new sample.Rectangle();
                            break;
                    }
                    ob[i].setYcord(ob[i].getYcord()-i*500);

                }
                ball ball =new ball();
                MainStage.setScene(PLAYGAME.SHOW(ball,MainStage,PAUSED,SAVEDGAMES,HIGHSCORE,this,ob,HIT,0));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        root.getChildren().add(pane);
        //theStage.show();
        return theScene;
    }
}