package Frame;

import javax.swing.*;
import java.awt.*;

public class MenuStart extends JFrame {
    public MenuStart() {
        this.setVisible(true);
        this.setSize(600, 600);
        this.setTitle("Game");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("Frame/appimg.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(78, 84, 94));
    }

}
