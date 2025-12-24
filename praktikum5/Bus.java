package praktikum5;

public class Bus extends Kendaraan implements TransportasiUmum {
	String kelasBus;
	public Bus(String merk, String model, int tahunProduksi, String kelasBus) {
		super(merk, model, tahunProduksi);
		this.kelasBus = kelasBus;
	}
	
    @Override
    public void nyalakanMesin() {
        System.out.println("Nyalakan mesin: Putar kunci untuk menyalakan.");
    }

    @Override
    public String jenisBahanBakar() {
        return "Jenis bahan bakar: Solar";
    }

    @Override
    public int kapasitasPenumpang() {
        return 45;
    }

    public void fiturBus() {
        System.out.println("Fitur bus: Dilengkapi kursi nyaman dan fasilitas hiburan");
    }
    class JadwalPerjalanan {
        private String rute;
        private String waktuBerangkat;

        public JadwalPerjalanan(String rute, String waktuBerangkat) {
            this.rute = rute;
            this.waktuBerangkat = waktuBerangkat;
        }

        public void tampilkanJadwal() {
            System.out.println("Rute: " + rute +", Waktu Berangkat: " + waktuBerangkat);
            
        }
    }
	
	

}
