package Tugas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class downloadManagerApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					downloadManagerApp frame = new downloadManagerApp();
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
	public downloadManagerApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Download Manager APP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(211, 66, 280, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("File 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(51, 177, 75, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("File 2");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(51, 227, 75, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("File 3");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(51, 280, 75, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(140, 177, 383, 22);
		contentPane.add(progressBar);		
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);

		

		

		JProgressBar progressBar2 = new JProgressBar();
		progressBar2.setBounds(140, 227, 383, 22);
		contentPane.add(progressBar2);
		progressBar2.setMinimum(0);
		progressBar2.setMaximum(100);
		progressBar2.setStringPainted(true);
		
		JProgressBar progressBar3 = new JProgressBar();
		progressBar3.setBounds(140, 280, 383, 22);
		contentPane.add(progressBar3);
		progressBar3.setMinimum(0);
		progressBar3.setMaximum(100);
		progressBar3.setStringPainted(true);
		
		JButton DownloadButton = new JButton("Download");
		DownloadButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DownloadButton.setBounds(438, 356, 111, 33);
		contentPane.add(DownloadButton);
		java.util.List<String> finishOrder = java.util.Collections.synchronizedList(new java.util.ArrayList<>());
		DownloadButton.addActionListener(e -> {
		    DownloadButton.setText("Downloading...");
		    DownloadButton.setEnabled(false);

		    Thread t1 = new Thread(() -> {
		        for (int i = 0; i <= 100; i += 5) {
		            int progress = i;
		            SwingUtilities.invokeLater(() -> progressBar.setValue(progress));

		            try { Thread.sleep(500); 
		            } 
		            catch (InterruptedException ex) {
		            	
		            }
		            

		        }
		        finishOrder.add("File 1");
		    });
		    
		    Thread t2 = new Thread(() -> {
		        for (int i = 0; i <= 100; i += 5) {
		            int progress = i;
		            SwingUtilities.invokeLater(() -> progressBar2.setValue(progress));

		            try { Thread.sleep(500); 
		            } 
		            catch (InterruptedException ex) {
		            	
		            }

		        }
		        finishOrder.add("File 2");
		    });

		  
		    Thread t3 = new Thread(() -> {
		        for (int i = 0; i <= 100; i += 5) {
		            int progress = i;
		            SwingUtilities.invokeLater(() -> progressBar3.setValue(progress));

		            try { Thread.sleep(500); } catch (InterruptedException ex) {
		            	
		            	
		            }
		            
		        }
		        finishOrder.add("File 3");

		    });
		    Thread monitor = new Thread(() -> {
		        try {
		            t1.join();
		            t2.join();
		            t3.join();
		        } catch (InterruptedException ex) {}

		       
		        SwingUtilities.invokeLater(() -> {
		        	
		            DownloadButton.setText("Download");
		            DownloadButton.setEnabled(true);
		            JOptionPane.showMessageDialog(null,
		                    "Urutan selesai:\n" +
		                    "1. " + finishOrder.get(0) + "\n" +
		                    "2. " + finishOrder.get(1) + "\n" +
		                    "3. " + finishOrder.get(2) + "\n" +
		                    "Semua file berhasil di download");
		            		
		        });
		    });
		    t1.start();
		    t2.start();
		    t3.start();
		    monitor.start();
		});




	}
}	
		


	

    


