package label;

import javax.swing.*;

public class Game extends JLabel {
    public Game(){
        this.setSize(600,500);
        this.setText("Game");

        JButton btn = new JButton();
        ImageIcon imageIcon = new ImageIcon("label/bomb.png");
        JButton button = new JButton();
        button.setIcon(imageIcon);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setVisible(true);

        this.add(btn);
    }
}
