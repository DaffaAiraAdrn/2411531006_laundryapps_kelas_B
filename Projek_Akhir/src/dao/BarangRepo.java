package dao;
import database.DatabaseConnection;
import model.Barang;
import model.BarangGrocery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangRepo implements BarangDao {
	
	//Variabel untuk menyimpan objek barangrepo & connection
    private static BarangRepo instance;
    private final Connection connection;
    
    //constructor
    private BarangRepo() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
    //singleton design pattern
    public static synchronized BarangRepo getInstance() {
        if (instance == null) {
            instance = new BarangRepo();
        }
        return instance;
    }
    
    //CRUD (method save untuk meyimpan data pada tabel di mysql) 
    @Override
    public void save(Barang barang) {
        String sql = "INSERT INTO barang (nama, stok, harga, kategori, supplier) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, barang.getNama());
            ps.setInt(2, barang.getStok());
            ps.setDouble(3, barang.getHarga());
            ps.setString(4, barang.getKategori());
            ps.setString(5, barang.getSupplier());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
  //CRUD (method show untuk menampilkan data yang ada di tabel di mysql)
    @Override
    public List<Barang> show() {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Barang barang = new BarangGrocery(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getInt("stok"),
                        rs.getDouble("harga"),
                        rs.getString("supplier")
                );
                list.add(barang);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
  //CRUD (method update untuk update data pada tabel di mysql)
    @Override
    public void update(Barang barang) {
        String sql = "UPDATE barang SET nama=?, stok=?, harga=?, supplier=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, barang.getNama());
            ps.setInt(2, barang.getStok());
            ps.setDouble(3, barang.getHarga());
            ps.setString(4, barang.getSupplier());
            ps.setInt(5, barang.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
  //CRUD (method delete untuk menghapus data pada tabel di mysql)
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM barang WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
