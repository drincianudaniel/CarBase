package carbase.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import carbase.connection.LoginSession;
import carbase.connection.Logout;
import carbase.connection.MySQLConnection;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class MainWindow extends JFrame {

	
	//JPanels
	private JPanel contentPane;
	
	//JTextFiels
	private JTextField plateField;
	private JTextField manufacturerField;
	private JTextField modelField;
	private JTextField yearField;
	private static JTextField searchtxtField;
	private JTextField engineTypeField;
	private JTextField enginesizeField;
	private JTextField horsepowerField;
	private JTextField topspeedField;
	
	//JLabels
	private JLabel succesLabel = new JLabel("");
	
	//JTables
	static JTable table = new JTable();


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
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\carbase.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-11, 0, 1296, 72);
		panel.setBackground(new Color(50, 205, 50));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logged in as: ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(985, 25, 100, 31);
		panel.add(lblNewLabel);
		
		JLabel nicknamelbl = new JLabel("");
		nicknamelbl.setForeground(new Color(0, 0, 0));
		nicknamelbl.setFont(new Font("Calibri", Font.BOLD, 18));
		nicknamelbl.setBounds(1095, 25, 112, 31);
		panel.add(nicknamelbl);
		nicknamelbl.setText(LoginSession.Nickname);
		
		ImageIcon image = new ImageIcon(getImage("/carbase.png"));
		JLabel carbaselogo = new JLabel("");
		carbaselogo.setBounds(24, 0, 138, 87);
		carbaselogo.setIcon(image);
		panel.add(carbaselogo);
		
		ImageIcon image2 = new ImageIcon(getImage("/logout.png"));
		JLabel logoutlabel = new JLabel("");
		logoutlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoutActionlistener(e);
			}
		});
		logoutlabel.setBounds(1227, 14, 45, 45);
		logoutlabel.setIcon(image2);
		panel.add(logoutlabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-11, 72, 1296, 634);
		panel_1.setBackground(new Color(34, 139, 34));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		searchtxtField = new JTextField();
		searchtxtField.setBackground(Color.WHITE);
		searchtxtField.setBounds(1069, 11, 156, 20);
		panel_1.add(searchtxtField);
		searchtxtField.setColumns(10);
		
		ImageIcon image3 = new ImageIcon(getImage("/search.png"));
		JButton SearchBtn = new JButton("");
		SearchBtn.setIcon(image3);
		SearchBtn.setOpaque(false);
		SearchBtn.setContentAreaFilled(false);
		SearchBtn.setBorderPainted(false);
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchActionListener(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		SearchBtn.setBackground(Color.WHITE);
		SearchBtn.setBounds(1235, 6, 30, 30);
		panel_1.add(SearchBtn);
		
		JLabel lblSearchByPlate = new JLabel("Search by Plate");
		lblSearchByPlate.setForeground(Color.WHITE);
		lblSearchByPlate.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblSearchByPlate.setBounds(969, 16, 101, 14);
		panel_1.add(lblSearchByPlate);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(25, 41, 1240, 297);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("INSERT CAR");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(540, 39, 167, 38);
		panel_2.add(lblNewLabel_1);
		
		JLabel platelbl = new JLabel("Plate");
		platelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		platelbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		platelbl.setBounds(10, 86, 112, 25);
		panel_2.add(platelbl);
		
		plateField = new JTextField();
		plateField.setFont(new Font("Calibri", Font.PLAIN, 15));
		plateField.setBackground(Color.WHITE);
		plateField.setBounds(132, 84, 221, 25);
		panel_2.add(plateField);
		plateField.setColumns(10);
		
		manufacturerField = new JTextField();
		manufacturerField.setFont(new Font("Calibri", Font.PLAIN, 15));
		manufacturerField.setBackground(Color.WHITE);
		manufacturerField.setBounds(132, 129, 221, 25);
		panel_2.add(manufacturerField);
		manufacturerField.setColumns(10);
		
		JLabel Manufacturerlbl = new JLabel("Manufacturer");
		Manufacturerlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Manufacturerlbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		Manufacturerlbl.setBounds(10, 131, 112, 25);
		panel_2.add(Manufacturerlbl);
		
		modelField = new JTextField();
		modelField.setFont(new Font("Calibri", Font.PLAIN, 15));
		modelField.setBackground(Color.WHITE);
		modelField.setBounds(132, 175, 221, 25);
		panel_2.add(modelField);
		modelField.setColumns(10);
		
		JLabel modellbl = new JLabel("Model");
		modellbl.setHorizontalAlignment(SwingConstants.RIGHT);
		modellbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		modellbl.setBounds(10, 177, 112, 25);
		panel_2.add(modellbl);
		
		yearField = new JTextField();
		yearField.setFont(new Font("Calibri", Font.PLAIN, 15));
		yearField.setBackground(Color.WHITE);
		yearField.setBounds(132, 221, 221, 25);
		panel_2.add(yearField);
		yearField.setColumns(10);
		
		JLabel yearlbl = new JLabel("Year");
		yearlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		yearlbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		yearlbl.setBounds(10, 223, 112, 25);
		panel_2.add(yearlbl);
		
		engineTypeField = new JTextField();
		engineTypeField.setFont(new Font("Calibri", Font.PLAIN, 15));
		engineTypeField.setBackground(Color.WHITE);
		engineTypeField.setColumns(10);
		engineTypeField.setBounds(976, 84, 221, 25);
		panel_2.add(engineTypeField);
		
		enginesizeField = new JTextField();
		enginesizeField.setFont(new Font("Calibri", Font.PLAIN, 15));
		enginesizeField.setBackground(Color.WHITE);
		enginesizeField.setColumns(10);
		enginesizeField.setBounds(976, 129, 221, 25);
		panel_2.add(enginesizeField);
		
		horsepowerField = new JTextField();
		horsepowerField.setFont(new Font("Calibri", Font.PLAIN, 15));
		horsepowerField.setBackground(Color.WHITE);
		horsepowerField.setColumns(10);
		horsepowerField.setBounds(976, 175, 221, 25);
		panel_2.add(horsepowerField);
		
		topspeedField = new JTextField();
		topspeedField.setFont(new Font("Calibri", Font.PLAIN, 15));
		topspeedField.setBackground(Color.WHITE);
		topspeedField.setColumns(10);
		topspeedField.setBounds(976, 221, 221, 25);
		panel_2.add(topspeedField);
		
		JLabel enginetypelbl = new JLabel("Engine Type");
		enginetypelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		enginetypelbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		enginetypelbl.setBounds(854, 86, 112, 25);
		panel_2.add(enginetypelbl);
		
		JLabel enginesizelbl = new JLabel("Engine Size");
		enginesizelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		enginesizelbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		enginesizelbl.setBounds(854, 131, 112, 25);
		panel_2.add(enginesizelbl);
		
		JLabel horsepowerlbl = new JLabel("Horsepower");
		horsepowerlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		horsepowerlbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		horsepowerlbl.setBounds(854, 177, 112, 25);
		panel_2.add(horsepowerlbl);
		
		JLabel topspeedlbl = new JLabel("Top Speed");
		topspeedlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		topspeedlbl.setFont(new Font("Calibri", Font.PLAIN, 16));
		topspeedlbl.setBounds(854, 223, 112, 25);
		panel_2.add(topspeedlbl);
		
		JButton insertBtn = new JButton("INSERT");
		insertBtn.setForeground(Color.WHITE);
		insertBtn.setBackground(new Color(50, 205, 50));
		insertBtn.setVerticalAlignment(SwingConstants.TOP);
		insertBtn.setFont(new Font("Calibri", Font.PLAIN, 25));
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertActionListener(e);
					generateActionListener(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		insertBtn.setBounds(543, 249, 167, 35);
		panel_2.add(insertBtn);
		
		succesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		succesLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		succesLabel.setBounds(371, 254, 167, 25);
		panel_2.add(succesLabel);
		
		JButton generateBtn = new JButton("Generate Table");
		generateBtn.setForeground(Color.WHITE);
		generateBtn.setBackground(new Color(50, 205, 50));
		generateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generateActionListener(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		generateBtn.setVerticalAlignment(SwingConstants.TOP);
		generateBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
		generateBtn.setBounds(1030, 262, 167, 24);
		panel_2.add(generateBtn);
		
		JButton clearBtn = new JButton("CLEAR");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearActionListener(e);
			}
		});
		clearBtn.setVerticalAlignment(SwingConstants.TOP);
		clearBtn.setForeground(Color.WHITE);
		clearBtn.setFont(new Font("Calibri", Font.PLAIN, 13));
		clearBtn.setBackground(new Color(50, 205, 50));
		clearBtn.setBounds(712, 262, 74, 22);
		panel_2.add(clearBtn);
		
		ImageIcon wrench = new ImageIcon(getImage("/wrench.png"));
		JLabel wrenchlbl = new JLabel("");
		wrenchlbl.setIcon(wrench);
		wrenchlbl.setBounds(550, 88, 150, 150);
		panel_2.add(wrenchlbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 351, 1240, 238);
		panel_1.add(scrollPane);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		table.setDefaultEditor(Object.class, null);
	}
	
	private Image getImage(String filename) {
	    try {
	        return ImageIO.read(this.getClass().getResourceAsStream(filename));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	private void logoutActionlistener(MouseEvent e){
		LoginWindow loginWindow = new LoginWindow();
		Logout.logout(this, loginWindow);
	}
	
	private void insertActionListener(ActionEvent e){
		String adduserSQL = "INSERT INTO data(`Plate`, `Manufacturer`, `Model`, `Year`, `Engine Type`, `Engine Size`, `Horsepower`, `Top Speed`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String plate = plateField.getText();
		String manufacturer = manufacturerField.getText();
		String model = modelField.getText();
		String year = yearField.getText();
		String engineType = engineTypeField.getText();
		String engineSize = enginesizeField.getText();
		String horsepower = horsepowerField.getText();
		String topSpeed = topspeedField.getText();
			try {
				PreparedStatement psAdd = MySQLConnection.getConnection().prepareStatement(adduserSQL);
					psAdd.setString(1, plate);
					psAdd.setString(2, manufacturer);
					psAdd.setString(3, model);
					psAdd.setInt(4, Integer.parseInt(year));
					psAdd.setString(5, engineType);
					psAdd.setString(6, engineSize);
					psAdd.setInt(7, Integer.parseInt(horsepower));
					psAdd.setInt(8, Integer.parseInt(topSpeed));
					succesLabel.setText("Car inserted succesfully");
				    psAdd.executeUpdate();
				    psAdd.close();
				    
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
			} catch (Exception e1) {
						// TODO Auto-generated catch block
						succesLabel.setText("Wrong Input");
						e1.printStackTrace();
					}
		
		}
	
	private void generateActionListener(ActionEvent e) throws Exception{
		try {
			Statement stmt = MySQLConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * FROM data");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs = stmt.getResultSet();
			stmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void searchActionListener(ActionEvent E) throws Exception
	{
		new searchWindow().setVisible(true);
	}
	
	public static String getPlate()
	{
		String plate = searchtxtField.getText();
		return plate;
	}
	
	private void clearActionListener(ActionEvent e) {
		plateField.setText("");
		manufacturerField.setText("");
		modelField.setText("");
		yearField.setText("");
		engineTypeField.setText("");
		enginesizeField.setText("");
		horsepowerField.setText("");
		topspeedField.setText("");
		succesLabel.setText("");
	}
}
