package sample;

import java.io.Serializable;

public class SaveData implements Serializable {
    private static final long serialVersionUID= 1L;
    private ball b;
    private Obstacle ob[];
    private int Score;
    public ball getBall(){
        return b;
    }
    public Obstacle[] getOb(){
        return ob;
    }
    public int getScore(){
        return Score;
    }
    public void setOb(Obstacle[] ob) {
        this.ob = ob;
    }

    public void setScore(int score) {
        Score = score;
    }

    public void setB(ball b) {
        this.b = b;
    }
}