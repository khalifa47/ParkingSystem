import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TransactionHistory extends JFrame implements ActionListener {
    private JPanel TransactionHist;
    private JTable tblHistory;
    private JButton backButton;
    Database db = new Database();
    public TransactionHistory(){
      add(TransactionHist);
      setSize(900, 600);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      createTable();
  }

  private void createTable(){
      tblHistory.setModel(new DefaultTableModel(
              null,
              new String[]{"Transaction ID", "Amount", "Date", "Time"}
      ));
      String SQL = "SELECT parkingID, price, park_date, park_time FROM parking";
      ResultSet resultSet = db.getData(SQL, this);

      tblHistory.setModel(db.buildTableModel(resultSet));
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
