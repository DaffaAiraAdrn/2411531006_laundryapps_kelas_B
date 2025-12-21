package builder;

import model.Customer;

public class CustomerBuilder {

    private int id;
    private String nama;
    private String alamat;
    private String hp;
    private String email;
    
    //setter untuk atribut objek customer

    public CustomerBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public CustomerBuilder setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public CustomerBuilder setHp(String hp) {
        this.hp = hp;
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
    // method membuat objek customer
    public Customer build() {
        return new Customer(id, nama, alamat, hp, email);
    }
  
}
