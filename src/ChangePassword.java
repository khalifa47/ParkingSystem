import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame implements ActionListener{
    private JPanel ChangePassword;
    private JPasswordField pwNewPassword;
    private JPasswordField pwConfirmPassword;
    private JPasswordField pwOldPassword;
    private JLabel lOldPassword;
    private JButton updateButton;
    private JButton backButton;

    public ChangePassword(){
        add(ChangePassword);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            Dashboard d = new Dashboard();
            d.setVisible(true);
            this.setVisible(false);
        }
    }
}

