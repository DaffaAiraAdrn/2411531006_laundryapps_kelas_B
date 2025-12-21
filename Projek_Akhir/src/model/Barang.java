package model;

public abstract class Barang {

    private int id;
    private String nama;
    private int stok;
    private double harga;
    private String kategori;
    private String supplier;

    public Barang(int id, String nama, int stok, double harga, String kategori, String supplier) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.kategori = kategori;
        this.supplier = supplier;
    }


    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNama() {
		return nama;
	}


	public void setNama(String nama) {
		this.nama = nama;
	}


	public int getStok() {
		return stok;
	}


	public void setStok(int stok) {
		this.stok = stok;
	}


	public double getHarga() {
		return harga;
	}


	public void setHarga(double harga) {
		this.harga = harga;
	}


	public String getKategori() {
		return kategori;
	}


	public void setKategori(String kategori) {
		this.kategori = kategori;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@Override
	public String toString() {
	    return nama;
	}



	public abstract String informasiBarang();
}
