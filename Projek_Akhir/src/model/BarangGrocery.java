package model;

/*
 * subclass class barang
 */

public class BarangGrocery extends Barang {

    public BarangGrocery(int id, String nama, int stok, double harga, String supplier) {
        super(id, nama, stok, harga, "Grocery", supplier);
    }

    @Override
    public String informasiBarang() {
        return "Barang Grocery: " + getNama() +
               ", Stok: " + getStok() +
               ", Harga: " + getHarga();
    }
}

