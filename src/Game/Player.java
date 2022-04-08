package Game;

import java.awt.*;

public class Player {

    private Rectangle neck;
    private Rectangle body;
    private Rectangle rightHand;
    private Rectangle leftHand;
    private Rectangle rightLeg;
    private Rectangle leftLeg;
    private int direction; // מצביע על הכיוון של השחקן


    public static final int MARGIN_BOTTOM = 130;
    public static final int MARGIN_LEG = 30;
    public static final int WEIGHT_LEG = 15;
    public static final int HEIGHT_LEG = 60;
    public static final int HEIGHT_BODY = 80;
    public static final int NECK_DISTANCE = 10;
    public static final int NECK_HEIGHT = 15;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int PLAYER_SPEED = 1;

    public Player() {

        this.leftLeg = new Rectangle(Main.WINDOW_GAME_SCENE_WEIGHT / 2, Main.WINDOW_HEIGHT - MARGIN_BOTTOM,
                WEIGHT_LEG, HEIGHT_LEG, new Color(255, 204, 153, 211)
        );

        this.rightLeg = new Rectangle(Main.WINDOW_GAME_SCENE_WEIGHT / 2 + this.leftLeg.getWidth() + MARGIN_LEG, Main.WINDOW_HEIGHT - MARGIN_BOTTOM,
                WEIGHT_LEG, HEIGHT_LEG, new Color(255, 204, 153, 211)
        );

        this.body = new Rectangle(this.leftLeg.getX(),
                this.rightLeg.getY() - HEIGHT_BODY,
                (2 * WEIGHT_LEG) + MARGIN_LEG,
                HEIGHT_BODY,
                Color.CYAN);

        this.neck = new Rectangle(this.body.getX() + (this.body.getWidth() / 2) - NECK_DISTANCE,
                this.body.getY() - NECK_HEIGHT,
                NECK_DISTANCE * 2,
                NECK_HEIGHT, new Color(255, 204, 153, 211)
        );

    }


    public void moveRight() {
        this.leftLeg.moveRight();
        this.rightLeg.moveRight();
        this.body.moveRight();
        this.neck.moveRight();
    }

    public void moveLeft() {
        this.leftLeg.moveLeft();
        this.rightLeg.moveLeft();
        this.body.moveLeft();
        this.neck.moveLeft();
    }

    public void paint(Graphics graphics) {
        this.leftLeg.paint(graphics);
        this.rightLeg.paint(graphics);
        this.body.paint(graphics);
        this.neck.paint(graphics);
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}