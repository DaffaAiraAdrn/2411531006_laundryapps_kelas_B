package dao;

import model.Barang;
import java.util.List;

public interface BarangDao {
	
	// Kontrak DAO untuk operasi CRUD pada entitas Barang
    void save(Barang barang);
    List<Barang> show();
    void update(Barang barang);
    void delete(int id);
}
