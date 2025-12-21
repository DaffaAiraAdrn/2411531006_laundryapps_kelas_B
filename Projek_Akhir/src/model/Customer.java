package model;

public class Customer {

    private int id;
    private String nama;
    private String alamat;
    private String hp;
    private String email;
    

    public Customer(int id, String nama, String alamat, String hp, String email) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.hp = hp;
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


	public String getHp() {
		return hp;
	}

	public String getEmail() {
		return email;
	}
	
	//agar nama objek dapat ditampilkan
	@Override
	public String toString() {
	    return nama;
	}




}
