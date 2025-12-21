package util;

import error.ValidationException;
import model.Barang;

/**
 * Validasi data Barang
 */
public class BarangValidation {

    public static void validate(Barang barang)
            throws ValidationException {

        if (barang == null) {
            throw new ValidationException("Data barang tidak boleh kosong");
        }

        if (barang.getNama() == null || barang.getNama().isBlank()) {
            throw new ValidationException("Nama barang wajib diisi");
        }

        if (barang.getStok() <= 0) {
            throw new ValidationException("Stok barang harus lebih dari 0");
        }

        if (barang.getHarga() <= 0) {
            throw new ValidationException("Harga barang harus lebih dari 0");
        }

        if (barang.getSupplier() == null || barang.getSupplier().isBlank()) {
            throw new ValidationException("Supplier wajib diisi");
        }
    }
}
