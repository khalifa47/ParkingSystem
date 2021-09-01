import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {
    private JLabel titleLabel, fnameLabel, lnameLabel, emailLabel, createPassLabel, confirmPassLabel, unameLabel, phoneLabel, dobLabel;
    private JTextField fnameField, lnameField, emailField, unameField, phoneField, dobField;
    private JPasswordField createPassField, confirmPassField;
    private JButton registerButton, backButton;

    GlobalFunctions gf = new GlobalFunctions();
    Database db = new Database();

    Register(){
        setVisible(true);
        setSize(900, 600);
        setLocation(300, 90);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Register Page");

        titleLabel = new JLabel("Login Page");
        titleLabel.setForeground(new java.awt.Color(255, 102, 0));
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN,40));
        fnameLabel = new JLabel("First Name:");
        lnameLabel = new JLabel("Last Name:");
        emailLabel = new JLabel("Email:");
        createPassLabel = new JLabel("Create Password:");
        confirmPassLabel = new JLabel("Confirm Password:");
        unameLabel = new JLabel("Username:");
        phoneLabel = new JLabel("Phone:");
        dobLabel = new JLabel("Date of birth");

        fnameField = new JTextField();
        lnameField = new JTextField();
        emailField = new JTextField();
        unameField = new JTextField();
        phoneField = new JTextField();
        dobField = new JTextField();
        createPassField = new JPasswordField();
        confirmPassField = new JPasswordField();

        registerButton = new JButton("Register");
        backButton = new JButton("Back");

        titleLabel.setBounds(287, 50, 197, 50);
        fnameLabel.setBounds(200, 160, 100, 21);
        lnameLabel.setBounds(200, 200, 100, 21);
        emailLabel.setBounds(200, 240, 100, 21);
        createPassLabel.setBounds(200, 280, 150, 21);
        confirmPassLabel.setBounds(200, 320, 150, 21);
        unameLabel.setBounds(200, 360, 100, 21);
        phoneLabel.setBounds(200, 400, 100, 21);
        dobLabel.setBounds(200, 440, 100, 21);

        fnameField.setBounds(320, 160, 225, 27);
        lnameField.setBounds(320, 200, 225,27);
        emailField.setBounds(320, 240, 225,27);
        createPassField.setBounds(320, 280, 225,27);
        confirmPassField.setBounds(320, 320, 225,27);
        unameField.setBounds(320, 360, 225,27);
        phoneField.setBounds(320, 400, 225,27);
        dobField.setBounds(320, 440, 225,27);

        registerButton.setBounds(320, 480, 90, 27);
        backButton.setBounds(470, 480, 75, 27);

        add(titleLabel); add(fnameLabel); add(lnameLabel); add(emailLabel); add(createPassLabel); add(confirmPassLabel); add(unameLabel); add(phoneLabel); add(dobLabel);
        add(fnameField); add(lnameField); add(emailField); add(createPassField); add(confirmPassField); add(unameField); add(phoneField); add(dobField);
        add(registerButton); add(backButton);

        registerButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton){
            if (fnameField.getText().trim().isEmpty() || lnameField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty() || unameField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty() || String.valueOf(createPassField.getPassword()).trim().isEmpty() || String.valueOf(confirmPassField.getPassword()).trim().isEmpty() || dobField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Warning: Required fields are empty");
            } else if (gf.emailNotValid(emailField)) {
                JOptionPane.showMessageDialog(this, "Warning: Invalid E-mail address");
            } else if(gf.passwordNotValid(createPassField)){
                JOptionPane.showMessageDialog(this, "Warning: Invalid Password. Must be 8 or more characters and have at least one digit");
            } else if (!gf.passMatching(createPassField, confirmPassField)) {
                JOptionPane.showMessageDialog(this, "Warning: Passwords do not match");
            } else if (!gf.checkDate(dobField)){
                JOptionPane.showMessageDialog(this, "Warning: Invalid date entered\nAccepted date format: YYYY-MM-DD");
            } else if (!gf.isPhoneValid(phoneField)){
                JOptionPane.showMessageDialog(this, "Warning: Invalid phone number entered. \nAccepted phone number format: 07XXXXXXXX");
            } else {
                String SQL = "INSERT INTO users(fname, lname, uname, pass, email, phone, dob, balance) VALUES('" + fnameField.getText() + "', '" + lnameField.getText() + "', '" + unameField.getText() + "', MD5('" + String.valueOf(createPassField.getPassword()) + "'), '" + emailField.getText() + "', '" + phoneField.getText() + "', '" + dobField.getText() + "', 0)";
                db.setData(SQL, "Registration success", this);
                Login login = new Login();
                login.setVisible(true);
                this.setVisible(false);
            }
        }
        if(e.getSource() == backButton){
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        }
    }
}
