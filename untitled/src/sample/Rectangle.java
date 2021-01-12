package sample;

public class Rectangle extends Obstacle{
    private int inner_x1;
    private int inner_x2;
    private int inner_y1;
    private int inner_y2;
    private int number;
    public Rectangle()
    {
        setInner_x1(100);
        setInner_x2(120);
        setInner_y1(100);
        setInner_y2(100);
        setYcord(220);
        setXcord(590);
    }

    public void setInner_x1(int inner_x1) {
        this.inner_x1 = inner_x1;
    }

    public void setInner_x2(int inner_x2) {
        this.inner_x2 = inner_x2;
    }

    public void setInner_y1(int inner_y1) {
        this.inner_y1 = inner_y1;
    }

    public void setInner_y2(int inner_y2) {
        this.inner_y2 = inner_y2;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Rectangle(int a)
    {
        super(0);
        setInner_x1(100);
        setInner_x2(120);
        setInner_y1(100);
        setInner_y2(100);
        setYcord(220);
        setXcord(590);
    }

    public int getInner_x1(){return inner_x1;}
    public int getInner_x2(){return inner_x2;}
    public int getInner_y1(){return inner_y1;}
    public int getInner_y2(){return inner_y2;}
    public int getNumber(){return number;}

    @Override
    public Rectangle Clon() {
        Obstacle oo=super.Clon();
        Rectangle t=new Rectangle();
        t.xcord=oo.getXcord();
        t.ycord=oo.getYcord();
        t.reward=oo.getReward();
        t.change=oo.getChange();
        t.inner_x1=this.inner_x1;
        t.inner_x2=this.inner_x2;
        t.inner_y1=this.inner_y1;
        t.inner_y2=this.inner_y2;
        t.number=this.number;
        return t;
    }
}
