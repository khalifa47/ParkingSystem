import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateProfile extends JFrame{
    private JPanel UpdateProfile;
    private JTextField tfFirstName,tfLastName,tfEmail,tfUsername,tfPhoneNo;
    private JButton btnUpdate;
    private JLabel lFirstName,lLastName,lEmail,lUsername,lPhoneNo,lTitle;
    private JButton backButton;


    public UpdateProfile(){
        add(UpdateProfile);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard d = new Dashboard();
                d.setVisible(true);
            }
        });
    }

}
