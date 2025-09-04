package Tugas;

public class Order {
	String id, id_customer, id_service, id_user, total, tanggal, tanggal_selesai, status, status_pembayaraan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_customer() {
		return id_customer;
	}

	public void setId_customer(String id_customer) {
		this.id_customer = id_customer;
	}

	public String getId_service() {
		return id_service;
	}

	public void setId_service(String id_service) {
		this.id_service = id_service;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getTanggal_selesai() {
		return tanggal_selesai;
	}

	public void setTanggal_selesai(String tanggal_selesai) {
		this.tanggal_selesai = tanggal_selesai;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_pembayaraan() {
		return status_pembayaraan;
	}

	public void setStatus_pembayaraan(String status_pembayaraan) {
		this.status_pembayaraan = status_pembayaraan;
	}

	public static void main(String[] args) {
        
		Order pesanan= new Order();
        pesanan.setId("Pes1");
        pesanan.setId_customer("Pel1");
        pesanan.setId_service("Lay1");
        pesanan.setId_user("thisguy1");
        pesanan.setTotal("500000");
        pesanan.setTanggal("2025-09-02");
        pesanan.setTanggal_selesai("2025-09-03");
        pesanan.setStatus("Sedang diproses");
        pesanan.setStatus_pembayaraan("Belum Lunas");
        System.out.println("ID Order: " + pesanan.getId());
        System.out.println("ID Customer: " +pesanan.getId_customer());
        System.out.println("ID Service: " + pesanan.getId_service());
        System.out.println("ID User: " +pesanan.getId_user());
        System.out.println("Total: " + pesanan.getTotal());
        System.out.println("Tanggal: " + pesanan.getTanggal());
        System.out.println("Tanggal Selesai: " + pesanan.getTanggal_selesai());
        System.out.println("Status: " + pesanan.getStatus());
        System.out.println("Status Pembayaran: " + pesanan.getStatus_pembayaraan());
    }
}


