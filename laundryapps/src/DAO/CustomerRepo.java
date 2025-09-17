// DAO/CustomerRepo.java
package DAO;

import confg.Database;
import Tugas.Customer;
import java.sql.*;
import java.util.*;

public class CustomerRepo implements CustomerDao {
    private Connection connection;
    final String insert = "INSERT INTO customer (nama, alamat, no_hp) VALUES (?, ?, ?);";
    final String select = "SELECT * FROM customer;";
    final String delete = "DELETE FROM customer WHERE id=?;";
    final String update = "UPDATE customer SET nama=?, alamat=?, no_hp=? WHERE id=?;";

    public CustomerRepo() {
        connection = Database.koneksi();
    }

    @Override
    public void save(Customer customer) {
        try (PreparedStatement st = connection.prepareStatement(insert)) {
            st.setString(1, customer.getNama());
            st.setString(2, customer.getAlamat());
            st.setString(3, customer.getNomorHp());
            st.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Customer> show() {
        List<Customer> list = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getString("id"));
                c.setNama(rs.getString("nama"));
                c.setAlamat(rs.getString("alamat"));
                c.setNomorHp(rs.getString("no_hp"));
                list.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void update(Customer customer) {
        try (PreparedStatement st = connection.prepareStatement(update)) {
            st.setString(1, customer.getNama());
            st.setString(2, customer.getAlamat());
            st.setString(3, customer.getNomorHp());
            st.setString(4, customer.getId());
            st.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement st = connection.prepareStatement(delete)) {
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
