package sample;

import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.layout.StackPane;

import java.util.Random;

public class ObstacleHitScreen{
    public Scene SHOW(ball ball,Stage MainStage,SavedGameScreen SAVEDGAMES,playgame PLAYGAME,HighScoreScreen HIGHSCORE,HomeScreen HOME,PauseScreen PAUSED,Obstacle ob[],int SKORE) throws Exception
    {
        Stage theStage=new Stage();
        theStage.setTitle("Pause");
        Group root = new Group();
        Scene theScene = new Scene(root);
        Pane pane=new Pane();
        StackPane holder=new StackPane();
        Canvas canvas = new Canvas( 1280, 658 );
        holder.getChildren().add(canvas);
        theStage.setScene(theScene);
        Rectangle rectangle1=new Rectangle(0,0,Color.rgb(57,57,57));
        rectangle1.setX(0.0f);
        rectangle1.setY(200.0f);
        rectangle1.setWidth(1280.0f);
        rectangle1.setHeight(30.0f);
        Rectangle rectangle2=new Rectangle(0,0,Color.rgb(243,151,52));
        Rectangle rectangle3=new Rectangle(0,0,Color.rgb(41,41,41));
        rectangle2.setX(0.0f);
        rectangle2.setY(300.0f);
        rectangle2.setWidth(1280.0f);
        rectangle2.setHeight(30.0f);
        rectangle3.setX(0.0f);
        rectangle3.setY(400.0f);
        rectangle3.setWidth(1280.0f);
        rectangle3.setHeight(30.0f);
        Label b1= new Label("SCORE");

        Font font1 = Font.font( "Roboto", FontWeight.BOLD, 22 );
        b1.setFont(font1);
        b1.setTextFill(Color.rgb(255,255,255));
        b1.setLayoutX(590);
        b1.setLayoutY(197);
        Label b2= new Label("BEST SCORE");
        Label b3= new Label("TOTAL POINTS        USE 10 POINTS TO REVIVE");
        b2.setFont(font1);
        b2.setTextFill(Color.rgb(255,255,255));
        b2.setLayoutX(560);
        b2.setLayoutY(297);
        b3.setFont(font1);
        b3.setTextFill(Color.rgb(255,255,255));
        b3.setLayoutX(430);
        b3.setLayoutY(397);
        root.getChildren().add(holder);
        holder.setStyle("-fx-background-color: grey");
        Button ReviveGame=new Button();
        ReviveGame.setLayoutX(670);
        ReviveGame.setLayoutY(470);
        Button BackHome=new Button();
        BackHome.setLayoutX(470);
        BackHome.setLayoutY(470);
        Button Restart=new Button();
        Restart.setLayoutX(570);
        Restart.setLayoutY(470);
        pane.getChildren().add(ReviveGame);
        pane.getChildren().add(Restart);
        pane.getChildren().add(BackHome);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(5,5,5));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Image revive_img=new Image("Revive.jpg");
        Image home_img=new Image("Home.jpg");
        Image restart_img=new Image("Restart.jpg");
        Image Logo=new Image("name5.jpg");
        ImageView revive_v=new ImageView(revive_img);
        ImageView quit_v=new ImageView(home_img);
        ImageView restart_v=new ImageView(restart_img);
        ImageView Logo_v=new ImageView(Logo);
        revive_v.setFitHeight(85);
        quit_v.setFitHeight(85);
        restart_v.setFitHeight(85);
        Logo_v.setFitWidth(300);
        revive_v.setPreserveRatio(true);
        quit_v.setPreserveRatio(true);
        restart_v.setPreserveRatio(true);
        Logo_v.setPreserveRatio(true);
        Logo_v.setX(480);
        Logo_v.setY(45);
        pane.getChildren().add(Logo_v);
        ReviveGame.setPrefSize(80, 80);
        BackHome.setPrefSize(80, 80);
        Restart.setPrefSize(80, 80);
        ReviveGame.setGraphic(revive_v);
        Restart.setGraphic(restart_v);
        BackHome.setGraphic(quit_v);
        Restart.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        ReviveGame.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        BackHome.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        int[] data=new int[2];      // to be saved
        data[0]=SKORE;
        data[1]=SKORE;
        int[] datacheck = (int[]) ResourceManager.Load("highscore",0);
        if(datacheck[0]>data[0]){data[0]=datacheck[0];}
        Label CurrentScore=new Label(Integer.toString(data[1]));
        Label HighScore=new Label(Integer.toString(data[0]));
        System.out.println("Before adding "+datacheck[1]);
        data[1]+=datacheck[1];
        System.out.println("After adding "+datacheck[1]);
        Label Totalreward=new Label(Integer.toString(data[1]));
        ResourceManager.Save2(data,"highscore");
        CurrentScore.setFont(font1);
        HighScore.setFont(font1);
        Totalreward.setFont(font1);
        CurrentScore.setTextFill(Color.rgb(255,255,255));
        CurrentScore.setLayoutX(620);
        CurrentScore.setLayoutY(235);
        HighScore.setTextFill(Color.rgb(255,255,255));
        HighScore.setLayoutX(620);
        HighScore.setLayoutY(335);
        Totalreward.setTextFill(Color.rgb(255,255,255));
        Totalreward.setLayoutX(600);
        Totalreward.setLayoutY(397);
        Restart.setOnAction(e -> {
            try {
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
                MainStage.setScene(PLAYGAME.SHOW(new ball(),MainStage,PAUSED,SAVEDGAMES,HIGHSCORE,HOME,ob,this,0));

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        BackHome.setOnAction(e -> {
            try {
                MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,PAUSED,SAVEDGAMES,HIGHSCORE,this));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        ReviveGame.setOnAction(e -> {
            try {
                int[] currentData=(int[])ResourceManager.Load("highscore",0);
                System.out.println("current points "+currentData[1]);
                if(currentData[1]<10)
                {
                    MainStage.setScene(HOME.SHOW(MainStage, PLAYGAME, PAUSED, SAVEDGAMES, HIGHSCORE, this));
                }
                else
                    {
                        System.out.println("Before reviving: "+currentData[1]);
                        currentData[1]-=10;
                        System.out.println("after reviving: "+currentData[1]);
                        ResourceManager.Save2(currentData,"highscore");
                        MainStage.setScene((PLAYGAME.SHOW(ball,MainStage,PAUSED,SAVEDGAMES,HIGHSCORE,HOME,ob,this,SKORE)));
                    }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        root.getChildren().add(pane);
        root.getChildren().add(rectangle1);
        root.getChildren().add(rectangle2);
        root.getChildren().add(b1);
        root.getChildren().add(rectangle3);
        root.getChildren().add(b3);
        root.getChildren().add(b2);
        root.getChildren().add(HighScore);
        root.getChildren().add(CurrentScore);
        root.getChildren().add(Totalreward);
        //theStage.show();
        return theScene;
    }

}