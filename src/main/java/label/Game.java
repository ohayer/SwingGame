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
    private final BottomPanel bottomPanel = MenuSwitch.bottomPanel;


    public Game() {
        this.setSize(600, 500);
        setLayout(null);

        this.add(bomb);
        this.add(frog);
        frog.addActionListener(a -> {
            frogTimer.stop();
            frogTimer.setDelay(frogTimer.getDelay()-1);
            frogTimer.start();
        });
        bomb.addActionListener(a ->{
           frog.setHearts(frog.getHearts()-1);
            JPanel rightPanel = bottomPanel.getRightPanel();
            rightPanel.remove(Game.frog.getHearts());
        });

        bombTimer = new Timer(2500, event -> {
            XYRandom random = new XYRandom();
            random.setBoundOf_Btn(bomb, bomb.imageIcon);
            messageAfterLose();
            if (frog.getPoints() % 25 == 0 && frog.getPoints() > 0) {
                System.out.println("bomb" + frog.getPoints() / 10);
                BombBtn newBomb = new BombBtn();
                Timer timer = new Timer(2500, e -> random.setBoundOf_Btn(newBomb, newBomb.imageIcon));
                newBomb.addActionListener(b -> {
                    frog.setHearts(frog.getHearts() - 1);
                    removeHeartFromPanel();
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
            frog.setHearts(frog.getHearts() - 1);
            removeHeartFromPanel();
            System.out.println(frogTimer.getDelay());
            messageAfterLose();
        });
        frogTimer.setRepeats(true);
    }

    public static void messageAfterLose() {
        if (frog.getHearts() == 0) {
            int result = JOptionPane.showOptionDialog(null, "Don't worry. Let's try again", "Defeated by Frog",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, "OK");
            frog.setHearts(5);
            if (result == JOptionPane.OK_OPTION) {
                BottomPanel bottomPanel = MenuSwitch.bottomPanel;
                bottomPanel.btn.doClick();
            }
        }
    }
    private void removeHeartFromPanel() {
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
        }catch (NullPointerException ignored) {
        }
    }
}
