package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.*;
import model.Customer;
import model.CustomerBuilder;
import java.util.*;
import table.TableCustomer;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class CustomerFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public String id;
    List<Customer> ls;
    

    CustomerRepo customerRepo = CustomerRepo.getInstance();

    private JTextField txtCustomerName;
    private JTextField txtCustomerAddress;
    private JTextField txtCustomerPhone;
    private JTextField txtCustomerEmail;
    private JTable tableCustomers;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerFrame frame = new CustomerFrame();
                    frame.setVisible(true);
                    frame.loadTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CustomerFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 502, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Pelanggan");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setBounds(178, 10, 123, 40);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nama");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(41, 54, 65, 22);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Alamat");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(41, 104, 65, 22);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("No Hp");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_2.setBounds(41, 161, 65, 22);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Email");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3.setBounds(41, 207, 65, 22);
        contentPane.add(lblNewLabel_1_3);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(131, 59, 263, 22);
        contentPane.add(txtCustomerName);
        txtCustomerName.setColumns(10);

        txtCustomerAddress = new JTextField();
        txtCustomerAddress.setColumns(10);
        txtCustomerAddress.setBounds(131, 109, 263, 22);
        contentPane.add(txtCustomerAddress);

        txtCustomerPhone = new JTextField();
        txtCustomerPhone.setColumns(10);
        txtCustomerPhone.setBounds(131, 161, 263, 22);
        contentPane.add(txtCustomerPhone);

        txtCustomerEmail = new JTextField();
        txtCustomerEmail.setColumns(10);
        txtCustomerEmail.setBounds(131, 207, 263, 22);
        contentPane.add(txtCustomerEmail);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 280, 468, 114);
        contentPane.add(scrollPane);

        tableCustomers = new JTable();
        scrollPane.setViewportView(tableCustomers);

        tableCustomers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableCustomers.getSelectedRow();
                if (row != -1) {
                    id = tableCustomers.getValueAt(row, 0).toString();
                    txtCustomerName.setText(tableCustomers.getValueAt(row, 1).toString());
                    txtCustomerEmail.setText(tableCustomers.getValueAt(row, 2).toString());
                    txtCustomerAddress.setText(tableCustomers.getValueAt(row, 3).toString());
                    txtCustomerPhone.setText(tableCustomers.getValueAt(row, 4).toString());
                }
            }
        });

        
        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Customer customer = new CustomerBuilder()
                        .setNama(txtCustomerName.getText())
                        .setAlamat(txtCustomerAddress.getText())
                        .setHp(txtCustomerPhone.getText())
                        .setEmail(txtCustomerEmail.getText())
                        .build();
                customerRepo.save(customer);
                reset();
                loadTable();
            }
        });
        btnSimpan.setBounds(130, 250, 85, 21);
        contentPane.add(btnSimpan);

        
        JButton btnUpdate = new JButton("Ubah");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (id == null) {
                    JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!");
                    return;
                }

                Customer customer = new CustomerBuilder()
                        .setId(id)
                        .setNama(txtCustomerName.getText())
                        .setAlamat(txtCustomerAddress.getText())
                        .setHp(txtCustomerPhone.getText())
                        .setEmail(txtCustomerEmail.getText())
                        .build();

                customerRepo.update(customer);
                reset();
                loadTable();
            }
        });
        btnUpdate.setBounds(230, 250, 85, 21);
        contentPane.add(btnUpdate);

       
        JButton btnDelete = new JButton("Hapus");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (id == null) {
                    JOptionPane.showMessageDialog(null, "Pilih data untuk dihapus!");
                    return;
                }

                customerRepo.delete(id);
                reset();
                loadTable();
                id = null;
            }
        });
        btnDelete.setBounds(330, 250, 85, 21);
        contentPane.add(btnDelete);

        
        JButton btnReset = new JButton("Batal");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
                id = null;
            }
        });
        btnReset.setBounds(20, 250, 85, 21);
        contentPane.add(btnReset);
    }

    public void loadTable() {
        ls = customerRepo.show();
        TableCustomer tc = new TableCustomer(ls);
        tableCustomers.setModel(tc);
        tableCustomers.getTableHeader().setVisible(true);
    }

    public void reset() {
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerPhone.setText("");
        txtCustomerEmail.setText("");
    }
}
