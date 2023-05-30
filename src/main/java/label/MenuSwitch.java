package label;

import ActionButtons.BombBtn;
import ActionButtons.FrogBtn;
import Frame.MenuStart;
import entity.User;
import panel.BottomPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class MenuSwitch extends JLabel {
    public static BottomPanel bottomPanel = new BottomPanel();
    public static JButton start = new JButton();
    public static Game game;
    public static JLabel additionalText = new JLabel();


    public MenuSwitch(MenuStart menuStart) {
        this.setText("THE BEST FROG GAME");
        this.setSize(600, 600);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.TOP);
        this.setFont(new Font("Arial", Font.BOLD, 50));
        this.setForeground(Color.white);


        User user = TypeUsername.user;
        additionalText.setText("<html><div style='text-align: center;'>Hello " + user.getUsername() + "<br>Your max points is " + user.getMaxPoints() + "</div></html>");
        additionalText.setHorizontalAlignment(SwingConstants.CENTER);
        additionalText.setSize(600, 350);
        additionalText.setVerticalAlignment(JLabel.CENTER);
        additionalText.setFont(new Font("Arial", Font.PLAIN, 40));
        additionalText.setForeground(Color.white);
        additionalText.setVisible(true);
        additionalText.setForeground(new Color(28, 189, 149));
        this.add(additionalText);

        ImageIcon startIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/start.png")));
        start.setIcon(startIcon);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setFocusPainted(false);
        start.setVisible(true);
        start.setBounds(236, 230, startIcon.getIconWidth(), startIcon.getIconHeight());
        start.addActionListener(e -> {
            bottomPanel.setPreferredSize(new Dimension(600, 100));
            menuStart.setLayout(new BorderLayout());
            this.setVisible(false);
            Game.frog = new FrogBtn();
            Game.bomb = new BombBtn();
            game = new Game();
            Game.frog.setPoints(0);
            menuStart.add(game, BorderLayout.CENTER);
            menuStart.add(bottomPanel, BorderLayout.SOUTH);

            bottomPanel.setVisible(true);
            game.setVisible(true);

        });

        bottomPanel.btn.addActionListener(e -> {
            this.setVisible(true);
            game.setVisible(false);
            bottomPanel.setVisible(false);

            FrogBtn frog = Game.frog;
            frog.setHearts(5);
            Game.setBiggestValuePoints();
            frog.setPoints(0);
            bottomPanel.setHeatsToFive(bottomPanel, bottomPanel.getRightPanel());
        });
        this.setVisible(true);

        ImageIcon exitIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/exit.png")));
        JButton exit = new JButton();
        exit.setIcon(exitIcon);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.setVisible(true);
        exit.setBounds(236, 360, exitIcon.getIconWidth(), exitIcon.getIconHeight());
        exit.addActionListener(e -> {
            System.exit(0);
        });

        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        start.setBorder(compound);
        exit.setBorder(compound);

        this.add(start);
        this.add(exit);
        menuStart.add(this);
    }
}
