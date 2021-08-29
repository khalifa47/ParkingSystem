import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionHistory extends JFrame implements ActionListener {
    private JPanel TransactionHist;
    private JTable tblHistory;
    private JButton backButton;

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
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            Dashboard d = new Dashboard();
            d.setVisible(true);
            this.setVisible(false);
        }
    }

//    public static void main(String[] args) {
//        TransactionHistory th = new TransactionHistory();
//        th.setVisible(true);
//        th.pack();
//        th.setTitle("Parking System | Transaction History");
//        th.setLocationRelativeTo(null);
//        th.setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
}
