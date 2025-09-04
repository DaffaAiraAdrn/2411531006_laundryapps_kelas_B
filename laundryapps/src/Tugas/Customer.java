package Tugas;

public class Customer {
	String id, nama, Alamat, nomorHp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return Alamat;
	}

	public void setAlamat(String alamat) {
		Alamat = alamat;
	}

	public String getNomorHp() {
		return nomorHp;
	}

	public void setNomorHp(String nomorHp) {
		this.nomorHp = nomorHp;
	}
	public static void main(String args[]) {
		Customer dude = new Customer();
		dude.setId("dude123");
		dude.setNama("Abdullah");
		dude.setAlamat("Jl. Cipaganti");
		dude.setNomorHp("0812345");
		
		System.out.println("This dude with an ID of " 
		+ dude.getId() + "l ives in " + dude.getAlamat() + " his name is " 
				+ dude.getNama() + " with a phone number of " + dude.getNomorHp());
	}
	

}
