package Game;

import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private Player tapozitPlayer;

    public GameScene(int x, int y, int weight, int height) {
        this.setBounds(x, y, weight, height);
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setBackground(Color.LIGHT_GRAY);

        this.tapozitPlayer = new Player();

//        Thread move = new Thread(() ->{
//            while (true)
//            {
//                try {
//                    this.tapozitPlayer.moveRight();
//                    Thread.sleep();
//                }catch ();
//            }
//        }
//
   }



    public void paintComponent (Graphics graphics)
    {
        super.paintComponent(graphics);
        this.tapozitPlayer.paint(graphics);
    }
}
