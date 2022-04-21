package Game;

import javax.swing.*;

public class Menu extends JPanel {

    public static final int BUTTON_WIDTH = 150;
    public static final int BUTTON_HEIGHT = 150;

    private JButton startGame;

    public Menu(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.startGame = addButton("Start game",
                (Window.WINDOW_WIDTH / 2) - (BUTTON_WIDTH / 2),
                (Window.WINDOW_HEIGHT / 2) - (BUTTON_HEIGHT / 2),
                BUTTON_WIDTH,
                BUTTON_HEIGHT);
        newGame();
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    private JButton addButton(String buttonName, int x, int y, int width, int height) {
        JButton addButton = new JButton(buttonName);
        this.setVisible(true);
        this.add(addButton);
        addButton.setBounds(x, y, width, height);
        return addButton;
    }

    private void newGame() {
        this.startGame.addActionListener((event) -> {
            this.startGame.setVisible(false);
            GameScene gameScene = new GameScene(0,0,Window.WINDOW_WIDTH,Window.WINDOW_HEIGHT);
            this.add(gameScene);
        });
    }
}
