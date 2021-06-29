package carbase.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carbase.connection.LoginSession;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 205, 50));
		panel.setBounds(-11, 0, 1296, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logged in as");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(1039, 11, 100, 31);
		panel.add(lblNewLabel);
		
		JLabel nicknamelbl = new JLabel("");
		nicknamelbl.setForeground(new Color(255, 255, 255));
		nicknamelbl.setFont(new Font("Calibri", Font.PLAIN, 18));
		nicknamelbl.setBounds(1139, 11, 112, 31);
		panel.add(nicknamelbl);
		nicknamelbl.setText(LoginSession.Nickname);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 139, 34));
		panel_1.setBounds(-11, 75, 1296, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	}
}
