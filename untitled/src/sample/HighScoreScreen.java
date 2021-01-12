package sample;

import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.layout.StackPane;

public class HighScoreScreen{
    public Scene SHOW(Stage MainStage,SavedGameScreen SAVEDGAMES,playgame PLAYGAME,HomeScreen HOME,PauseScreen PAUSED,ObstacleHitScreen HIT) throws Exception
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
        Rectangle rectangle2=new Rectangle(0,0,Color.rgb(243,151,52));
        rectangle.setX(0.0f);
        rectangle.setY(300.0f);
        rectangle2.setX(0.0f);
        rectangle2.setY(390.0f);
        rectangle.setWidth(1280.0f);
        rectangle.setHeight(30.0f);
        rectangle2.setWidth(1280.0f);
        rectangle2.setHeight(30.0f);
        Font font1 = Font.font( "Roboto", FontWeight.BOLD, 22 );
        Label b2= new Label("BEST SCORE");
        Label b3= new Label("TOTAL POINTS");
        b2.setFont(font1);
        b2.setTextFill(Color.rgb(255,255,255));
        b2.setLayoutX(560);
        b2.setLayoutY(297);
        b3.setFont(font1);
        b3.setTextFill(Color.rgb(255,255,255));
        b3.setLayoutX(550);
        b3.setLayoutY(387);
        root.getChildren().add(holder);
        holder.setStyle("-fx-background-color: grey");
        Image Highscore=new Image("HighBlack.jpg");
        Image BacktoHome=new Image("Restart.jpg");
        ImageView high_v=new ImageView(Highscore);
        ImageView Back_v=new ImageView(BacktoHome);
        high_v.setFitWidth(250);
        Back_v.setFitWidth(85);
        high_v.setPreserveRatio(true);
        Back_v.setPreserveRatio(true);
        Back_v.setX(0);
        Back_v.setY(10);
        high_v.setX(500);
        high_v.setY(60);

        int[] DD=new int[2];
        int[] data = (int[]) ResourceManager.Load("highscore",0);
        DD[0]=data[0];
        DD[1]=data[1];
        Label SKOR=new Label(Integer.toString(data[0]));
        Label reward=new Label(Integer.toString(data[1]));

        SKOR.setFont(font1);
        SKOR.setTextFill(Color.rgb(255,255,255));
        SKOR.setLayoutX(610);
        SKOR.setLayoutY(335);
        reward.setFont(font1);
        reward.setTextFill(Color.rgb(255,255,255));
        reward.setLayoutX(610);
        reward.setLayoutY(425);
        System.out.println("HIGH "+DD[0]+" Total rewards: "+DD[1]);

        Back_v.setOnMouseClicked((MouseEvent e) -> {
            try {
                MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,PAUSED,SAVEDGAMES,this,HIT));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(5,5,5));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        pane.getChildren().add(high_v);
        pane.getChildren().add(Back_v);
        root.getChildren().add(pane);
        root.getChildren().add(rectangle);
        root.getChildren().add(b2);
        root.getChildren().add(SKOR);
        root.getChildren().add(rectangle2);
        root.getChildren().add(b3);
        root.getChildren().add(reward);
        //theStage.show();
        return theScene;
    }
}
