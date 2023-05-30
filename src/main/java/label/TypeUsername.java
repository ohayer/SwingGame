package label;

import Frame.MenuStart;
import entity.User;
import repository.UserRepository;

import javax.swing.*;
import java.awt.*;

public class TypeUsername extends JLabel{
    private final UserRepository userRepo = new UserRepository();
    private JButton button = new JButton("Start");
    private MenuStart menuStart = new MenuStart();
    private User user;
    public TypeUsername(){

        this.setText("Type your username: ");
        this.setSize(600,200);
        this.setFont(new Font("Arial", Font.BOLD, 35));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.TOP);

        JTextField textField = new JTextField();
        textField.setBounds(100, 80, 150, 30);

        button.setBounds(410, 80, 100, 30);

        button.addActionListener(e -> {
            String enteredText = textField.getText();
            user = userRepo.findUserByName(enteredText);
            if (user == null){
                userRepo.createNewUser(enteredText,0);
            }if (enteredText.equals("")){
                JOptionPane.showMessageDialog(null,"Username cannot be empty.");
            } else {
                menuStart.setSize(600,600);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
