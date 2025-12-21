package util;

import error.ValidationException;
import model.Supplier;

/**
 * Validasi data Supplier
 */
public class SupplierValidation {

    public static void validate(Supplier supplier)
            throws ValidationException {

        if (supplier == null) {
            throw new ValidationException("Data supplier tidak boleh kosong");
        }

        if (supplier.getNama() == null || supplier.getNama().isBlank()) {
            throw new ValidationException("Nama supplier wajib diisi");
        }

        if (supplier.getAlamat() == null || supplier.getAlamat().isBlank()) {
            throw new ValidationException("Alamat supplier wajib diisi");
        }

        if (supplier.getTelepon() == null || supplier.getTelepon().isBlank()) {
            throw new ValidationException("Nomor telepon wajib diisi");
        }

        if (supplier.getEmail() == null || supplier.getEmail().isBlank()) {
            throw new ValidationException("Email supplier wajib diisi");
        }
    }
}
