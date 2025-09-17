// DAO/ServiceDao.java
package DAO;
import java.util.List;
import Tugas.Service;

public interface ServiceDao {
    void save(Service service);
    List<Service> show();
    void update(Service service);
    void delete(String id);
}


