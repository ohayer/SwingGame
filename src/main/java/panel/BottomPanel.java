package panel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BottomPanel extends JPanel {
    public JButton btn;
    private static final Color color = new Color(162, 176, 166);
    private final JLabel pointsLabel;
    private final JPanel rightPanel = new JPanel();
    public ImageIcon heart = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/heart.png")));

    public BottomPanel() {
        this.setBackground(color);
        this.setPreferredSize(new Dimension());

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/left-arrow.png")));

        btn = new JButton();
        btn.setIcon(imageIcon);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setVisible(true);

        this.setHeatsToFive(this, rightPanel);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(btn);
        leftPanel.setBackground(color);


        pointsLabel = new JLabel();
        pointsLabel.setText("0");
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 80));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(pointsLabel);
        centerPanel.setBackground(color);

        this.setLayout(new BorderLayout());
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);

    }

    public JLabel getPointsLabel() {
        return pointsLabel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public void setHeatsToFive(BottomPanel bottomPanel, JPanel rightPanels) {
        rightPanels.removeAll();
        for (int i = 0; i < 5; i++) {
            JLabel heartLabel = new JLabel(heart);
            rightPanels = bottomPanel.getRightPanel();
            rightPanels.add(heartLabel);
        }
        rightPanels.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightPanels.setBackground(color);
    }

}
