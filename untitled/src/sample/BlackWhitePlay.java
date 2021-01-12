package sample;
import java.util.Random;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.*;
import javafx.stage.Screen;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.LinkedList;

public class BlackWhitePlay {
    int SKORE=0;
    public Scene SHOW(ball b1,Stage MainStage,PauseScreen PAUSED,SavedGameScreen SAVEDGAMES,HighScoreScreen HIGHSCORE,HomeScreen HOME,Obstacle ob[],ObstacleHitScreen HIT,playgame PLAYGAME,int SKORE2) throws Exception {
        SKORE=SKORE2;
        Circle circle = new Circle();
        Circle circle2=new Circle();
        Circle circle3=new Circle();
        final int[] score = {0};
        Label b2= new Label("SCORE: "+ SKORE);
        Font font1 = Font.font( "Roboto", FontWeight.BOLD, 22 );
        b2.setFont(font1);
        b2.setTextFill(Color.rgb(255,255,255));
        final int[] r = {0,0,0,9,1};
        b2.setLayoutX(220);
        b2.setLayoutY(10);
        circle.setCenterX(b1.getXcord());
        circle2.setCenterX(100);
        circle2.setCenterY(600);
        circle3.setCenterX(100);
        circle3.setCenterY(0);
        circle.setCenterY(b1.getYcord());
        circle.setRadius(b1.getRadius());
        circle2.setRadius(b1.getRadius());
        circle3.setRadius(b1.getRadius());
        circle2.setFill(Color.valueOf(b1.getColor()));
        circle3.setFill(Color.valueOf(b1.getColor()));
        circle.setFill(Color.valueOf(b1.getColor()));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Group roo2=new Group();
        javafx.scene.image.Image pausEE=new javafx.scene.image.Image("pause.jpg");
        javafx.scene.image.Image ChangeClr=new javafx.scene.image.Image("changecolor.jpg");
        ImageView pause_v=new ImageView(pausEE);
        pause_v.setFitHeight(80);
        pause_v.setPreserveRatio(true);
        pause_v.setX(800);
        pause_v.setY(30);
        roo2.getChildren().add(b2);
        ArrayList<Group> grouplist = new ArrayList<Group>();
        javafx.scene.image.Image rewardd=new javafx.scene.image.Image("BlackWhiteStar.jpg");
        float previous[]=new float[ob.length];
        Group group3[]=new Group[ob.length];
        Group group4[]=new Group[ob.length];
        Group obs[]=new Group[ob.length];
        for(int i=0;i<ob.length;i++)
        {   previous[i]=ob[i].getYcord();
            Group roo1 = new Group();
            obs[i]= hollow(ob[i]);
            roo1.getChildren().add(obs[i]);
            Group roo4= new Group();
            Group roo3=new Group();
            Group rooo=new Group();
            ImageView reward_v=new ImageView(rewardd);
            ImageView change_v=new ImageView(ChangeClr);
            reward_v.setFitWidth(35);
            reward_v.setPreserveRatio(true);
            change_v.setFitWidth(35);
            change_v.setPreserveRatio(true);
            reward_v.setX(ob[i].getXcord()-17);
            reward_v.setY(ob[i].getYcord()-17);
            change_v.setX(ob[i].getXcord()-17);
            change_v.setY(ob[i].getYcord()+250);
            ob[i].getChange().setStt(false);
            if (ob[i].getReward().isStatus())
                rooo.getChildren().add(reward_v);
            roo1.getChildren().add(rooo);
            group4[i]=rooo;
            if (ob[i].getChange().isStt())
                roo3.getChildren().add(change_v);
            group3[i]=roo3;
            RotateTransition rotateTransition2 = new RotateTransition();
            rotateTransition2.setDuration(Duration.millis(6000));
            rotateTransition2.setNode(roo3);
            rotateTransition2.setByAngle(360);
            rotateTransition2.setInterpolator(Interpolator.LINEAR);
            rotateTransition2.setCycleCount(20000);
            RotateTransition rotateTransition1 = new RotateTransition();
            rotateTransition1.setDuration(Duration.millis(6000));
            rotateTransition1.setNode(roo1);
            rotateTransition1.setByAngle(360);
            rotateTransition1.setInterpolator(Interpolator.LINEAR);
            rotateTransition1.setCycleCount(20000);
            roo4.getChildren().add(roo1);
            roo4.getChildren().add(roo3);
            grouplist.add(roo4);
            roo2.getChildren().add(roo4);
            rotateTransition1.play();
            rotateTransition2.play();
        }
        Scene scene = new Scene(roo2, bounds.getWidth(), bounds.getHeight(), Color.rgb(0, 0, 0));

        final double rectangleVSpeed = 300 ;
        final double minY = 0 ;
        final double maxY = 660 ;
        final LinkedList<KeyCode> keyStack = new LinkedList<>();
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            String code2=code.toString();

            if (! keyStack.contains(code)) {
                keyStack.push(code);

                if (code2.equals("UP"))
                    r[0]=1;
            }
        });

        scene.setOnKeyReleased(event ->{
            keyStack.remove(event.getCode());
            r[0]=0;
        });
        int start=b1.getYcord();
        final LongProperty lastUpdateTime = new SimpleLongProperty();
        final AnimationTimer rectangleAnimation = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {

                final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0 ;
                float obstacle_y=0;
                double deltaY = 0 ;
                if (keyStack.peek()!=null && r[0]==1)
                {
                    deltaY = -rectangleVSpeed * elapsedSeconds;
                    obstacle_y=-(float) deltaY/4 -((float) r[4]/100)*(float)deltaY/4;
                    r[1]=1;
                    r[4]+=1;
                }
                else {
                    deltaY = (rectangleVSpeed * elapsedSeconds )/2;
                }
                if (r[1]==1) {
                    circle.setTranslateY(clamp(b1.getYcord()+deltaY, minY, maxY)-start);
                    b1.set((int) clamp(b1.getYcord() + deltaY, minY, maxY));
                    if (b1.getYcord() >= 650) {
                        try {
                            r[1]=0;
                            MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,PAUSED,SAVEDGAMES,HIGHSCORE,HIT));
                            this.stop();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }

                    for (int i = 0; i < grouplist.size(); i++) {
                        grouplist.get(i).setTranslateY(ob[i].getYcord() + obstacle_y-previous[i]);
                        ob[i].setYcord((ob[i].getYcord() + obstacle_y));
                        for (Node path: obs[i].getChildren()){
                            if (((Path)Shape.intersect(circle, (Path)path)).getElements().size()>0 ){
                                boolean test=(circle.getFill().toString()).equals(((Path) path).getStroke().toString());
                                if (test==false)
                                {
                                    try {
                                        MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,PAUSED,SAVEDGAMES,HIGHSCORE,HIT));
                                        this.stop();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    this.stop();
                                }
                                test=true;
                            }
                        }
                        if (b1.getYcord() >= 650) {
                            try {
                                r[1]=0;
                                MainStage.setScene(HOME.SHOW(MainStage,PLAYGAME,PAUSED,SAVEDGAMES,HIGHSCORE,HIT));
                                this.stop();
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            this.stop();
                        }

                        if (b1.getYcord()-ob[i].getYcord()-250<10 &&  b1.getYcord()-ob[i].getYcord()-250>-10)
                        { if (ob[i].getChange().isStt()) {
                            Random rand = new Random();
                            int rp = 1;
                            while (rp == 1) {
                                String a[] = ob[i].getChange().getColors();
                                int k=0;
                                if(ob[i] instanceof triangle){k=3;}
                                else if(ob[i] instanceof Line){k=2;}
                                else{k=4;}
                                int r = rand.nextInt(k);
                                if (Paint.valueOf(a[r])!=circle.getFill())
                                {circle.setFill(Paint.valueOf(a[r]));
                                    b1.setColor(a[r]);
                                    group3[i].setVisible(false);
                                    ob[i].getChange().setStt(false);
                                    rp=0;
                                }
                            }
                        }
                        }
                        if (b1.getYcord()-ob[i].getYcord()<10 &&  b1.getYcord()-ob[i].getYcord()>-10)
                        {
                            if(ob[i].getReward().isStatus())
                            {group4[i].setVisible(false);
                                score[0] +=1;
                                SKORE++;
                                ob[i].getReward().setStatus(false);
                                b2.setText("SCORE: "+ SKORE);}
                        }
                        if (ob[i].getYcord()>1200)
                        {
                            System.out.println("before bw "+r[3]);
                            ob[i].setYcord(ob[r[3]].getYcord()-500);
                            r[3]=i;
                            System.out.println("after bw"+r[3]);
                            ob[i].getReward().setStatus(true);
                        }
                    }

                }
                r[2]=SKORE;
                lastUpdateTime.set(timestamp);
            }
        };

        roo2.getChildren().add(circle);
        rectangleAnimation.start();

        return scene;
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    private Group hollow(Obstacle abc ) {
        Group root = new Group();
        if (abc instanceof circle)
        {
            circle obj=(circle)abc;
            int xcen = (int)obj.getXcord();
            int ycen = (int)obj.getYcord();

            int r=0;
            for (int i = 0; i < 4; i++)
            {
                Path path = new Path();
                int rr=1;
                int k=1;
                int p=1;
                int z=1;
                ArcTo arcTo = new ArcTo();
                if (r%2==0 && i/2==0)
                {
                    k=1;rr=0;p=0;z=1;
                    arcTo.setSweepFlag(true);
                }
                else  if ( i/2==0)
                {
                    k=0;rr=1;p=-1;z=0;

                    arcTo.setSweepFlag(true);
                }
                else if(r%2==0 && i/2!=0)
                {
                    k=-1;rr=0;p=0;z=-1;

                    arcTo.setSweepFlag(true);
                }
                else {
                    k=0;rr=-1;p=1;z=0;

                    arcTo.setSweepFlag(true);
                }

                path.getElements().add(new MoveTo(xcen + k*obj.getOuter_radius(),ycen+ rr*obj.getOuter_radius()));
                arcTo.setX(xcen + p*obj.getOuter_radius());
                arcTo.setY(ycen+  z*obj.getOuter_radius());
                r+=1;
                arcTo.setRadiusX(obj.getOuter_radius());
                arcTo.setRadiusY(obj.getOuter_radius());
                path.getElements().add(arcTo);
                path.setStroke(Color.valueOf(obj.getColor().get(i)));
                path.setStrokeWidth(obj.getOuter_radius()-obj.getInner_radius());
                root.getChildren().add(path);
            }

        }
        if (abc instanceof triangle)
        {
            triangle obj=(triangle)abc;
            int xcen = (int)obj.getXcord();
            int ycen = (int)obj.getYcord();
            for (int i=0;i<3;i++)
            {
                float a ,b,c,d;
                Path path = new Path();
                if ( i==0)
                {
                    a=-2^(1/3);
                    b=1;
                    c=2^(1/3);
                    d=1;
                }
                else if (i==1)
                {
                    a=2^(1/3);
                    b=1;
                    c=0;
                    d=-2;
                }
                else
                {
                    a=0;
                    b=-2;
                    c=-2^(1/3);
                    d=1;
                }

                path.getElements().add(new MoveTo(xcen + a*obj.getOuter_radius(),ycen+ b*obj.getOuter_radius()));
                path.getElements().add(new LineTo(xcen + c*obj.getOuter_radius(), ycen+ d*obj.getOuter_radius()));
                path.setStroke(Color.valueOf(obj.getColor().get(i)));
                path.setStrokeWidth(obj.getOuter_radius()-obj.getInner_radius());
                root.getChildren().add(path);
            }

        }
        if(abc instanceof Line)
        {
            Line obj=(Line)abc;
            int xcen = (int)obj.getXcord();
            int ycen = (int)obj.getYcord();
            for(int i=0;i<2;i++)
            {
                Path path = new Path();
                path.getElements().add(new MoveTo(xcen+(i-1)*100+(i*25),ycen));
                path.getElements().add(new LineTo(xcen+(i)*100+(25*(i-1)),ycen));
                path.setStroke(Color.valueOf(obj.getColor().get(i)));
                path.setStrokeWidth(obj.thickness);
                root.getChildren().add(path);
            }
        }
        if(abc instanceof Rectangle)
        {
            Rectangle obj=(Rectangle)abc;
            int xcen = (int)obj.getXcord();
            int ycen = (int)obj.getYcord();
            Path path1=new Path();
            Path path2=new Path();
            Path path3=new Path();
            Path path4=new Path();
            path1.getElements().add(new MoveTo(xcen - obj.getInner_y2(), ycen - obj.getInner_y2()));
            path1.getElements().add(new LineTo(xcen + obj.getInner_y2(),ycen-obj.getInner_y2()));
            path1.setStroke(Color.valueOf(obj.getColor().get(0)));
            path1.setStrokeWidth(15);
            root.getChildren().add(path1);
            path2.getElements().add(new MoveTo(xcen + obj.getInner_y2(),ycen-obj.getInner_y2()));
            path2.getElements().add(new LineTo(xcen + obj.getInner_y2(),ycen+obj.getInner_y2()));
            path2.setStroke(Color.valueOf(obj.getColor().get(1)));
            path2.setStrokeWidth(15);
            root.getChildren().add(path2);
            path3.getElements().add(new MoveTo(xcen + obj.getInner_y2(),ycen+obj.getInner_y2()));
            path3.getElements().add(new LineTo(xcen - obj.getInner_y2(),ycen+obj.getInner_y2()));
            path3.setStroke(Color.valueOf(obj.getColor().get(2)));
            path3.setStrokeWidth(15);
            root.getChildren().add(path3);
            path4.getElements().add(new MoveTo(xcen - obj.getInner_y2(),ycen+obj.getInner_y2()));
            path4.getElements().add(new LineTo(xcen - obj.getInner_y2(),ycen-obj.getInner_y2()));
            path4.setStroke(Color.valueOf(obj.getColor().get(3)));
            path4.setStrokeWidth(15);
            root.getChildren().add(path4);
        }
        return root;
    }
}