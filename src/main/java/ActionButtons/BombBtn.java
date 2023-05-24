package ActionButtons;

import label.Game;
import label.MenuSwitch;
import panel.BottomPanel;

import javax.swing.*;
import java.util.Objects;

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

        XYRandom random = new XYRandom();
        random.setBoundOf_Btn(this,imageIcon);


        this.addActionListener(e -> {
            hearts--;
            this.setVisible(false);
            System.out.println("Hearts:" + hearts);

            BottomPanel bottomPanel = MenuSwitch.bottomPanel;

            JPanel rightPanel = bottomPanel.getRightPanel();
            rightPanel.remove(hearts);
            random.setBoundOf_Btn(this,imageIcon);

            Timer timer = new Timer(3000, event -> {
                this.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
            Game.messageAfterLose();
        });
    }
}

