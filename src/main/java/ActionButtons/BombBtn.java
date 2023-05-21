package ActionButtons;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class BombBtn extends JButton {
    public BombBtn() {
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/bomb.png")));

        AtomicInteger count = new AtomicInteger();

        this.setIcon(imageIcon);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setVisible(true);

        AtomicReference<Random> random = new AtomicReference<>(new Random());

        int maxWidth = 601; // Górny zakres szerokości (maxWidth - 1)
        int maxHeight = 501; // Górny zakres wysokości (maxHeight - 1)

        int x = random.get().nextInt(maxWidth); // Losowa liczba od 0 do maxWidth - 1
        int y = random.get().nextInt(maxHeight); // Losowa liczba od 0 do maxHeight - 1

        this.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        this.addActionListener(e -> {
            count.getAndIncrement();
            this.setVisible(false);


            System.out.println(count.get());

            random.set(new Random());
            int newX = random.get().nextInt(maxWidth); // Wygenerowanie nowej losowej liczby dla x
            int newY = random.get().nextInt(maxHeight); // Wygenerowanie nowej losowej liczby dla y

            this.setBounds(newX, newY, imageIcon.getIconWidth(), imageIcon.getIconHeight());


            Timer timer = new Timer(3000, event -> {
                this.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        });
    }
}
