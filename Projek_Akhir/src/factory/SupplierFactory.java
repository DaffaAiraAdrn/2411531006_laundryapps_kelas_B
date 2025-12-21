package factory;

import model.Supplier;

//interface untuk factory design pattern
public interface SupplierFactory {

    Supplier create(String nama, String alamat, String telepon, String email);
}
