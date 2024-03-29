import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    private JLabel titleLabel, unameLabel, passLabel;
    private static JTextField unameField;
    private JPasswordField passField;
    private JButton loginButton, registerButton;

    public static String uname;

    Database db = new Database();

    public Login(){
        setSize(900, 600);
        setLocation(300, 90);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setFont(Font.getFont("Tahoma"));

        titleLabel = new JLabel("Login Page");
        titleLabel.setForeground(new java.awt.Color(255, 102, 0));
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN,40));
        unameLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        unameField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        titleLabel.setBounds(287, 77, 197, 50);
        unameLabel.setBounds(199, 160, 75, 21);
        passLabel.setBounds(201, 218, 75, 21);
        unameField.setBounds(287, 160, 225, 27);
        passField.setBounds(287, 218, 225, 27);
        loginButton.setBounds(287, 255, 75, 27);
        registerButton.setBounds(420, 255, 90, 27);

        add(titleLabel); add(unameLabel); add(passLabel); add(unameField); add(passField); add(loginButton); add(registerButton);

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            if (unameField.getText().trim().isEmpty() || String.valueOf(passField.getPassword()).trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Warning: Required fields are empty");
            } else {
                String SQL = "SELECT uname, pass FROM users WHERE uname = '" + unameField.getText() + "' AND pass = MD5('" + String.valueOf(passField.getPassword()) + "')";
                ResultSet resultSet = db.getData(SQL, this);
                try {
                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(this, "Login Successful!");
                        uname = unameField.getText();
                        Dashboard d = new Dashboard();
                        d.setVisible(true);
                        this.setVisible(false);
                    }
                    else{

                        JOptionPane.showMessageDialog(this, "Invalid login credentials!");
                        unameField.setText("");
                        passField.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        else if(e.getSource() == registerButton){
            Register register = new Register();
            register.setVisible(true);
            this.setVisible(false);
        }
    }
}
