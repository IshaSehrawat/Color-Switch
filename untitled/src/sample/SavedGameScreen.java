package sample;

import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.layout.StackPane;

public class SavedGameScreen {
    public Scene SHOW(Stage MainStage,SavedGameScreen SAVEDGAMES,playgame PLAYGAME,HighScoreScreen HIGHSCORE,HomeScreen HOME,PauseScreen PAUSED,ObstacleHitScreen HIT) throws Exception
    {
        Stage theStage=new Stage();
        theStage.setTitle("High Score");
        Group root = new Group();
        Scene theScene = new Scene(root);
        Pane pane=new Pane();
        StackPane holder=new StackPane();
        Canvas canvas = new Canvas( 1280, 658 );
        holder.getChildren().add(canvas);
        theStage.setScene(theScene);
        Rectangle rectangle=new Rectangle(0,0,Color.rgb(243,151,52));
        rectangle.setX(0.0f);
        rectangle.setY(260.0f);
        rectangle.setWidth(1280.0f);
        rectangle.setHeight(30.0f);
        Font font1 = Font.font( "Roboto", FontWeight.BOLD, 22 );
        Label b2= new Label("CHOOSE GAME");
        b2.setFont(font1);
        b2.setTextFill(Color.rgb(255,255,255));
        b2.setLayoutX(560);
        b2.setLayoutY(257);
        root.getChildren().add(holder);
        holder.setStyle("-fx-background-color: grey");
        Image SAVED=new Image("Save.jpg");
        Image BacktoHome=new Image("Restart.jpg");
        ImageView Back_v=new ImageView(BacktoHome);
        Back_v.setFitWidth(85);
        Back_v.setPreserveRatio(true);
        Back_v.setX(0);
        Back_v.setY(10);
        ImageView save_v=new ImageView(SAVED);
        save_v.setFitWidth(200);
        save_v.setPreserveRatio(true);
        save_v.setX(530);
        save_v.setY(60);
        Back_v.setOnMouseClicked((MouseEvent e) -> {
            try {
                MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,PAUSED,this,HIGHSCORE,HIT));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Font font2 = Font.font( "Roboto", FontWeight.BOLD, 20 );

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(5,5,5));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Label[] gamess=new Label[10];
        for(int i=0;i<5;i++)
        {
            gamess[i]=new Label("Game "+Integer.toString(i+1));
            gamess[i].setFont(font2);
            gamess[i].setLayoutX(450);
            gamess[i].setLayoutY(300+i*50);
            gamess[i].setTextFill(Color.rgb(255,255,255));
            root.getChildren().add(gamess[i]);
        }
        for(int i=5;i<10;i++)
        {
            gamess[i]=new Label("Game "+Integer.toString(i+1));
            gamess[i].setFont(font2);
            gamess[i].setLayoutX(750);
            gamess[i].setLayoutY(300+(i-5)*50);
            gamess[i].setTextFill(Color.rgb(255,255,255));
            root.getChildren().add(gamess[i]);
        }

        gamess[0].setOnMouseClicked((MouseEvent e) -> {
        try {
            SaveData data = (SaveData) ResourceManager.Load("Game",0);
            MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT,data.getScore()));
        } catch (Exception exception) {
            System.out.println("Game Does Not Exist");
        }
        });

        gamess[1].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",1);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[2].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",2);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
                System.out.println("clicked?");
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[3].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",3);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[4].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",4);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[5].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",5);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[6].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",6);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[7].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",7);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[8].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",8);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        gamess[9].setOnMouseClicked((MouseEvent e) -> {
            try {
                SaveData data = (SaveData) ResourceManager.Load("Game",9);
                MainStage.setScene(PLAYGAME.SHOW(data.getBall(),MainStage,PAUSED,this,HIGHSCORE,HOME,data.getOb(),HIT, data.getScore()));
            } catch (Exception exception) {
                System.out.println("Game Does Not Exist");
            }
        });

        pane.getChildren().add(save_v);
        pane.getChildren().add(Back_v);
        root.getChildren().add(pane);
        root.getChildren().add(rectangle);
        root.getChildren().add(b2);
        return theScene;
    }
}
