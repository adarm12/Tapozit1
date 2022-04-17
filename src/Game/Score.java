package Game;

import java.awt.*;

public class Score {

    private int points;

    public static final int WIN = 30;

    public Score(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoint(Point points){
        this.points ++ ;
    }
}
