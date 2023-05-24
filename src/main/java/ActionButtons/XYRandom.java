package ActionButtons;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class XYRandom {
    public int x;
    public int y;
    public AtomicReference<Random> random = new AtomicReference<>(new Random());
    public int maxWidth = 521;
    public int maxHeight = 411;

    public void setBoundOf_Btn(JButton jButton, ImageIcon imageIcon) {
        random.set(new Random());
        x = random.get().nextInt(maxWidth);
        y = random.get().nextInt(maxHeight);
        jButton.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
    }
}
