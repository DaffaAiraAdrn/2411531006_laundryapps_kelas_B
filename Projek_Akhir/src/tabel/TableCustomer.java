package tabel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Customer;

public class TableCustomer extends AbstractTableModel {

    private List<Customer> list;
    private final String[] columnNames = {
            "ID", "Nama", "Email", "Alamat", "HP"
    };//representasi tabel

    public TableCustomer(List<Customer> list) {
        this.list = list;
    }

    public void setData(List<Customer> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public Customer getCustomerAt(int row) {
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
        Customer c = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> c.getId();
            case 1 -> c.getNama();
            case 2 -> c.getEmail();
            case 3 -> c.getAlamat();
            case 4 -> c.getHp();
            default -> null;
        };
    }
}
