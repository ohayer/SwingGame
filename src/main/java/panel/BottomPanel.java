package panel;

import ActionButtons.FrogBtn;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BottomPanel extends JPanel {
    public JButton btn;
    private final FrogBtn frog;
    List<JLabel> hearts;
    public BottomPanel(){
        Color color = new Color(162, 176, 166);
        this.setBackground(color);
        this.setPreferredSize(new Dimension());


        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/left-arrow.png")));

        btn = new JButton();
        btn.setIcon(imageIcon);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setVisible(true);

        ImageIcon heart = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/heart.png")));

        hearts = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            JLabel heartLabel = new JLabel(heart);
            hearts.add(heartLabel);
        }

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(btn);
        leftPanel.setBackground(color);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(color);
        for (JLabel heartLabel : hearts) {
            rightPanel.add(heartLabel);
        }

        frog= new FrogBtn();
        int points = frog.getPoints();

        JLabel pointsLabel = new JLabel();
        pointsLabel.setText(String.valueOf(points));
        pointsLabel.setFont(new Font("Arial", Font.BOLD,80));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(pointsLabel);
        centerPanel.setBackground(color);

        this.setLayout(new BorderLayout());
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);



    }
}
