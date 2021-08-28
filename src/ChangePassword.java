import javax.swing.*;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame{
    private JPanel ChangePassword;
    private JPasswordField pwNewPassword;
    private JPasswordField pwConfirmPassword;
    private JPasswordField pwOldPassword;
    private JLabel lOldPassword;
    private JButton updateButton;

    public ChangePassword(){
        add(ChangePassword);
    }

    public static void main(String[] args) {
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
        cp.setTitle("Parking System | Change Password");
        cp.pack();
        cp.setLocationRelativeTo(null);
        cp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

