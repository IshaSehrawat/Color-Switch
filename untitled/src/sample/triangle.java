package sample;

import java.io.Serializable;

public class triangle extends  Obstacle implements Serializable {
    private int inner_radius;
    private int outer_radius;
    private int number;

    public int getInner_radius() {
        return inner_radius;
    }

    public int getOuter_radius() {
        return outer_radius;
    }

    public int getNumber() {
        return number;
    }

    public triangle() {
        setInner_radius(50);
        setXcord(590);
        setYcord(220);
        setOuter_radius(60);
    }

    public void setInner_radius(int inner_radius) {
        this.inner_radius = inner_radius;
    }

    public void setOuter_radius(int outer_radius) {
        this.outer_radius = outer_radius;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public triangle(int a) {
        super(0);
        setInner_radius(50);
        setXcord(590);
        setYcord(220);
        setOuter_radius(60);
    }

    @Override
    public triangle Clon() {
        Obstacle oo=super.Clon();
        triangle t=new triangle();
        t.xcord=oo.getXcord();
        t.ycord=oo.getYcord();
        t.reward=oo.getReward();
        t.change=oo.getChange();
        t.inner_radius=this.inner_radius;
        t.outer_radius=this.outer_radius;
        t.number=this.number;
        return t;
    }
}