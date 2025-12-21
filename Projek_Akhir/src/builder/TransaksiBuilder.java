package builder;

import model.ItemTransaksi;
import model.Transaksi;

import java.util.ArrayList;
import java.util.List;

public class TransaksiBuilder {

    private int idTransaksi;
    private final List<ItemTransaksi> items = new ArrayList<>();
    
  //method setter untuk mendefinisikan atribut objek Transaksi
    public TransaksiBuilder setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
        return this;
    }

    public TransaksiBuilder tambahItem(ItemTransaksi item) {
        this.items.add(item);
        return this;
    }
    
  //method yang membuat objek transaksi dengan atribut berdasarkan method setter yang dipanggil
    public Transaksi build() {
        double total = 0;
        for (ItemTransaksi item : items) {
            total += item.getSubtotal();
        }
        return new Transaksi(idTransaksi, items, total);
    }
}
