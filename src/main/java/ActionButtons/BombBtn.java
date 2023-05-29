package ActionButtons;

import label.Game;

import javax.swing.*;
import java.util.Objects;

public class BombBtn extends JButton {
    public ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/bomb.png")));
    public BombBtn() {

        this.setIcon(imageIcon);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setVisible(true);

        XYRandom random = new XYRandom();
        random.setBoundOf_Btn(this,imageIcon);


        this.addActionListener(e -> {
            System.out.println("Hearts:" + Game.frog.getHearts());
            random.setBoundOf_Btn(this,imageIcon);
        });
    }
}

