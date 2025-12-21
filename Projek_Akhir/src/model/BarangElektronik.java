package model;

/*
 * Subclass class Barang
 */
public class BarangElektronik extends Barang {

    public BarangElektronik(int id, String nama, int stok, double harga, String supplier) {
        super(id, nama, stok, harga, "Elektronik", supplier);
    }

    @Override
    public String informasiBarang() {
        return "[ELEKTRONIK] " + getNama() + " | Harga: " + getHarga();
    }
}
