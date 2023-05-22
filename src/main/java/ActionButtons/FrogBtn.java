package ActionButtons;

import label.MenuSwitch;
import panel.BottomPanel;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class FrogBtn extends JButton {
    private int points;

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public FrogBtn() {
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/frog.png")));

        this.setIcon(imageIcon);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setVisible(true);

        AtomicReference<Random> random = new AtomicReference<>(new Random());

        int maxWidth = 521;
        int maxHeight = 411;

        int x = random.get().nextInt(maxWidth);
        int y = random.get().nextInt(maxHeight);

        this.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        this.addActionListener(e -> {
            points++;
            this.setVisible(false);

            BottomPanel bottomPanel = MenuSwitch.bottomPanel;
            bottomPanel.getPointsLabel().setText(String.valueOf(points));

            System.out.println("Points:" + points);
            random.set(new Random());
            int newX = random.get().nextInt(maxWidth);
            int newY = random.get().nextInt(maxHeight);

            this.setBounds(newX, newY, imageIcon.getIconWidth(), imageIcon.getIconHeight());

            Timer timer = new Timer(2500, event -> {
                this.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();

        });

    }
}
