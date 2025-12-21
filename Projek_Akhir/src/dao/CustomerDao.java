package dao;

import model.Customer;
import java.util.List;

public interface CustomerDao {
	// Kontrak DAO untuk operasi CRUD pada entitas Customer
    void save(Customer customer);
    void update(Customer customer);
    void delete(int id);
    List<Customer> show();
}
