package ui;

import builder.*;
import factory.*;
import model.*;
import service.*;
import tabel.*;
import util.*;
import error.DatabaseException;
import error.ValidationException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
	/* ===================Inisialisasi Variabel Global ===================== */
    private final InventoryManager inventory = InventoryManager.getInstance();
    private final SupplierManager supplierManager = SupplierManager.getInstance();
    private final CustomerManager customerManager = CustomerManager.getInstance();
    private final TransaksiManager transaksiManager = TransaksiManager.getInstance();

    private TableBarang tableBarangModel;
    private TableTransaksi tableTransaksiModel;
    private JComboBox<Supplier> cbSupplierBarang;
    private JComboBox<Customer> cbCustomer;
    private JTextField hargaField;

    public MainFrame() {
        setTitle("Supermarket VIP System");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Supplier", tabSupplier());
        tabs.add("Barang", tabBarang());
        tabs.add("Customer VIP", tabCustomer());
        tabs.add("Transaksi", tabTransaksi());
        tabs.add("Riwayat", tabRiwayat());

        setContentPane(tabs);
    }

    /* ======================= TAB SUPPLIER ======================= */
    private JPanel tabSupplier() {
        JPanel p = new JPanel(null);

        JTable table = new JTable(
                new TableSupplier(supplierManager.tampilkanSemuaSupplier()));
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 10, 750, 520);
        p.add(sp);

        JLabel lNama = new JLabel("Nama Supplier");
        lNama.setBounds(780, 20, 200, 25);
        p.add(lNama);

        JTextField tfNama = new JTextField();
        tfNama.setBounds(780, 45, 260, 30);
        p.add(tfNama);

        JLabel lAlamat = new JLabel("Alamat");
        lAlamat.setBounds(780, 85, 200, 25);
        p.add(lAlamat);

        JTextField tfAlamat = new JTextField();
        tfAlamat.setBounds(780, 110, 260, 30);
        p.add(tfAlamat);

        JLabel lTelp = new JLabel("Telepon");
        lTelp.setBounds(780, 150, 200, 25);
        p.add(lTelp);

        JTextField tfTelp = new JTextField();
        tfTelp.setBounds(780, 175, 260, 30);
        p.add(tfTelp);

        JLabel lEmail = new JLabel("Email");
        lEmail.setBounds(780, 215, 200, 25);
        p.add(lEmail);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(780, 240, 260, 30);
        p.add(tfEmail);

        JButton btnTambah = new JButton("Tambah Supplier");
        btnTambah.setBounds(780, 290, 260, 40);
        p.add(btnTambah);
        
        JButton hapusSupplierButton = new JButton("Hapus Supplier");
        hapusSupplierButton.setBounds(780, 352, 260, 30);
        p.add(hapusSupplierButton);
        
        //Menghapus supplier
        hapusSupplierButton.addActionListener(e -> {
            try {
                int selectedRow = table.getSelectedRow();                
                if (selectedRow == -1) {
                    throw new ValidationException(
                            "Pilih supplier yang ingin dihapus");
                }

                TableSupplier model = (TableSupplier) table.getModel();
                Supplier supplier = model.getSupplierAt(selectedRow);

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Yakin ingin menghapus supplier:\n" + supplier.getNama(),
                        "Konfirmasi Hapus Supplier",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }                
                supplierManager.hapusSupplier(supplier.getId());                
                table.setModel(new TableSupplier(
                        supplierManager.tampilkanSemuaSupplier()));
                reloadSupplierComboBox();
                JOptionPane.showMessageDialog(
                        this,
                        "Supplier berhasil dihapus",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (ValidationException ve) {
                JOptionPane.showMessageDialog(
                        this,
                        ve.getMessage(),
                        "Validasi Gagal",
                        JOptionPane.WARNING_MESSAGE
                );

            } catch (DatabaseException de) {
                JOptionPane.showMessageDialog(
                        this,
                        "Gagal menghapus supplier dari database.\n"
                                + de.getMessage(),
                        "Kesalahan Database",
                        JOptionPane.ERROR_MESSAGE
                );

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Terjadi kesalahan sistem.\n"
                                + "Silakan hubungi administrator.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        
        // Menambahi Supplier baru
        btnTambah.addActionListener(e -> {
            try {
                Supplier s = new BasicSupplierFactory()
                        .create(tfNama.getText(), tfAlamat.getText(),
                                tfTelp.getText(), tfEmail.getText());

                SupplierValidation.validate(s);
                supplierManager.tambahSupplier(s);
                table.setModel(new TableSupplier(
                        supplierManager.tampilkanSemuaSupplier()));
                reloadSupplierComboBox();
                
                

            } catch (ValidationException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        return p;
        
    }

    /* =======================TAB BARANG ======================= */
    private JPanel tabBarang() {
        JPanel p = new JPanel(null);

        tableBarangModel = new TableBarang(inventory.tampilkanSemuaBarang());
        JTable table = new JTable(tableBarangModel);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 10, 750, 520);
        p.add(sp);

        JLabel lNama = new JLabel("Nama Barang");
        lNama.setBounds(780, 20, 200, 25);
        p.add(lNama);

        JTextField tfNama = new JTextField();
        tfNama.setBounds(780, 45, 260, 30);
        p.add(tfNama);

        JLabel lStok = new JLabel("Stok");
        lStok.setBounds(780, 85, 200, 25);
        p.add(lStok);

        JTextField tfStok = new JTextField();
        tfStok.setBounds(780, 110, 260, 30);
        p.add(tfStok);

        JLabel lKategori = new JLabel("Kategori");
        lKategori.setBounds(780, 196, 200, 25);
        p.add(lKategori);

        JComboBox<String> cbKategori =
                new JComboBox<>(new String[]{"Elektronik", "Grocery"});
        cbKategori.setBounds(780, 231, 260, 30);
        p.add(cbKategori);

        JLabel lSupplier = new JLabel("Supplier");
        lSupplier.setBounds(780, 271, 200, 25);
        p.add(lSupplier);

        cbSupplierBarang = new JComboBox<>();
        cbSupplierBarang.setBounds(780, 306, 260, 30);
        p.add(cbSupplierBarang);


        cbKategori.addActionListener(e -> {
            cbSupplierBarang.removeAllItems();
            for (Supplier s : supplierManager.tampilkanSemuaSupplier()) {
                cbSupplierBarang.addItem(s);
            }
        });
        cbKategori.setSelectedIndex(0);

        JButton btnTambah = new JButton("Tambah Barang");
        btnTambah.setBounds(780, 358, 260, 40);
        p.add(btnTambah);
        
        hargaField = new JTextField();
        hargaField.setBounds(780, 177, 260, 19);
        p.add(hargaField);
        hargaField.setColumns(10);
        
        JLabel lblHarga = new JLabel("Harga");
        lblHarga.setBounds(780, 143, 200, 25);
        p.add(lblHarga);
        
        
        
        //Menambahkan barang berdasarkan ComboBox
        btnTambah.addActionListener(e -> {
            try {
                double harga = Double.parseDouble(hargaField.getText());

                BarangFactory factory =
                        cbKategori.getSelectedItem().equals("Elektronik")
                                ? new ElektronikFactory()
                                : new GroceryFactory();

                Barang b = factory.create(
                        0,
                        tfNama.getText(),
                        Integer.parseInt(tfStok.getText()),
                        harga,
                        cbSupplierBarang.getSelectedItem().toString()
                );

                BarangValidation.validate(b);

                inventory.tambahBarang(b);

                tableBarangModel.setData(
                        inventory.tampilkanSemuaBarang());

                // optional: reset field
                tfNama.setText("");
                tfStok.setText("");
                hargaField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Stok dan harga harus berupa angka",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);

            } catch (ValidationException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Validasi Gagal",
                        JOptionPane.WARNING_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Terjadi kesalahan saat menambah barang",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            
        });
        
        return p;
    }


    /* ======================= TAB CUSTOMER VIP ======================= */
    private JPanel tabCustomer() {
        JPanel p = new JPanel();
        p.setLayout(null);

        JTable table = new JTable(
                new TableCustomer(customerManager.tampilkanSemuaCustomer()));
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 10, 650, 520); 
        p.add(sp);

        
        JLabel lblNama = new JLabel("Nama Customer");
        lblNama.setBounds(700, 20, 200, 25);
        p.add(lblNama);

        JTextField tfNama = new JTextField();
        tfNama.setBounds(700, 45, 260, 30);
        p.add(tfNama);

        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(700, 85, 200, 25);
        p.add(lblAlamat);

        JTextField tfAlamat = new JTextField();
        tfAlamat.setBounds(700, 110, 260, 30);
        p.add(tfAlamat);

        JLabel lblHp = new JLabel("Nomor HP");
        lblHp.setBounds(700, 150, 200, 25);
        p.add(lblHp);

        JTextField tfHp = new JTextField();
        tfHp.setBounds(700, 175, 260, 30);
        p.add(tfHp);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(700, 215, 200, 25);
        p.add(lblEmail);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(700, 240, 260, 30);
        p.add(tfEmail);

        JButton btnTambah = new JButton("Tambah Customer VIP");
        btnTambah.setBounds(700, 280, 260, 40);
        p.add(btnTambah);
        
        JButton hapusButton = new JButton("Hapus Customer");
        hapusButton.setBounds(700, 330, 260, 40);
        p.add(hapusButton);
        
        //menghapus sebuah customer VIP
        hapusButton.addActionListener(e -> {
            try {
                int selectedRow = table.getSelectedRow();               
                if (selectedRow == -1) {
                    throw new ValidationException(
                            "Silakan pilih customer yang ingin dihapus");
                }

                TableCustomer model = (TableCustomer) table.getModel();
                Customer customer = model.getCustomerAt(selectedRow);

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Yakin ingin menghapus customer:\n" + customer.getNama(),
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }                
                customerManager.hapusCustomer(customer.getId());                
                table.setModel(new TableCustomer(
                        customerManager.tampilkanSemuaCustomer()));
                if (cbCustomer == null) return;

                cbCustomer.removeAllItems();
                for (Customer c : customerManager.tampilkanSemuaCustomer()) {
                    cbCustomer.addItem(c);
                }
                

                JOptionPane.showMessageDialog(
                        this,
                        "Customer berhasil dihapus",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (ValidationException ve) {
                
                JOptionPane.showMessageDialog(
                        this,
                        ve.getMessage(),
                        "Validasi Gagal",
                        JOptionPane.WARNING_MESSAGE
                );

            } catch (DatabaseException de) {               
                JOptionPane.showMessageDialog(
                        this,
                        "Gagal menghapus customer dari database.\n"
                                + de.getMessage(),
                        "Kesalahan Database",
                        JOptionPane.ERROR_MESSAGE
                );

            } catch (Exception ex) {                
                JOptionPane.showMessageDialog(
                        this,
                        "Terjadi kesalahan sistem.\n"
                                + "Silakan hubungi administrator.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });  
        //Menambah Pelanggan VIP
        btnTambah.addActionListener(e -> {
            try {
                Customer c = new CustomerBuilder()
                        .setNama(tfNama.getText())
                        .setAlamat(tfAlamat.getText())
                        .setHp(tfHp.getText())
                        .setEmail(tfEmail.getText())
                        .build();

                CustomerValidation.validate(c);
                customerManager.tambahCustomer(c);
                table.setModel(new TableCustomer(
                        customerManager.tampilkanSemuaCustomer()));
                if (cbCustomer == null) return;

                cbCustomer.removeAllItems();
                for (Customer cs : customerManager.tampilkanSemuaCustomer()) {
                    cbCustomer.addItem(cs);
                }
                
                
                
                

            } catch (ValidationException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        return p;
    }

    /* ======================= TAB TRANSAKSI ======================= */
    private JPanel tabTransaksi() {
        JPanel p = new JPanel(null);

        List<ItemTransaksi> cart = new ArrayList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        JScrollPane sp = new JScrollPane(list);
        sp.setBounds(10, 10, 750, 520);
        p.add(sp);

        cbCustomer =new JComboBox<>(customerManager
                        .tampilkanSemuaCustomer()
                        .toArray(new Customer[0]));
        cbCustomer.setBounds(780, 45, 260, 30);
        p.add(new JLabel("Customer VIP")).setBounds(780, 20, 200, 25);
        p.add(cbCustomer);

        JComboBox<String> cbKategori = new JComboBox<>(new String[]{"Elektronik", "Grocery"});
        cbKategori.setBounds(780, 110, 260, 30);
        p.add(new JLabel("Kategori")).setBounds(780, 85, 200, 25);
        p.add(cbKategori);

        JComboBox<Barang> cbBarang = new JComboBox<>();
        cbBarang.setBounds(780, 175, 260, 30);
        p.add(new JLabel("Barang")).setBounds(780, 150, 200, 25);
        p.add(cbBarang);

        JTextField tfJumlah = new JTextField();
        tfJumlah.setBounds(780, 240, 260, 30);
        p.add(new JLabel("Jumlah")).setBounds(780, 215, 200, 25);
        p.add(tfJumlah);

        JTextField tfTotal = new JTextField();
        tfTotal.setEditable(false);
        tfTotal.setBounds(780, 305, 260, 30);
        p.add(new JLabel("Total Item")).setBounds(780, 280, 200, 25);
        p.add(tfTotal);

        Runnable reloadBarang = () -> {
            cbBarang.removeAllItems();
            for (Barang b : inventory.tampilkanSemuaBarang()) {
                if (b.getKategori().equals(cbKategori.getSelectedItem())) {
                    cbBarang.addItem(b);
                }
            }
        };
        cbKategori.addActionListener(e -> reloadBarang.run());
        reloadBarang.run();

        JButton btnTambah = new JButton("Tambah Item");
        btnTambah.setBounds(780, 360, 260, 40);
        p.add(btnTambah);

        JButton btnHapus = new JButton("Hapus Item");
        btnHapus.setBounds(780, 410, 260, 40);
        p.add(btnHapus);

        JButton btnSimpan = new JButton("Simpan Transaksi");
        btnSimpan.setBounds(780, 460, 260, 40);
        p.add(btnSimpan);
        
        
        btnTambah.addActionListener(e -> {
            try {
                int j = Integer.parseInt(tfJumlah.getText());
                Barang b = (Barang) cbBarang.getSelectedItem();

                cart.add(new ItemTransaksi(b, j));
                listModel.addElement(b.getNama() + " x " + j);

                int totalItem = 0;
                for (ItemTransaksi it : cart) {
                    totalItem += it.getJumlah();
                }
                tfTotal.setText(String.valueOf(totalItem));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });


        btnHapus.addActionListener(e -> {
            int i = list.getSelectedIndex();
            if (i >= 0) {
                cart.remove(i);
                listModel.remove(i);

                int totalItem = 0;
                for (ItemTransaksi it : cart) {
                    totalItem += it.getJumlah();
                }
                tfTotal.setText(String.valueOf(totalItem));
            }
        });


        btnSimpan.addActionListener(e -> {
            try {
                TransaksiValidation.validate(cart);

                for (ItemTransaksi it : cart) {
                    inventory.kurangiStok(it.getBarang(), it.getJumlah());
                }

                tableBarangModel.setData(
                        inventory.tampilkanSemuaBarang());

                TransaksiBuilder builder = new TransaksiBuilder();
                cart.forEach(builder::tambahItem);

                transaksiManager.simpanTransaksi(
                        new Transaksi(0,
                                builder.build().getItems(),
                                Integer.parseInt(tfTotal.getText())));

                tableTransaksiModel.setData(
                        transaksiManager.tampilkanSemuaTransaksi());

                cart.clear();
                listModel.clear();
                tfTotal.setText("");

                JOptionPane.showMessageDialog(this, "Transaksi berhasil");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        return p;
    }

    /* ======================= TAB RIWAYAT ======================= */
    private JPanel tabRiwayat() {
        JPanel p = new JPanel(null);

        tableTransaksiModel =
                new TableTransaksi(
                        transaksiManager.tampilkanSemuaTransaksi());
        JTable table = new JTable(tableTransaksiModel);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 10, 1040, 520);
        p.add(sp);

        return p;
    }
    
    private void reloadSupplierComboBox() {
        if (cbSupplierBarang == null) return;

        cbSupplierBarang.removeAllItems();
        for (Supplier s : supplierManager.tampilkanSemuaSupplier()) {
            cbSupplierBarang.addItem(s);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
    
    
    


}
