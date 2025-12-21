package dao;

import database.DatabaseConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import builder.CustomerBuilder;
import error.DatabaseException;

public class CustomerRepo implements CustomerDao {
    private static CustomerRepo instance;
    private final Connection connection;

    private CustomerRepo() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    //singleton design pattern, dan penerapan synchronized untuk mencegah race condition
    public static synchronized CustomerRepo getInstance() {
        if (instance == null) {
            instance = new CustomerRepo();
        }
        return instance;
    }

    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO customer (nama, alamat, hp, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customer.getNama());
            ps.setString(2, customer.getAlamat());
            ps.setString(3, customer.getHp());
            ps.setString(4, customer.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Gagal menyimpan customer", e);
        }
    }

    @Override
    public void update(Customer customer) {
        String sql = "UPDATE customer SET nama=?, alamat=?, hp=?, email=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customer.getNama());
            ps.setString(2, customer.getAlamat());
            ps.setString(3, customer.getHp());
            ps.setString(4, customer.getEmail());
            ps.setInt(5, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Gagal update customer", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM customer WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Gagal hapus customer", e);
        }
    }

    @Override
    public List<Customer> show() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Customer customer = new CustomerBuilder()
                        .setId(rs.getInt("id"))
                        .setNama(rs.getString("nama"))
                        .setAlamat(rs.getString("alamat"))
                        .setHp(rs.getString("hp"))
                        .setEmail(rs.getString("email"))
                        .build();
                list.add(customer);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Gagal mengambil data customer", e);
        }
        return list;
    }
}
