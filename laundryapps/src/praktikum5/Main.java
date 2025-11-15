package praktikum5;

public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", "Avanza", 2021, "Automatic");
        Bus bus = new Bus("Mercedes-Benz", "Bus Pariwisata", 2018, "Manual");
        Bus.JadwalPerjalanan jadwal = bus.new JadwalPerjalanan("Jakarta - Bandung", "08:00 WIB");
        Pesawat pesawat = new Pesawat("Boeing", "737", 2019, "Domestik", "Garuda Indonesia");

        System.out.println("=== Info Mobil ===");
        mobil.tampilkanInfo();
        mobil.nyalakanMesin();
        mobil.jenisBahanBakar();
        mobil.infoKonsumsi();
        mobil.fiturMobil();

        System.out.println("\n=== Info Bus ===");
        bus.tampilkanInfo();
        bus.nyalakanMesin();
        bus.jenisBahanBakar();
        System.out.println("Kapasitas Penumpang: " + bus.kapasitasPenumpang());
        bus.infoKonsumsi();
        bus.fiturBus();
        jadwal.tampilkanJadwal();

        System.out.println("\n=== Info Pesawat ===");
        pesawat.tampilkanInfo();
        pesawat.nyalakanMesin();
        System.out.println("Nama Maskapai: " + pesawat.namaMaskapai());
        System.out.println("Jenis Penerbangan: " + pesawat.jenisPenerbangan());
        System.out.println("Jenis Bahan Bakar: " + pesawat.jenisBahanBakar());
        
    }
}
