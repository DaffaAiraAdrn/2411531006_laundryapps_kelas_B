package database;

import error.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	/*
	 * url user dan password untuk membangun koneksi dengan database
	 */
    private static DatabaseConnection instance;
    private Connection connection;
    private static final String URL ="jdbc:mysql://localhost:3306/supermarket_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new DatabaseException(
                    "Driver MySQL tidak ditemukan", e);

        } catch (Exception e) {
            throw new DatabaseException(
                    "Gagal koneksi ke database", e);
        }
    }
    
    //singleton design pattern, dan penerapan synchronized untuk mencegah race condition
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public Connection getConnection() {
        if (connection == null) {
            throw new DatabaseException("Koneksi database belum tersedia");
        }
        return connection;
    }
}
