package factory;

import model.Barang;
import model.BarangGrocery;

//factory design pattern untuk supplier barang grocery
public class GroceryFactory implements BarangFactory {

    @Override
    public Barang create(int id, String nama, int stok, double harga, String supplier) {
        return new BarangGrocery(id, nama, stok, harga, supplier);
    }
}
