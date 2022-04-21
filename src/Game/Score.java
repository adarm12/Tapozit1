package Game;

import javax.swing.*;
import java.awt.*;

public class Score {

    private int points;

    public static final int WIN = 30;
    public static final int MIN_POINTS = 0;

    public Score(int x, int y, int width, int height) {
        this.points = MIN_POINTS;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int addPoint() {
        return this.points++;
    }

//    public void scoreBoard() {
//        JLabel score = new JLabel("Score: ");
//        Font myFont = new Font("Ariel", Font.ITALIC, 20);
//        score.setFont(myFont);
//        score.setBounds(1250, 25, 100, 100);
//        this.add(score);
//    }
//
//    public void point(){
//        JLabel points = new JLabel(String.valueOf(addPoint()));
//        Font myFont = new Font("Ariel", Font.ITALIC, 20);
//        points.setFont(myFont);
//        points.setBounds(1320, 25, 50, 100);
//        this.add(points);
//    }


}
