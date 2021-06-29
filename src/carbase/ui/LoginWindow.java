package carbase.ui;
import carbase.connection.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.Mysqlx.Error;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField username_textField;
	private JTextField password_textField;
	
	JLabel errorLabel = new JLabel("");
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
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
	public LoginWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 274);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username_textField = new JTextField();
		username_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				username_textField.setText("");
			}
		});
		username_textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		username_textField.setBackground(SystemColor.control);
		username_textField.setHorizontalAlignment(SwingConstants.CENTER);
		username_textField.setText("Username");
		username_textField.setBounds(46, 97, 168, 32);
		contentPane.add(username_textField);
		username_textField.setColumns(10);
		
		password_textField = new JTextField();
		password_textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				password_textField.setText("");
			}
		});
		password_textField.setHorizontalAlignment(SwingConstants.CENTER);
		password_textField.setText("Password");
		password_textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		password_textField.setBackground(SystemColor.control);
		password_textField.setBounds(46, 140, 168, 32);
		contentPane.add(password_textField);
		password_textField.setColumns(10);
		
		JButton Login_btn = new JButton("Log In");
		Login_btn.setFont(new Font("Calibri", Font.PLAIN, 14));
		Login_btn.setBackground(new Color(50, 205, 50));
		Login_btn.setForeground(Color.WHITE);
		Login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Login_btnActionPerformed(evt);
			}
		});
		Login_btn.setBounds(85, 183, 89, 26);
		contentPane.add(Login_btn);
		
		
		errorLabel.setBounds(46, 220, 168, 14);
		contentPane.add(errorLabel);
		
		lblNewLabel_1 = new JLabel("Click to create one!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createAccountActionPerformed(e);
			}
		});
		lblNewLabel_1.setFont(new Font("Calibri", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(58, 68, 143, 18);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Don't have an account?");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(58, 44, 156, 30);
		contentPane.add(lblNewLabel_2);
		
		ImageIcon image = new ImageIcon(getImage("/carbase.png"));
		JLabel carbaselbl = new JLabel("");
		carbaselbl.setIcon(image);
		carbaselbl.setBounds(81, -14, 106, 62);
		contentPane.add(carbaselbl);
	}
	
	private void Login_btnActionPerformed(ActionEvent evt)
	{
		Operations operations = new Operations();
		
		try {
			String usernameStr = username_textField.getText();
			String passwordStr = password_textField.getText();
		
			
			if(operations.isLogin(usernameStr, passwordStr, this))
			{
				new MainWindow().setVisible(true);
				this.dispose();
			}else {
				errorLabel.setText("Wrong username or password");
			}
		}catch (Exception exception)
		{					
			errorLabel.setText("Wrong username or password");
		}
	}
	
	private void createAccountActionPerformed(MouseEvent e)
	{
		new NewAccountWindow().setVisible(true);
		this.dispose();
	}
	
	private Image getImage(String filename) {
	    try {
	        return ImageIO.read(this.getClass().getResourceAsStream(filename));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
