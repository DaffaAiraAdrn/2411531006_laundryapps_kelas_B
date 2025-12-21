package tabel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Supplier;

public class TableSupplier extends AbstractTableModel {

    private List<Supplier> list;
    private final String[] columnNames = {
            "ID", "Nama", "Alamat", "Telepon", "Email"
    };//representasi tabel

    public TableSupplier(List<Supplier> list) {
        this.list = list;
    }

    public void setData(List<Supplier> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public Supplier getSupplierAt(int row) {
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
        Supplier s = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> s.getId();
            case 1 -> s.getNama();
            case 2 -> s.getAlamat();
            case 3 -> s.getTelepon();
            case 4 -> s.getEmail();
            default -> null;
        };
    }
}
