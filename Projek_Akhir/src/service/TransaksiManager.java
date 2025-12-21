package service;

import dao.TransaksiRepo;
import model.Transaksi;

import java.util.List;

public class TransaksiManager {

    private static TransaksiManager instance;
    private final TransaksiRepo transaksiRepo;

    private TransaksiManager() {
        this.transaksiRepo = TransaksiRepo.getInstance();
    }

    public static synchronized TransaksiManager getInstance() {
        if (instance == null) {
            instance = new TransaksiManager();
        }
        return instance;
    }

    public void simpanTransaksi(Transaksi transaksi) {
        transaksiRepo.save(transaksi);
    }

    public List<Transaksi> tampilkanSemuaTransaksi() {
        return transaksiRepo.show();
    }
}
