package praktikum5;

abstract class Kendaraan {
	private String merk;
	private String model;
	private double tahunProduksi;
	
	public Kendaraan(String merk, String model, int tahunProduksi) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }
	
	public abstract void nyalakanMesin();
	
	public final void tampilkanInfo() {
		System.out.println("Merk: "+ merk);
		System.out.println("model: " + model);
		System.out.println("Tahun Produksi: " + tahunProduksi);
	}
	

}
