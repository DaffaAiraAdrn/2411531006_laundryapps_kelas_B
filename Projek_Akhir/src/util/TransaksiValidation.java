package util;

import error.ValidationException;
import model.ItemTransaksi;

import java.util.List;

/**
 * Validasi proses transaksi
 */
public class TransaksiValidation {

    public static void validate(List<ItemTransaksi> items)
            throws ValidationException {

        if (items == null || items.isEmpty()) {
            throw new ValidationException("Keranjang transaksi masih kosong");
        }

        for (ItemTransaksi item : items) {
            if (item.getJumlah() <= 0) {
                throw new ValidationException(
                        "Jumlah pembelian harus lebih dari 0");
            }

            if (item.getBarang().getStok() < item.getJumlah()) {
                throw new ValidationException(
                        "Stok barang tidak mencukupi");
            }
        }
    }
}
