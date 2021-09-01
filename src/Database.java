import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class Database extends Component {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    JFrame f;

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//JDBC driver name

            String host = "jdbc:mysql://localhost/parkingapp"; //Database URL
            String uName = "root";
            String uPass = "";

            conn = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException | ClassNotFoundException err) {
            JOptionPane.showMessageDialog(f, err.getMessage());
        }
        return conn;
    }

    public ResultSet getData(String SQL, Component component) {
        try {
            conn = connect();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(component, err.getMessage());
            err.printStackTrace();
        }
        return rs;
    }

    public void setData(String SQL, String success_message, Component component) {
        try {
            conn = connect();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(SQL);
            JOptionPane.showMessageDialog(component, success_message);
        } catch (MySQLIntegrityConstraintViolationException unameException) {
            JOptionPane.showMessageDialog(component, "Username already exists");
        } catch (MysqlDataTruncation mysqlDataTruncation){
            JOptionPane.showMessageDialog(component, "Incorrect Date Format\nAccepted format: YYYY-MM-DD");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(component, err.getMessage());
            err.printStackTrace();
        }
    }

    public DefaultTableModel buildTableModel(ResultSet rs) {
        Vector<String> columnNames = null;
        Vector<Vector<Object>> data = null;
        try {
            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            columnNames = new Vector<>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            data = new Vector<>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
        } catch (SQLException err){
            err.printStackTrace();
        }

        return new DefaultTableModel(data, columnNames);
    }
}
