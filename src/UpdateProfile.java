import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;

public class UpdateProfile extends JFrame{
    private JPanel UpdateProfile;
    private JTextField tfFirstName,tfLastName,tfEmail,tfUsername,tfPhoneNo;
    private JButton btnUpdate;
    private JLabel lFirstName,lLastName,lEmail,lUsername,lPhoneNo,lTitle;
    private JButton backButton;
    private JLabel validatePhone;
    private JLabel validateUsername;


    public UpdateProfile(){
        add(UpdateProfile);
        setSize(900, 600);
        validatePhone.setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard d = new Dashboard();
                d.setVisible(true);
            }
        });

        tfPhoneNo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try{
                    int i = Integer.parseInt(tfPhoneNo.getText());
                } catch (NumberFormatException e1){
                    validatePhone.setVisible(true);
                    validatePhone.setText("Invalid Phone number");
                }
                GlobalFunctions.isPhoneValid(tfPhoneNo);
            }
        });
        tfLastName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
                    tfLastName.setEditable(true);
                }else{
                    tfLastName.setEditable(false);
                }

            }
        });
        tfFirstName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
                    tfFirstName.setEditable(true);
                }else{
                    tfFirstName.setEditable(false);
                }
            }
        });
    }
}
