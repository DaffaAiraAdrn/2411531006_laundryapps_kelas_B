package ui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import error1.ValidationException1;
import model.User;
import service1.LoginService;
import util1.ValidationUtil1;

import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame1 frame = new LoginFrame1();
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
	public LoginFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry Apps");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(85, 39, 217, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblMalesAjaNyuci = new JLabel("Males Aja Nyuci, biar kami cuciin");
		lblMalesAjaNyuci.setFont(new Font("MS UI Gothic", Font.BOLD, 15));
		lblMalesAjaNyuci.setBounds(85, 78, 342, 43);
		contentPane.add(lblMalesAjaNyuci);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("MS UI Gothic", Font.BOLD, 12));
		lblUsername.setBounds(85, 114, 91, 43);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("MS UI Gothic", Font.BOLD, 12));
		lblPassword.setBounds(85, 206, 91, 35);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(85, 151, 237, 45);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(85, 251, 237, 45);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userValue = txtUsername.getText();
				String passValue = txtPassword.getText();
				
				User user = new User(userValue, passValue);
				
				try {
					ValidationUtil1.validate(user);
					LoginService loginService = new LoginService();
					if(loginService.authenticate(user)) {
						System.out.println("Login successfull !");
						new MainFrame().setVisible(true);
						dispose();
					}	
					else {
						System.out.println("Invalid username or password.");
						JOptionPane.showMessageDialog(null, "Login gagal, Invalid username or password");
					}
				}catch(ValidationException1 | NullPointerException exception) {
					System.out.println("Data tidak valid : " + exception.getMessage());
					JOptionPane.showMessageDialog(null, "Login Gagal: " + exception.getMessage());
					
				}finally {
					System.out.println("Selalu dieksekusi");
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(192, 192, 192));
		btnLogin.setBounds(85, 326, 237, 43);
		contentPane.add(btnLogin);
		
			
		
	}
}
