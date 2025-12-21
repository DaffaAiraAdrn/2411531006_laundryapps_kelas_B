package factory;

import model.Barang;

//factory design pattern untuk barang
public interface BarangFactory {
    Barang create(int id, String nama, int stok, double harga, String supplier);
}
