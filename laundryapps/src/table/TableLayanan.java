package table;

import Tugas.Service;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableLayanan extends AbstractTableModel {
    private List<Service> list;
    private String[] column = {"ID", "Nama Layanan", "Harga"};

    public TableLayanan(List<Service> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() { return list.size(); }

    @Override
    public int getColumnCount() { return column.length; }

    @Override
    public String getColumnName(int col) { return column[col]; }

    @Override
    public Object getValueAt(int row, int col) {
        Service l = list.get(row);
        switch (col) {
            case 0: return l.getId();
            case 1: return l.getJenis();
            case 2: return l.getHarga();
            case 3: return l.getStatus();
            default: return null;
        }
    }
}