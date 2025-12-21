package service;

import model.Barang;
import dao.BarangRepo;

import java.util.List;

public class InventoryManager {

    private static InventoryManager instance;
    private final BarangRepo barangRepo;

    private InventoryManager() {
        this.barangRepo = BarangRepo.getInstance();
    }
    
    //singleton design pattern
    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void tambahBarang(Barang barang) {
        barangRepo.save(barang);
    }

    public void hapusBarang(int id) {
        barangRepo.delete(id);
    }

    public void updateStok(int id, int stokBaru) {
        Barang barang = cariBarang(id);
        if (barang != null) {
            barang.setStok(stokBaru);
            barangRepo.update(barang);
        }
    }

    public Barang cariBarang(int id) {
        List<Barang> list = barangRepo.show();
        for (Barang b : list) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
    
    public void kurangiStok(Barang barang, int jumlah) {
        if (barang.getStok() < jumlah) {
            throw new RuntimeException("Stok barang tidak mencukupi");
        }

        barang.setStok(barang.getStok() - jumlah);
        barangRepo.update(barang);
    }


    public List<Barang> tampilkanSemuaBarang() {
        return barangRepo.show();
    }
    
}
