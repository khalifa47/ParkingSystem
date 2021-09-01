import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame{
    private JPanel adminPanel;
    private JTable adminTable;
    private JButton backButton;

    Admin(){
        add(adminPanel);
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createTable();
    }
    private void createTable(){
        adminTable.setModel(new DefaultTableModel(
                null,
                new String[]{"UserID", "Full Name", "E-mail", "Age", "Phone", "Username", "Date Registered", "Selected Plan", ""}
        ));
    }
}
