package service;

import dao.CustomerRepo;
import model.Customer;

import java.util.List;

public class CustomerManager {

    private static CustomerManager instance;
    private final CustomerRepo customerRepo;

    private CustomerManager() {
        this.customerRepo = CustomerRepo.getInstance();
    }
    
    //singleton design pattern
    public static synchronized CustomerManager getInstance() {
        if (instance == null) {
            instance = new CustomerManager();
        }
        return instance;
    }

    public void tambahCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepo.update(customer);
    }

    public void hapusCustomer(int id) {
        customerRepo.delete(id);
    }

    public List<Customer> tampilkanSemuaCustomer() {
        return customerRepo.show();
    }
}
