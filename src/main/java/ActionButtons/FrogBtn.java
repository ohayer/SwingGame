package ActionButtons;

import label.MenuSwitch;
import panel.BottomPanel;

import javax.swing.*;
import java.util.Objects;

public class FrogBtn extends JButton {
    private int hearts = 5;
    private int points;
    public ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/frog.png")));

    public FrogBtn() {
        BottomPanel bottomPanel = MenuSwitch.bottomPanel;

        this.setIcon(imageIcon);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setVisible(true);

        XYRandom random = new XYRandom();
        random.setBoundOf_Btn(this, imageIcon);

        this.addActionListener(e -> {
            points++;
            bottomPanel.getPointsLabel().setText(String.valueOf(points));

            System.out.println("Points:" + points);

            random.setBoundOf_Btn(this, imageIcon);
        });
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

}
