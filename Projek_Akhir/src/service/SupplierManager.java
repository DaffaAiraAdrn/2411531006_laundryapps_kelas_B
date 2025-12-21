package service;

import dao.SupplierRepo;
import model.Supplier;

import java.util.List;

public class SupplierManager {

    private static SupplierManager instance;
    private final SupplierRepo supplierRepo;

    private SupplierManager() {
        this.supplierRepo = SupplierRepo.getInstance();
    }
    
    //singleton design pattern
    public static synchronized SupplierManager getInstance() {
        if (instance == null) {
            instance = new SupplierManager();
        }
        return instance;
    }



    public void tambahSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
    }

    public void updateSupplier(Supplier supplier) {
        supplierRepo.update(supplier);
    }

    public void hapusSupplier(int id) {
        supplierRepo.delete(id);
    }

    public List<Supplier> tampilkanSemuaSupplier() {
        return supplierRepo.show();
    }

    public Supplier cariSupplierById(int id) {
        for (Supplier s : supplierRepo.show()) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
