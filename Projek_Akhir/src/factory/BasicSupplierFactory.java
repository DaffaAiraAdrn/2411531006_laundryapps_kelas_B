package factory;

import model.Supplier;

//factory design pattern untuk supplier barang basic
public class BasicSupplierFactory implements SupplierFactory {

    @Override
    public Supplier create(String nama, String alamat, String telepon, String email) {
        return new Supplier(0, nama, alamat, telepon, email);
    }
}
