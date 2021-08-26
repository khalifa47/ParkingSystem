import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JLabel titleLabel, unameLabel, passLabel;
    private JTextField unameField;
    private JPasswordField passField;
    private JButton loginButton, registerButton;

    public Login(){
        setSize(900, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setFont(Font.getFont("Tahoma"));

        titleLabel = new JLabel("Login Page");
        titleLabel.setForeground(Color.getColor("CF2A27"));
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN,40));
        unameLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        unameField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        titleLabel.setBounds(287, 77, 197, 44);
        unameLabel.setBounds(199, 160, 64, 21);
        passLabel.setBounds(201, 218, 59, 21);
        unameField.setBounds(287, 160, 225, 27);
        passField.setBounds(287, 218, 225, 27);
        loginButton.setBounds(287, 255, 56, 27);
        registerButton.setBounds(435, 255, 75, 27);

        add(titleLabel); add(unameLabel); add(passLabel); add(unameField); add(passField); add(loginButton); add(registerButton);

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
