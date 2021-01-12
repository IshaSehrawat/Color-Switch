package sample;
import java.util.*;
import java.lang.*;
import java.io.*;
public class ball implements Serializable{
    private String color;
    private  String shape;
    private int radius;
    private int xcord;
    private int ycord;
    private  final int  speed = 15;
    private  final int  fallspeed = 6;
    public String getColor() {
        return color;
    }
    public String getShape() {
        return shape;
    }

    public int getRadius() {
        return radius;
    }

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFallspeed() { return fallspeed;}

    public ball() {
        Random r=new Random();
        int a=r.nextInt(4);
        switch(a)
        {
            case 0:color="red";
            break;
            case 1:color="blue";
            break;
            case 2:color="orange";
            break;
            case 3:color="green";
            break;
        }
        shape="circle";
        radius=8;
        xcord=590;
        ycord=590;
    }

    public ball(int aa) {
        color="white";
        shape="circle";
        radius=8;
        xcord=590;
        ycord=590;
    }

    public void set(int a){ycord=a;}
    public void setColor(String a){
        color=a;
    }
    public ball clon() {
        ball b=new ball();
        System.out.println(this.getYcord());
        b.set(this.getYcord());
        b.setColor(this.color);
        return b;
    }
}