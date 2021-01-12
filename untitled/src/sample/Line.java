package sample;

public class Line extends Obstacle{
    protected int thickness;
    protected int number;

    public Line() {
        setThickness(20);
        setNumber(10);
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Line(int a) {
        super(0);
        setThickness(20);
        setNumber(10);
    }

    public int get_thick() {
        return thickness;
    }

    public int getNumber() {
        return number;
    }
    @Override
    public Line Clon() {
        Obstacle oo=super.Clon();
        Line t=new Line();
        t.xcord=oo.getXcord();
        t.ycord=oo.getYcord();
        t.reward=oo.getReward();
        t.change=oo.getChange();
        t.thickness=this.thickness;
        t.number=this.number;
        return t;
    }
}