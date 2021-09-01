import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;

public class Admin extends JFrame{
    private JPanel adminPanel;
    private JTable adminTable;
    private JButton backButton;

    Database db = new Database();

    Admin(){
        add(adminPanel);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createTable();
    }
    private void createTable(){
        String SQL = "SELECT userID, fname, lname, uname, dob, phone, email, date_registered, balance FROM users";
        ResultSet resultSet = db.getData(SQL, this);

        adminTable.setModel(db.buildTableModel(resultSet));
    }
}
