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
    private Timer frogTimer;


    public Game() {
        this.setSize(600, 500);
        setLayout(null);

        this.add(bomb);
        this.add(frog);

        frog.addActionListener(e -> {
            frogTimer.stop();
            frogTimer.setDelay(2200);
            frogTimer.stop();
        });


        bombTimer = new Timer(2500, event -> {
            System.out.println("znikam");
            XYRandom random = new XYRandom();
            random.setBoundOf_Btn(bomb, bomb.imageIcon);
            bomb.setVisible(true);
        });
        bombTimer.setRepeats(true);
        frogTimer = new Timer(2200, e -> {
            XYRandom random = new XYRandom();
            random.setBoundOf_Btn(frog, frog.imageIcon);
            bomb.setHearts(bomb.getHearts() - 1);

            BottomPanel bottomPanel = MenuSwitch.bottomPanel;
            JPanel rightPanel = bottomPanel.getRightPanel();
            rightPanel.remove(bomb.getHearts());
            rightPanel.revalidate();
            rightPanel.repaint();
            System.out.println(rightPanel.getComponentCount());
            messageAfterLose();
        });
        frogTimer.setRepeats(true);

    }

    public static void messageAfterLose() {
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
            bombTimer.start();
            frogTimer.start();
        } else {
            bombTimer.stop();
            frogTimer.stop();
        }
    }
}
