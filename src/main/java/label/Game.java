package label;

import ActionButtons.BombBtn;
import ActionButtons.FrogBtn;
import panel.BottomPanel;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Game extends JLabel {
    public static FrogBtn frog = new FrogBtn();
    public static BombBtn bomb = new BombBtn();
    private Timer timer;

    public Game() {
        this.setSize(600, 500);
        setLayout(null);

        this.add(bomb);
        this.add(frog);

        AtomicReference<Random> random = new AtomicReference<>(new Random());

        timer = new Timer(1000, event -> {
            System.out.println("znikam");

            int maxWidth = 521;
            int maxHeight = 411;
            int newX = random.get().nextInt(maxWidth);
            int newY = random.get().nextInt(maxHeight);

            bomb.setBounds(newX, newY, bomb.imageIcon.getIconWidth(), bomb.imageIcon.getIconHeight());
            bomb.setVisible(true);
        });
        timer.setRepeats(true);

    }
    public static void messageAfterLose(){
        if (bomb.getHearts() == 0) {
            int result = JOptionPane.showOptionDialog(null, "Don't worry. Let's try again", "Defeated by Frog",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, "OK");
            bomb.setHearts(5);
            if (result == JOptionPane.OK_OPTION) {
                BottomPanel bottomPanel = MenuSwitch.bottomPanel;
                bottomPanel.btn.doClick();
            }
        }
    }
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            timer.start();
        } else {
            timer.stop();
        }
    }
}
