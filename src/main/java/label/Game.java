package label;

import ActionButtons.BombBtn;

import javax.swing.*;

public class Game extends JLabel {
    private final BombBtn btn = new BombBtn();
    public Game(){
        this.setSize(600,500);
        setLayout(null);

        this.add(btn);

    }
}
