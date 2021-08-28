import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateProfile extends JFrame{
    private JPanel UpdateProfile;
    private JTextField tfFirstName,tfLastName,tfEmail,tfUsername,tfPhoneNo;
    private JButton btnUpdate;
    private JLabel lFirstName,lLastName,lEmail,lUsername,lPhoneNo,lTitle;

    public UpdateProfile(){
        add(UpdateProfile);
    }

    public static void main(String[] args) {
        UpdateProfile up = new UpdateProfile();
        up.setVisible(true);
        up.setTitle("Update profile");
        up.pack();
        up.setLocationRelativeTo(null);
        up.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
