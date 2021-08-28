import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransactionHistory extends JFrame{
    private JPanel TransactionHist;
    private JTable tblHistory;

  public TransactionHistory(){
      add(TransactionHist);
      createTable();
  }

  private void createTable(){
      tblHistory.setModel(new DefaultTableModel(
              null,
              new String[]{"Transaction ID", "Amount", "Date", "Time"}
      ));
  }

    public static void main(String[] args) {
        TransactionHistory th = new TransactionHistory();
        th.setVisible(true);
        th.pack();
        th.setTitle("Parking System | Transaction History");
        th.setLocationRelativeTo(null);
        th.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
