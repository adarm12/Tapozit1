package Game;

import javax.swing.*;
import java.awt.*;

public class Player {

    public static final int MARGIN_BOTTOM = 100;
    public static final int MARGIN_LEG = 15;
    public static final int WEIGHT_LEG = 15;
    public static final int HEIGHT_LEG = 40;
    public static final int HEIGHT_BODY = 80;
    public static final int HEIGHT_BELT = 15;
    public static final int NECK_DISTANCE = 10;
    public static final int NECK_HEIGHT = 15;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int PLAYER_SPEED = 1;
    public static final int WEIGHT_HAND = 15;
    public static final int HEIGHT_HAND = 40;


    private Rectangle neck;
    private Rectangle body;
    private Rectangle belt;
    private Rectangle rightHand;
    private Rectangle leftHand;
    private Rectangle rightLeg;
    private Rectangle leftLeg;
    private int direction; // מצביע על הכיוון של השחקן
    private ImageIcon face;


    public Player() {

        this.leftLeg = new Rectangle(Main.WINDOW_GAME_SCENE_WEIGHT / 2,
                Main.WINDOW_HEIGHT - MARGIN_BOTTOM,
                WEIGHT_LEG, HEIGHT_LEG,
                new Color(255, 204, 153, 211));

        this.rightLeg = new Rectangle(Main.WINDOW_GAME_SCENE_WEIGHT / 2 + this.leftLeg.getWidth() + MARGIN_LEG,
                Main.WINDOW_HEIGHT - MARGIN_BOTTOM,
                WEIGHT_LEG, HEIGHT_LEG,
                new Color(255, 204, 153, 211));

        this.body = new Rectangle(this.leftLeg.getX(),
                this.rightLeg.getY() - HEIGHT_BODY,
                (2 * WEIGHT_LEG) + MARGIN_LEG,
                HEIGHT_BODY,
                new Color(255, 0, 127));

        this.belt = new Rectangle(this.leftLeg.getX(),
                this.body.getY() + (this.body.getHeight() / 2) - HEIGHT_BELT / 2,
                this.body.getWidth(), HEIGHT_BELT, Color.PINK);

        this.neck = new Rectangle(this.body.getX() + (this.body.getWidth() / 2) - NECK_DISTANCE,
                this.body.getY() - NECK_HEIGHT,
                NECK_DISTANCE * 2,
                NECK_HEIGHT, new Color(255, 204, 153, 211));

        this.face = new ImageIcon("face.jpg");

        this.rightHand = new Rectangle(this.body.getX() + this.body.getWidth(),
                this.rightLeg.getY() - HEIGHT_BODY,
                WEIGHT_HAND,
                HEIGHT_HAND,
                new Color(255, 204, 153, 211));

        this.leftHand = new Rectangle(this.body.getX() - HEIGHT_HAND,
                this.rightLeg.getY() - HEIGHT_BODY,
                HEIGHT_HAND,
                WEIGHT_HAND,
                new Color(255, 204, 153, 211));
    }


    public void moveRight() {
        this.leftLeg.moveRight();
        this.rightLeg.moveRight();
        this.body.moveRight();
        this.belt.moveRight();
        this.neck.moveRight();
        this.rightHand.moveRight();
        this.leftHand.moveRight();

    }

    public void moveLeft() {
        this.leftLeg.moveLeft();
        this.rightLeg.moveLeft();
        this.body.moveLeft();
        this.belt.moveLeft();
        this.neck.moveLeft();
        this.rightHand.moveLeft();
        this.leftHand.moveLeft();

    }

    public void paintComponent(Graphics graphics) {
        this.leftLeg.paint(graphics);
        this.rightLeg.paint(graphics);
        this.body.paint(graphics);
        this.neck.paint(graphics);
        this.rightHand.paint(graphics);
        this.leftHand.paint(graphics);
        this.belt.paint(graphics);
       // this.face.paintIcon( GameScene,graphics, this.neck.getX(), this.neck.getY());

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}