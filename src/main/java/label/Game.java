package label;

import ActionButtons.BombBtn;
import ActionButtons.FrogBtn;
import ActionButtons.XYRandom;
import entity.User;
import panel.BottomPanel;
import repository.UserRepository;

import javax.swing.*;

public class Game extends JLabel {
    public static FrogBtn frog = new FrogBtn();
    public static BombBtn bomb = new BombBtn();
    private final Timer bombTimer;
    public static Timer frogTimer, timer;


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
            if (frog.getPoints() % 25 == 0 && frog.getPoints() > 0) {
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
            messageAfterLose();
        });
        frogTimer.setRepeats(true);
    }

    public static void messageAfterLose() {
        if (frog.getHearts() == 0) {
            int result = JOptionPane.showOptionDialog(null, "Don't worry. Let's try again", "Defeated by Frog",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"TRY AGAIN"}, "OK");
            frogTimer.stop();
            if (result == JOptionPane.OK_OPTION) {
                setBiggestValuePoints();
                MenuSwitch.bottomPanel.btn.doClick();
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

    public static void setBiggestValuePoints() {
        User user = TypeUsername.user;
        if (frog.getPoints() > user.getMaxPoints()) {
            UserRepository repository = TypeUsername.userRepo;
            repository.updatePoints(user, frog.getPoints());
            MenuSwitch.additionalText.setText("<html><div style='text-align: center;'>Hello " + user.getUsername() + "<br>Your max points is " + user.getMaxPoints() + "</div></html>");
        }
    }
}
