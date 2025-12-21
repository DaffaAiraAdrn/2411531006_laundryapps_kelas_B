package factory;

import model.Barang;
import model.BarangElektronik;

//factory design pattern untuk supplier barang elektronik
public class ElektronikFactory implements BarangFactory {

    @Override
    public Barang create(int id, String nama, int stok, double harga, String supplier) {
        return new BarangElektronik(id, nama, stok, harga, supplier);
    }
}
