package Tugas;

public class Service {
	String id, jenis, harga, status;
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getJenis() {
		return jenis;
	}


	public void setJenis(String jenis) {
		this.jenis = jenis;
	}


	public String getHarga() {
		return harga;
	}


	public void setHarga(String harga) {
		this.harga = harga;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public static void main(String[] args) {
        
		Service layanan = new Service();
		
		layanan.setId("2411531006");
		layanan.setJenis("Laundry Express");
		layanan.setHarga("24000");
		layanan.setStatus("Lunas");
		
		System.out.println("ID Service: " + layanan.getId());
		System.out.println("Jenis: " + layanan.getJenis());
		System.out.println("Harga: " + layanan.getHarga());
		System.out.println("Status: " +layanan.getStatus());
		    }

}
