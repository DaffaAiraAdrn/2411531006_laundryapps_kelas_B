package builder;

import model.Supplier;

public class SupplierBuilder {

    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    
    //method setter untuk mendefinisikan atribut objek supplier

    public SupplierBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public SupplierBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public SupplierBuilder setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public SupplierBuilder setTelepon(String telepon) {
        this.telepon = telepon;
        return this;
    }

    public SupplierBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
    
    //method yang membuat objek supplier dengan atribut berdasarkan method setter yang dipanggil
    public Supplier build() {
        return new Supplier(id, nama, alamat, telepon, email);
    }
}
