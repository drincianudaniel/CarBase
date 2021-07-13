package carbase.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carbase.connection.MySQLConnection;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class NewAccountWindow extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField NicknameField;
	private JTextField passwordField;
	JLabel errorLbl = new JLabel("");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccountWindow frame = new NewAccountWindow();
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
	public NewAccountWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\carbase.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 260);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernamelbl = new JLabel("Username");
		usernamelbl.setFont(new Font("Calibri", Font.PLAIN, 15));
		usernamelbl.setBounds(10, 66, 74, 34);
		contentPane.add(usernamelbl);
		
		JLabel Nicknamelbl = new JLabel("Nickname");
		Nicknamelbl.setFont(new Font("Calibri", Font.PLAIN, 15));
		Nicknamelbl.setBounds(10, 119, 74, 14);
		contentPane.add(Nicknamelbl);
		
		JLabel Passwordlbl = new JLabel("Password");
		Passwordlbl.setFont(new Font("Calibri", Font.PLAIN, 15));
		Passwordlbl.setBounds(10, 164, 74, 14);
		contentPane.add(Passwordlbl);
		
		ImageIcon image = new ImageIcon(getImage("/back.png"));
		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backBtnActionListener(e);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setBackground(Color.WHITE);
		backBtn.setIcon(image);
		backBtn.setBounds(10, 20, 35, 35);
		contentPane.add(backBtn);
		
		usernameField = new JTextField();
		usernameField.setBackground(SystemColor.control);
		usernameField.setBounds(10, 91, 180, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		NicknameField = new JTextField();
		NicknameField.setBackground(SystemColor.control);
		NicknameField.setBounds(10, 133, 180, 20);
		contentPane.add(NicknameField);
		NicknameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBackground(SystemColor.control);
		passwordField.setBounds(10, 179, 180, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CreateBtnActionListener(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBounds(101, 20, 88, 35);
		contentPane.add(btnNewButton);
		errorLbl.setFont(new Font("Calibri", Font.PLAIN, 12));
		errorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		errorLbl.setBounds(10, 206, 180, 14);
		contentPane.add(errorLbl);
	}
	
	private Image getImage(String filename) {
	    try {
	        return ImageIO.read(this.getClass().getResourceAsStream(filename));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	private void backBtnActionListener(ActionEvent e)
	{
		new LoginWindow().setVisible(true);
		this.dispose();
	}
	
	private void CreateBtnActionListener(ActionEvent e) throws Exception
	{
		String adduserSQL = "INSERT INTO login(`Username`, `Nickname`, `Password`) VALUES (?, ?, ?)";
		String username = usernameField.getText();
		String nickname = NicknameField.getText();
		String password = passwordField.getText();
			try {
				PreparedStatement psAdd = MySQLConnection.getConnection().prepareStatement(adduserSQL);
					psAdd.setString(1, usernameField.getText().toString());
					psAdd.setString(2, NicknameField.getText().toString());
					psAdd.setString(3, passwordField.getText().toString());
					errorLbl.setText("Account created succesfully");
				    psAdd.executeUpdate();
				    
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
			}
	
	}
		
		
	
}
