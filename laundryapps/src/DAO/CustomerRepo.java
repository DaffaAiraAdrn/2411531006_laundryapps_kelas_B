package DAO;

import confg.Database;
import model.Customer;
import model.CustomerBuilder;
import java.sql.*;
import java.util.*;

public class CustomerRepo implements CustomerDao {

	private static CustomerRepo instance;

	public static CustomerRepo getInstance() {
	    if (instance == null) {
	        instance = new CustomerRepo();
	    }
	    return instance;
	}


    private Connection connection;

    private final String insert = "INSERT INTO customer (nama, alamat, no_Hp, email) VALUES (?, ?, ?, ?);";
    private final String select = "SELECT * FROM customer;";
    private final String delete = "DELETE FROM customer WHERE id=?;";
    private final String update = "UPDATE customer SET nama=?, alamat=?, no_hp=?, email=? WHERE id=?;";

    
    public CustomerRepo() {
        connection = Database.koneksi();
    }

 
    @Override
    public void save(Customer cs) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(insert);
            Customer built = new CustomerBuilder()
                    .setNama(cs.getNama())
                    .setAlamat(cs.getAlamat())
                    .setHp(cs.getHp())
                    .setEmail(cs.getEmail())
                    .build();

            st.setString(1, built.getNama());
            st.setString(2, built.getAlamat());
            st.setString(3, built.getHp());
            st.setString(4, built.getEmail());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (st != null) st.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }


    @Override
    public List<Customer> show() {
        List<Customer> list = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {

                Customer cs = new CustomerBuilder()
                        .setId(rs.getString("id"))
                        .setNama(rs.getString("nama"))
                        .setEmail(rs.getString("email"))
                        .setAlamat(rs.getString("alamat"))
                        .setHp(rs.getString("no_Hp"))
                        .build();

                list.add(cs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void update(Customer cs) {
        try (PreparedStatement st = connection.prepareStatement(update)) {
            Customer built = new CustomerBuilder()
                    .setId(cs.getId())
                    .setNama(cs.getNama())
                    .setAlamat(cs.getAlamat())
                    .setHp(cs.getHp())
                    .setEmail(cs.getEmail())
                    .build();

            st.setString(1, built.getNama());
            st.setString(2, built.getAlamat());
            st.setString(3, built.getHp());
            st.setString(4, built.getEmail());
            st.setString(5, built.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(String id) {
        try (PreparedStatement st = connection.prepareStatement(delete)) {
            Customer temp = new CustomerBuilder()
                    .setId(id)
                    .build();

            st.setString(1, temp.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
