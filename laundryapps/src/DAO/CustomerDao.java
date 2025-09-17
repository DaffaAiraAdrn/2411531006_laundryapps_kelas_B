
package DAO;

import java.util.List;
import Tugas.Customer;

public interface CustomerDao {
    void save(Customer customer);
    List<Customer> show();
    void update(Customer customer);
    void delete(String id);
}
