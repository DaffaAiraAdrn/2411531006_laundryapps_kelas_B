package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserRepo;
import model.User;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTable tableUsers;
	UserRepo usr = new UserRepo();
	List<User> ls;
	public String id;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(214, 60, 469, 38);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(214, 129, 469, 38);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(214, 198, 469, 38);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(61, 60, 87, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(61, 129, 87, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(61, 198, 87, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setNama(txtName.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				usr.save(user);
				reset();
				
			}
		});
		btnSave.setBounds(214, 266, 108, 29);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(332, 266, 105, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(447, 266, 104, 29);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(561, 266, 122, 31);
		contentPane.add(btnCancel);
		
		tableUsers = new JTable();
		tableUsers.setBounds(10, 333, 727, 230);
		contentPane.add(tableUsers);
		
		
		
		
	}
	public void reset() {
		txtName.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
	}
	
}
