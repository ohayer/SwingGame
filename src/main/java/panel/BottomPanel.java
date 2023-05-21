package panel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BottomPanel extends JPanel {
    public JButton btn;
    public BottomPanel(){
        this.setBackground(new Color(162, 176, 166));
        this.setPreferredSize(new Dimension());

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/left-arrow.png")));

        btn = new JButton();
        btn.setIcon(imageIcon);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setVisible(true);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.add(btn);
    }
}
