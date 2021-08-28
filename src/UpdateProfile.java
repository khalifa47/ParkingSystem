import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateProfile extends JFrame{
    private JPanel UpdateProfile;
    private JTextField tfFirstName,tfLastName,tfEmail,tfUsername,tfPhoneNo;
    private JButton btnUpdate;
    private JLabel lFirstName,lLastName,lEmail,lUsername,lPhoneNo,lTitle;

    public UpdateProfile() {
        setSize(900, 900);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Parking System | Update Profile");
        setFont(Font.getFont("Tahoma"));

        lTitle = new JLabel("Update Profile");
        lTitle.setForeground(Color.getColor("CF2A27"));
        lTitle.setFont(new Font("Tahoma", Font.PLAIN,40));

        lFirstName = new JLabel("First Name");
        lLastName = new JLabel("Last Name");
        lUsername = new JLabel("Username");
        lEmail = new JLabel("E-mail");
        lPhoneNo = new JLabel("Phone Number");

        tfFirstName = new JTextField();
        tfLastName = new JTextField();
        tfUsername = new JTextField();
        tfEmail = new JTextField();
        tfPhoneNo = new JTextField();

        btnUpdate = new JButton("Update");

        lTitle.setBounds(287,77,300,44);
        lFirstName.setBounds(80,100,200,30);
        lLastName.setBounds(80,150,200,30);
        lUsername.setBounds(80,200,200,30);
        lEmail.setBounds(80,250,200,30);
        lPhoneNo.setBounds(80,300,200,30);
        btnUpdate.setBounds(287,400,300,44);

        tfFirstName.setBounds(180,100,200,30);
        tfLastName.setBounds(180,150,200,30);
        tfUsername.setBounds(180,200,200,30);
        tfEmail.setBounds(180,250,200,30);
        tfPhoneNo.setBounds(180,300,200,30);

        add(lTitle);add(lFirstName);add(lLastName);add(lUsername);add(lEmail);add(lPhoneNo);add(btnUpdate);
        add(tfFirstName);add(tfLastName);add(tfUsername);add(tfEmail);add(tfPhoneNo);

        btnUpdate.addActionListener((ActionListener) this);
    }

}
