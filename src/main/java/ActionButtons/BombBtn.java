package ActionButtons;

import label.Game;
import label.MenuSwitch;
import panel.BottomPanel;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class BombBtn extends JButton {
    private int hearts = 5;

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/bomb.png")));
    public BombBtn() {

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
            hearts--;
            this.setVisible(false);
            System.out.println("Hearts:" + hearts);

            BottomPanel bottomPanel = MenuSwitch.bottomPanel;

            JPanel rightPanel = bottomPanel.getRightPanel();
            rightPanel.remove(hearts);

            random.set(new Random());
            int newX = random.get().nextInt(maxWidth); // Wygenerowanie nowej losowej liczby dla x
            int newY = random.get().nextInt(maxHeight); // Wygenerowanie nowej losowej liczby dla y

            this.setBounds(newX, newY, imageIcon.getIconWidth(), imageIcon.getIconHeight());

            Timer timer = new Timer(3000, event -> {
                this.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
            Game.messageAfterLose();
        });
    }
}

