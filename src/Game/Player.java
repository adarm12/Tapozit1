package Game;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Player {

    private Rectangle neck;
    private Rectangle body;
    private Rectangle rightHand;
    private Rectangle leftHand;
    private Rectangle rightLeg;
    private Rectangle leftLeg;

    public static final int MARGIN_BOTTOM = 130;
    public static final int MARGIN_LEG = 20;
    public static final int WEIGHT_LEG = 15;
    public static final int HEIGHT_LEG = 70;
    public static final int WEIGHT_BODY = (2 * WEIGHT_LEG) + MARGIN_LEG;
    public static final int HEIGHT_BODY = 100;


    public Player() {
        this.leftLeg = new Rectangle(Main.WINDOW_GAME_SCENE_WEIGHT / 2 - MARGIN_LEG, Main.WINDOW_HEIGHT - MARGIN_BOTTOM,
                WEIGHT_LEG, HEIGHT_LEG, new Color(255,204,153));

        this.rightLeg = new Rectangle(Main.WINDOW_GAME_SCENE_WEIGHT/ 2 + MARGIN_LEG,Main.WINDOW_HEIGHT - MARGIN_BOTTOM,
                        WEIGHT_LEG, HEIGHT_LEG, new Color(255,204,153));

        this.body = new Rectangle(this.leftLeg.getX() ,this.leftLeg.getY()
                , WEIGHT_BODY,HEIGHT_BODY, Color.black);

//        this.neck = new Rectangle();
//
//                this.rightHand =
//                        this.leftHand =


    }

    public void moveRight()
    {
        this.leftLeg.moveRight();
        this.rightLeg.moveRight();
        this.body.moveRight();
    }
    public void moveLeft()
    {
        this.leftLeg.moveLeft();
        this.rightLeg.moveLeft();
        this.body.moveLeft();
    }
    public void paint (Graphics graphics)
    {
        this.leftLeg.paint(graphics);
        this.rightLeg.paint(graphics);
        this.body.paint(graphics);
    }


}
