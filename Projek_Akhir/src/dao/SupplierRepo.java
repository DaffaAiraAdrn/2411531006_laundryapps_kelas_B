package dao;

import database.DatabaseConnection;
import model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepo implements SupplierDao {

    private static SupplierRepo instance;
    private final Connection connection;

    private SupplierRepo() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    //singleton design pattern, dan penerapan synchronized untuk mencegah race condition
    public static synchronized SupplierRepo getInstance() {
        if (instance == null) {
            instance = new SupplierRepo();
        }
        return instance;
    }

    @Override
    public void save(Supplier supplier) {
        String sql = "INSERT INTO supplier (nama, alamat, telepon, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, supplier.getNama());
            ps.setString(2, supplier.getAlamat());
            ps.setString(3, supplier.getTelepon());
            ps.setString(4, supplier.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal menyimpan supplier", e);
        }
    }

    @Override
    public void update(Supplier supplier) {
        String sql = "UPDATE supplier SET nama=?, alamat=?, telepon=?, email=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, supplier.getNama());
            ps.setString(2, supplier.getAlamat());
            ps.setString(3, supplier.getTelepon());
            ps.setString(4, supplier.getEmail());
            ps.setInt(5, supplier.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update supplier", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM supplier WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus supplier", e);
        }
    }

    @Override
    public List<Supplier> show() {
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM supplier";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Supplier(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("telepon"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data supplier", e);
        }
        return list;
    }
}
