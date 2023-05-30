package label;

import Frame.MenuStart;
import entity.User;
import repository.UserRepository;

import javax.swing.*;
import java.awt.*;

public class TypeUsername extends JLabel {
    public static UserRepository userRepo = new UserRepository();
    private final JButton button = new JButton("▶");
    private MenuStart menuStart = new MenuStart();
    public static User user;
    private final JTextField textField = new JTextField();

    public TypeUsername() {

        this.setText("Type your username: ");
        this.setSize(600, 200);
        this.setFont(new Font("Arial", Font.BOLD, 35));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.TOP);
        this.setVisible(true);

        textField.setBounds(100, 80, 150, 30);
        textField.setBackground(new Color(179, 186, 189));
        textField.setForeground(Color.black);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setBorder(null);

        button.setForeground(Color.BLACK);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(new Color(179, 186, 189));
        button.setBounds(340, 80, 90, 30);

        button.addActionListener(e -> {
            String enteredText = textField.getText();
            user = userRepo.findUserByName(enteredText);
            if (user == null) {
                userRepo.createNewUser(enteredText, 0);
                user = userRepo.findUserByName(enteredText);
            }
            if (enteredText.equals("")) {
                JOptionPane.showMessageDialog(null, "Username cannot be empty.");
            } else {
                menuStart.setSize(600, 600);
                menuStart.setLocationRelativeTo(null);
                menuStart.getContentPane().removeAll();
                menuStart.getContentPane().invalidate();
                menuStart.getContentPane().repaint();
                new MenuSwitch(menuStart);
            }
        });


        this.add(textField);
        this.add(button);
        menuStart.add(this);
    }

}
