package model;

public class Supplier {

    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;

    public Supplier(int id, String nama, String alamat, String telepon, String email) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
    }

	public int getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}


	public String getAlamat() {
		return alamat;
	}

	public String getTelepon() {
		return telepon;
	}


	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
	    return nama;
	}


	
    
    

}
