package dao;

import model.Transaksi;
import java.util.List;

public interface TransaksiDao {
	// Kontrak DAO untuk operasi CRUD pada entitas Transaksi
    void save(Transaksi transaksi);
    List<Transaksi> show();
}
