package label;

import ActionButtons.BombBtn;
import ActionButtons.FrogBtn;
import ActionButtons.XYRandom;
import panel.BottomPanel;

import javax.swing.*;

public class Game extends JLabel {
    public static FrogBtn frog = new FrogBtn();
    public static BombBtn bomb = new BombBtn();
    private final Timer bombTimer;
    public Timer frogTimer, timer;


    public Game() {
        this.setSize(600, 500);
        setLayout(null);

        this.add(bomb);
        this.add(frog);
        frog.addActionListener(a -> {
            frogTimer.stop();
            frogTimer.setDelay(frogTimer.getDelay() - 1);
            frogTimer.start();
        });
        bomb.addActionListener(a -> {
            removeHeartFromPanel();
            messageAfterLose();
        });
        bombTimer = new Timer(2500, event -> {
            XYRandom random = new XYRandom();
            random.setBoundOf_Btn(bomb, bomb.imageIcon);
            messageAfterLose();
            if (frog.getPoints() % 25 == 0 && frog.getPoints() > 0) {
                System.out.println("bomb" + frog.getPoints() / 10);
                BombBtn newBomb = new BombBtn();
                timer = new Timer(2500, e -> random.setBoundOf_Btn(newBomb, newBomb.imageIcon));
                newBomb.addActionListener(b -> {
                    removeHeartFromPanel();
                    messageAfterLose();
                });
                timer.setRepeats(true);
                timer.start();
                add(newBomb);
            }
        });

        bombTimer.setRepeats(true);
        frogTimer = new Timer(2200, e -> {
            XYRandom random = new XYRandom();
            random.setBoundOf_Btn(frog, frog.imageIcon);
            removeHeartFromPanel();
            System.out.println(frogTimer.getDelay());
            messageAfterLose();
        });
        frogTimer.setRepeats(true);
    }

    public static void messageAfterLose() {
        if (frog.getHearts() == 0) {
            int result = JOptionPane.showOptionDialog(null, "Don't worry. Let's try again", "Defeated by Frog",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"TRY AGAIN"}, "OK");
            frog.setHearts(5);
            if (result == JOptionPane.OK_OPTION) {
                BottomPanel bottomPanel = MenuSwitch.bottomPanel;
                bottomPanel.btn.doClick();
            }
        }
    }

    private void removeHeartFromPanel() {
        frog.setHearts(frog.getHearts() - 1);
        BottomPanel bottomPanel = MenuSwitch.bottomPanel;
        JPanel rightPanel = bottomPanel.getRightPanel();
        rightPanel.remove(frog.getHearts());
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        try {
            if (visible) {
                bombTimer.start();
                frogTimer.start();
                timer.start();
            } else {
                bombTimer.stop();
                frogTimer.stop();
                timer.stop();
            }
        } catch (NullPointerException ignored) {
        }
    }
}
