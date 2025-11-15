package praktikum5;

final class Mobil extends Kendaraan implements BahanBakar {
    private String jenisTransmisi;

    public Mobil(String merk, String model, int tahunProduksi, String jenisTransmisi) {
        super(merk, model, tahunProduksi);
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Nyalakan mesin dengan: Tekan tombol start");
    }

    @Override
    public String jenisBahanBakar() {
        return "Jenis bahan bakar: Bensin";
    }

    public void fiturMobil() {
        System.out.println("Fitur mobil: Memiliki Ac dan Audio Premium");
    }
}
