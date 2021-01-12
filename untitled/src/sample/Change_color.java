package sample;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Change_color implements Serializable{
    private int radius;
    private String[] Colors=new String[4];
    private int xcord;
    private int ycord;
    private boolean stt;
    public Change_color(Obstacle ob) {
        radius =5;
        xcord=17;
        ycord=220;
        if (ob instanceof circle) {
            Colors[0] = ob.getColor().get(0);
            Colors[1] = ob.getColor().get(1);
            Colors[2] = ob.getColor().get(2);
            Colors[3] = ob.getColor().get(3);
        }
        else if(ob instanceof triangle){
            Colors[0] = ob.getColor().get(0);
            Colors[1] = ob.getColor().get(1);
            Colors[2] = ob.getColor().get(2);
        }
        else if(ob instanceof Line)
        {
            Colors[0] = ob.getColor().get(0);
            Colors[1] = ob.getColor().get(1);
        }
        else if(ob instanceof Rectangle)
        {
            Colors[0] =ob.getColor().get(0);
            Colors[1] = ob.getColor().get(1);
            Colors[2] = ob.getColor().get(2);
            Colors[3] = ob.getColor().get(3);
        }
        stt=true;
    }

    public int getRadius() {
        return radius;
    }

    public String[] getColors() {
        return Colors;
    }

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }
    public boolean isStt(){return  stt;}
    public void setStt(boolean a){stt=a;}

}