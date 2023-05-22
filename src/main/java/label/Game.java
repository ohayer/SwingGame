package label;

import ActionButtons.BombBtn;
import ActionButtons.FrogBtn;

import javax.swing.*;

public class Game extends JLabel {
    public static FrogBtn frog = new FrogBtn();
    public static BombBtn bomb = new BombBtn();

    public Game() {
        this.setSize(600, 500);
        setLayout(null);

        this.add(bomb);
        this.add(frog);

    }
}
