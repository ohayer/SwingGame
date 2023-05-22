package ActionButtons;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class BombBtn extends JButton {
    private int hearts;

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public BombBtn() {
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/bomb.png")));

        this.setIcon(imageIcon);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setVisible(true);

        AtomicReference<Random> random = new AtomicReference<>(new Random());

        int maxWidth = 501; // Górny zakres szerokości (maxWidth - 1)
        int maxHeight = 401; // Górny zakres wysokości (maxHeight - 1)

        int x = random.get().nextInt(maxWidth); // Losowa liczba od 0 do maxWidth - 1
        int y = random.get().nextInt(maxHeight); // Losowa liczba od 0 do maxHeight - 1

        this.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        hearts=3;
        this.addActionListener(e -> {
            hearts--;
            this.setVisible(false);


            System.out.println(hearts);

            random.set(new Random());
            int newX = random.get().nextInt(maxWidth); // Wygenerowanie nowej losowej liczby dla x
            int newY = random.get().nextInt(maxHeight); // Wygenerowanie nowej losowej liczby dla y

            this.setBounds(newX, newY, imageIcon.getIconWidth(), imageIcon.getIconHeight());


            Timer timer = new Timer(3000, event -> {
                this.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
            if (hearts==0){
//                Game game = new Game();
//                game.setVisible(false);
//                MenuSwitch menuSwitch = new MenuSwitch();
//                menuSwitch.setVisible(false);
                JOptionPane.showMessageDialog(null, "Przegrałeś", "Noob", JOptionPane.INFORMATION_MESSAGE);


            }
        });

    }
}
