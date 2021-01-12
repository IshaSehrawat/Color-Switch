package sample;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Reward implements Serializable{
    private int radius;
    private int xcord;
    private int ycord;
    private boolean status;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setXcord(int xcord) {
        this.xcord = xcord;
    }

    public void setYcord(int ycord) {
        this.ycord = ycord;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public Reward() {
        setRadius(5);
        setXcord(17);
        setYcord(220);
        setStatus(true);
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
}