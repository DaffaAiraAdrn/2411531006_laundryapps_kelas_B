package tabel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Barang;

public class TableBarang extends AbstractTableModel {

    private List<Barang> list;
    private final String[] columnNames = {
            "ID", "Nama", "Stok", "Harga", "Kategori", "Supplier"
    };//representasi tabel

    public TableBarang(List<Barang> list) {
        this.list = list;
    }

    public void setData(List<Barang> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public Barang getBarangAt(int row) {
        return list.get(row);
    }

    @Override
    public int getRowCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Barang b = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> b.getId();
            case 1 -> b.getNama();
            case 2 -> b.getStok();
            case 3 -> b.getHarga();
            case 4 -> b.getKategori();
            case 5 -> b.getSupplier();
            default -> null;
        };
    }
}
