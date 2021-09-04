import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ChangePassword extends JFrame implements ActionListener{
    private JPanel ChangePassword;
    private JPasswordField pwNewPassword;
    private JPasswordField pwConfirmPassword;
    private JPasswordField pwOldPassword;
    private JLabel lOldPassword;
    private JButton updateButton;
    private JButton backButton;
    Database db = new Database();
//    Login login = new Login();
    GlobalFunctions gf = new GlobalFunctions();
    public ChangePassword(){
        add(ChangePassword);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gf.passMatching(pwNewPassword,pwConfirmPassword)){
                    String userID = "SELECT userID FROM users WHERE pass = MD5('" + String.valueOf(pwOldPassword.getPassword()) + "')";
                    //Problem being that you can update someone else's password if you know it
                    ResultSet resultSet = db.getData(userID, ChangePassword);
                    String SQL = "UPDATE users SET pass = "+ pwConfirmPassword+ " WHERE userID = "+resultSet;
                    ResultSet update = db.setData2(SQL,"Password Successfully Updated",ChangePassword);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            Dashboard d = new Dashboard();
            d.setVisible(true);
            this.setVisible(false);
        }
    }
    private void updatePassword(){


//        adminTable.setModel(db.buildTableModel(resultSet));
    }
}

