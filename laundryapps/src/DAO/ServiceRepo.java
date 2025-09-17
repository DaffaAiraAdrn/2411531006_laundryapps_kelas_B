// DAO/ServiceRepo.java
package DAO;

import confg.Database;
import Tugas.Service;
import java.sql.*;
import java.util.*;

public class ServiceRepo implements ServiceDao {
    private Connection connection;
    final String insert = "INSERT INTO service (jenis, harga, status) VALUES (?, ?, ?);";
    final String select = "SELECT * FROM service;";
    final String delete = "DELETE FROM service WHERE id=?;";
    final String update = "UPDATE service SET jenis=?, harga=?, status=? WHERE id=?;";

    public ServiceRepo() {
        connection = Database.koneksi();
    }

    @Override
    public void save(Service service) {
        try (PreparedStatement st = connection.prepareStatement(insert)) {
            st.setString(1, service.getJenis());
            st.setDouble(2, service.getHarga());
            st.setString(3, service.getStatus());
            st.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Service> show() {
        List<Service> list = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getString("id"));
                s.setJenis(rs.getString("jenis"));
                s.setHarga(rs.getDouble("harga"));
                s.setStatus(rs.getString("status"));
                list.add(s);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void update(Service service) {
        try (PreparedStatement st = connection.prepareStatement(update)) {
            st.setString(1, service.getJenis());
            st.setDouble(2, service.getHarga());
            st.setString(3, service.getStatus());
            st.setString(4, service.getId());
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
