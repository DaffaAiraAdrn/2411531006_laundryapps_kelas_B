package confg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {
    private static Connection conn;
    public static Connection koneksi() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/laundry_apps", "root", "");
                System.out.println("Berhasil terkoneksi dengan Database");
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi pada database gagal" + e.getMessage());
            }
        }
        return conn;
    }
    public static void main(String[] args) {
    	koneksi();
    }
}