package util;

import error.ValidationException;
import model.Customer;

/**
 * Validasi data Customer VIP
 */
public class CustomerValidation {

    public static void validate(Customer customer)
            throws ValidationException {

        if (customer == null) {
            throw new ValidationException("Data customer tidak boleh kosong");
        }

        if (customer.getNama() == null || customer.getNama().isBlank()) {
            throw new ValidationException("Nama customer wajib diisi");
        }

        if (customer.getAlamat() == null || customer.getAlamat().isBlank()) {
            throw new ValidationException("Alamat customer wajib diisi");
        }

        if (customer.getHp() == null || customer.getHp().isBlank()) {
            throw new ValidationException("Nomor HP wajib diisi");
        }

        if (customer.getEmail() == null || customer.getEmail().isBlank()) {
            throw new ValidationException("Email wajib diisi");
        }
    }
}
