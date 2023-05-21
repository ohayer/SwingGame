package Frame;

import javax.swing.*;
import java.awt.*;

public class MenuStart extends JFrame {
    public MenuStart() {
        this.setSize(600, 600);
        this.setTitle("Catch the Frog");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/appimg.png")));
        this.getContentPane().setBackground(new Color(78, 84, 94));

        this.setVisible(true);
    }

}
