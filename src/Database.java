import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

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
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(component, err.getMessage());
            err.printStackTrace();
        }
    }
}
