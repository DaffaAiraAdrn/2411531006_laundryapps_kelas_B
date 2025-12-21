package tabel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Transaksi;

public class TableTransaksi extends AbstractTableModel {

    private List<Transaksi> list;
    private final String[] columnNames = {
            "ID Transaksi", "Total"
    };//representasi tabel

    public TableTransaksi(List<Transaksi> list) {
        this.list = list;
    }

    public void setData(List<Transaksi> list) {
        this.list = list;
        fireTableDataChanged();//method agar actionListener mengupdate JTable  
    }

    public Transaksi getTransaksiAt(int row) {
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
        Transaksi t = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> t.getIdTransaksi(); //mengambil data pada tabel Jtable berdasarkan index 
            case 1 -> t.getTotal();
            default -> null;
        };
    }
}
