package model;

public class ItemTransaksi {

    private Barang barang;
    private int jumlah;

    public ItemTransaksi(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getSubtotal() {
        return barang.getHarga() * jumlah;
    }
}
