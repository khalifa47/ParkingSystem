import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Database extends Component {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    JFrame f;

    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");//JDBC driver name

            String host = "jdbc:mysql://localhost/parkingapp"; //Database URL
            String uName = "root";
            String uPass = "";

            conn = DriverManager.getConnection(host,uName,uPass);
        }
        catch (SQLException | ClassNotFoundException err){
            JOptionPane.showMessageDialog(f,err.getMessage());
        }
        return conn;
    }
    public ResultSet getData(String SQL, String success_message, String err_message){
        try {
            conn = connect();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            if (rs.next()){
                return rs;
            }
            else{
                JOptionPane.showMessageDialog(this, success_message);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err_message);
            err.printStackTrace();
        }
        return rs;
    }
    public void setData(String SQL, String success_message, String err_message){
        try{
            conn = connect();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(SQL);
            JOptionPane.showMessageDialog(this, success_message);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err_message);
            err.printStackTrace();
        }
    }
}
