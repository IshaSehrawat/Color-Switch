package sample;

import java.io.Serializable;

public class circle extends Obstacle implements Serializable {
    private int inner_radius;
    private int outer_radius;
    private int number;

    public circle() {
        setInner_radius(110);
        setOuter_radius(120);
        setNumber(10);
//        inner_radius =110;
//        outer_radius = 120;
//        number =10;
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

    public circle(int a)
    {
        super(0);
        setInner_radius(110);
        setOuter_radius(120);
        setNumber(10);
    }
    public int getInner_radius() {
        return inner_radius;
    }

    public int getOuter_radius() {
        return outer_radius;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public circle Clon() {
        Obstacle oo=super.Clon();
        circle c=new circle();
        c.xcord=oo.getXcord();
        c.ycord=oo.getYcord();
        c.reward=oo.getReward();
        c.change=oo.getChange();
        c.inner_radius=this.inner_radius;
        c.outer_radius=this.outer_radius;
        c.number=this.number;
        return c;
    }
}