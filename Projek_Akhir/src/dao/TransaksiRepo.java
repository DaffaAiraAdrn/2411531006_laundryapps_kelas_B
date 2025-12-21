package dao;

import database.DatabaseConnection;
import model.Transaksi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiRepo implements TransaksiDao {

    private static TransaksiRepo instance;
    private final Connection connection;

    private TransaksiRepo() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
    //singleton design pattern, dan synchronized untuk mencegah race condition
    public static synchronized TransaksiRepo getInstance() {
        if (instance == null) {
            instance = new TransaksiRepo();
        }
        return instance;
    }

    @Override
    public void save(Transaksi transaksi) {
        String sql = "INSERT INTO transaksi (total) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, transaksi.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal menyimpan transaksi", e);
        }
    }

    @Override
    public List<Transaksi> show() {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Transaksi(
                        rs.getInt("id"),
                        new ArrayList<>(), // item di-load terpisah 
                        rs.getDouble("total")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil transaksi", e);
        }
        return list;
    }
}
