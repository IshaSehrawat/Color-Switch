package sample;
import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class Obstacle implements Serializable {

    protected ArrayList<String> Color=new ArrayList<>();
    protected float xcord;
    protected float ycord;
    protected Reward reward;
    protected Change_color change;

    public Obstacle() {
        setXcord(590);
        setYcord(220);
        Color.add("red");
        Color.add("blue");
        Color.add("green");
        Color.add("orange");
        setReward(new Reward());
        change=new Change_color(this);
    }

    public void setColor(ArrayList<String> color) {
        Color = color;
    }

    public void setXcord(float xcord) {
        this.xcord = xcord;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public void setChange(Change_color change) {
        this.change = change;
    }

    public Obstacle(int a)
    {
        setXcord(590);
        setYcord(220);
        Color.add("white");
        Color.add("black");
        Color.add("white");
        Color.add("black");
        reward=new Reward();
        change=new Change_color(this);
    }

    public ArrayList<String> getColor() {
        return Color;
    }

    public float getXcord() {
        return xcord;
    }

    public float getYcord() {
        return ycord;
    }
    public void setYcord(float ycord) {
        this.ycord = ycord;
    }

    public Reward getReward() {
        return reward;
    }

    public Change_color getChange() {
        return change;
    }
    public Obstacle Clon()
    {
        Obstacle ob=new Obstacle();
        ob.xcord=this.xcord;
        ob.ycord=this.ycord;
        ob.reward=this.reward;
        ob.change=this.change;
        return ob;
    }
}