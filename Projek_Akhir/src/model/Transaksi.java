package model;

import java.util.List;

public class Transaksi {

    private int idTransaksi;
    private List<ItemTransaksi> items;
    private double total;

    public Transaksi(int idTransaksi, List<ItemTransaksi> items, double total) {
        this.idTransaksi = idTransaksi;
        this.items = items;
        this.total = total;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public List<ItemTransaksi> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}
