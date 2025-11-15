package praktikum5;

public class Pesawat extends Kendaraan implements TransportasiUdara, Maskapai {
    private String tipePenerbangan;
    private String namaMaskapai;

    public Pesawat(String merk, String model, int tahunProduksi, String tipePenerbangan, String namaMaskapai) {
        super(merk, model, tahunProduksi);
        this.tipePenerbangan = tipePenerbangan;
        this.namaMaskapai = namaMaskapai;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Nyalakan Mesin: Bersiap lepas landas.");
    }

    @Override
    public String jenisBahanBakar() {
        return "Avtur";
    }

    @Override
    public String jenisPenerbangan() {
        return tipePenerbangan;
    }

    @Override
    public String namaMaskapai() {
        return namaMaskapai;
    }

  
}
