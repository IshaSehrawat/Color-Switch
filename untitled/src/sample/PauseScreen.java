package sample;

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

public class PauseScreen{
    public Scene SHOW(ball ball,playgame PLAYGAME,Stage MainStage,SavedGameScreen SAVEDGAMES,HighScoreScreen HIGHSCORE,HomeScreen HOME,Obstacle ob[],ObstacleHitScreen HIT,int SKORE) throws Exception
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

        root.getChildren().add(holder);
        holder.setStyle("-fx-background-color: grey");
        Button Resume=new Button();
        Resume.setLayoutX(520);
        Resume.setLayoutY(170);
        Button SaveGame=new Button();
        SaveGame.setLayoutX(470);
        SaveGame.setLayoutY(380);
        Button BackHome=new Button();
        BackHome.setLayoutX(570);
        BackHome.setLayoutY(380);
        Button Restart=new Button();
        Restart.setLayoutX(670);
        Restart.setLayoutY(380);
        pane.getChildren().add(Resume);
        pane.getChildren().add(SaveGame);
        pane.getChildren().add(Restart);
        pane.getChildren().add(BackHome);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(5,5,5));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Image resume_img=new Image("Resume.jpg");
        Image save_img=new Image("Save.jpg");
        Image home_img=new Image("Home.jpg");
        Image restart_img=new Image("Restart.jpg");
        Image PAUSE=new Image("PAUSE_.jpg");
        ImageView resume_v=new ImageView(resume_img);
        ImageView save_v=new ImageView(save_img);
        ImageView quit_v=new ImageView(home_img);
        ImageView restart_v=new ImageView(restart_img);
        ImageView PAUSE_v=new ImageView(PAUSE);
        resume_v.setFitHeight(180);
        save_v.setFitHeight(85);
        quit_v.setFitHeight(85);
        restart_v.setFitHeight(85);
        PAUSE_v.setFitWidth(250);
        resume_v.setPreserveRatio(true);
        save_v.setPreserveRatio(true);
        quit_v.setPreserveRatio(true);
        restart_v.setPreserveRatio(true);
        PAUSE_v.setPreserveRatio(true);
        PAUSE_v.setX(500);
        PAUSE_v.setY(45);
        pane.getChildren().add(PAUSE_v);
        Resume.setPrefSize(80, 80);
        SaveGame.setPrefSize(80, 80);
        BackHome.setPrefSize(80, 80);
        Restart.setPrefSize(80, 80);
        Resume.setGraphic(resume_v);
        SaveGame.setGraphic(save_v);
        Restart.setGraphic(restart_v);
        BackHome.setGraphic(quit_v);
        Resume.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        Restart.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        SaveGame.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
        BackHome.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
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
                MainStage.setScene(PLAYGAME.SHOW(new ball(),MainStage,this,SAVEDGAMES,HIGHSCORE,HOME,ob,HIT,0));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        SaveGame.setOnAction(e -> {
            try {
                int no1=(int)ResourceManager.Load("Nsaved",0);
                no1++;
                System.out.println("Number of games is: "+no1);
                ResourceManager.Save2(no1,"Nsaved");
            } catch (Exception exception) {
                int no2=0;
                try {
                    ResourceManager.Save2(no2,"Nsaved");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            int[] dataa=new int[2];
            dataa[0]=SKORE;
            dataa[1]=SKORE;
            int[] datacheck = new int[0];
            try {
                datacheck = (int[]) ResourceManager.Load("highscore",0);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            if(datacheck[0]>dataa[0]){dataa[0]=datacheck[0];}
            dataa[1]+=datacheck[1];
            try {
                ResourceManager.Save2(dataa,"highscore");
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            SaveData data =new SaveData();
            data.setB(ball);
            data.setScore(SKORE);
            data.setOb(new Obstacle[ob.length]);
            for(int i=0;i< ob.length;i++){
                System.out.println("savingg "+i+" "+ob[i].getYcord());
                data.getOb()[i]=ob[i].Clon();
            }
            try {
                ResourceManager.Save(data, "Game");
//                for(int i=0;i<3;i++){System.out.println("loop saved is"+data.getOb()[i].getYcord());}
                MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,this,SAVEDGAMES,HIGHSCORE,HIT));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        BackHome.setOnAction(e -> {
            try {
                //code for saving
                MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,this,SAVEDGAMES,HIGHSCORE,HIT));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Resume.setOnAction(e -> {
            try {

                MainStage.setScene(PLAYGAME.SHOW(ball, MainStage, this, SAVEDGAMES, HIGHSCORE, HOME, ob, HIT,SKORE));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }


        });

        root.getChildren().add(pane);
        //theStage.show();
        return theScene;
    }

}