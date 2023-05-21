package label;

import javax.swing.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Game extends JLabel {
    public Game(){
        this.setSize(600,500);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/bomb.png")));

        JButton button = new JButton();

        AtomicInteger count = new AtomicInteger();

        button.setIcon(imageIcon);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setVisible(true);
        button.setBounds(400, 200, imageIcon.getIconWidth(),imageIcon.getIconHeight());

        button.addActionListener(e -> {
            count.getAndIncrement();
            button.setVisible(false);

            System.out.println(count.get());

            Timer timer = new Timer(3000, event -> {
                button.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        });
        this.add(button);

    }
}
