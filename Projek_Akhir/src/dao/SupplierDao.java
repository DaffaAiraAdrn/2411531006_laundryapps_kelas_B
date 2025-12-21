package dao;

import model.Supplier;
import java.util.List;

public interface SupplierDao {
	// Kontrak DAO untuk operasi CRUD pada entitas Supplier
    void save(Supplier supplier);
    void update(Supplier supplier);
    void delete(int id);
    List<Supplier> show();
}
