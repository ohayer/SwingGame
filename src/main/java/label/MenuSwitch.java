package label;

import Frame.MenuStart;
import panel.BottomPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuSwitch extends JLabel {
    private  final BottomPanel bottomPanel = new BottomPanel();
    public MenuSwitch(){
        MenuStart menuStart = new MenuStart();
        Game game = new Game();

        this.setText("THE BEST FROG GAME");
        this.setSize(menuStart.getSize());
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.TOP);
        this.setFont(new Font("Arial", Font.BOLD,50));


        JButton start = new JButton();
        start.setText("Start");
        start.setBounds(240,250,120,60);
        start.setForeground(Color.BLACK);
        start.setBackground(new Color(94, 122, 61));
        start.addActionListener(e -> {

            bottomPanel.setPreferredSize(new Dimension(600,100));
            menuStart.setLayout(new BorderLayout());

            this.setVisible(false);
            menuStart.add(game,BorderLayout.CENTER);
            menuStart.add(bottomPanel,BorderLayout.SOUTH);

            bottomPanel.setVisible(true);
            game.setVisible(true);
        });

        bottomPanel.btn.addActionListener(e -> {
                this.setVisible(true);
                game.setVisible(false);
                bottomPanel.setVisible(false);

        });

        JButton exit = new JButton();
        exit.setText("Exit");
        exit.setBounds(240,400,120,60);
        exit.setForeground(Color.BLACK);
        exit.setBackground(new Color(184, 28, 56));
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
