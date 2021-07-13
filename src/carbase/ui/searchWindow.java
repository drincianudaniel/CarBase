package carbase.ui;
import carbase.connection.MySQLConnection;
import carbase.ui.*;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class searchWindow extends JFrame {

	
	//JPanel
	private JPanel pane;
	
	//JLabel
	JLabel platelbl = new JLabel("NOT FOUND");
	private JLabel manufacturerlbl;
	private JLabel modellbl;
	private JLabel yearlbl;
	private JLabel enginetypelbl;
	private JLabel enginesizelbl;
	private JLabel lblHorsepower;
	private JLabel lblTopSpeed;
	private JLabel succeslbl;
	
	//JTextField
	private JTextField manufacturerField;
	private JTextField modelField;
	private JTextField enginetypeField;
	private JTextField enginesizeField;
	private JTextField horsepowerField;
	private JTextField yearField;
	private JTextField topspeedField;
	
	
	//JButton
	private JButton btnConfirmEdit;
	private JButton btnDelete;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchWindow frame = new searchWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public searchWindow() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\carbase.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 489);
		pane = new JPanel();
		pane.setBackground(Color.WHITE);
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);
		platelbl.setHorizontalAlignment(SwingConstants.CENTER);
		platelbl.setFont(new Font("Calibri", Font.PLAIN, 50));
		
		platelbl.setBounds(10, 20, 322, 66);
		pane.add(platelbl);
		
		ImageIcon image = new ImageIcon(getImage("/carplate.png"));

		JLabel carplateimg = new JLabel("");
		carplateimg.setBounds(10, 11, 322, 66);
		carplateimg.setIcon(image);
		pane.add(carplateimg);
		
		manufacturerField = new JTextField();
		manufacturerField.setEditable(false);
		manufacturerField.setHorizontalAlignment(SwingConstants.CENTER);
		manufacturerField.setText("null");
		manufacturerField.setFont(new Font("Calibri", Font.PLAIN, 16));
		manufacturerField.setBounds(9, 129, 155, 26);
		pane.add(manufacturerField);
		manufacturerField.setColumns(10);
		
		modelField = new JTextField("null");
		modelField.setEditable(false);
		modelField.setHorizontalAlignment(SwingConstants.CENTER);
		modelField.setBounds(175, 129, 155, 26);
		modelField.setFont(new Font("Calibri", Font.PLAIN, 16));
		pane.add(modelField);
		modelField.setColumns(10);
		
		enginetypeField = new JTextField("null");
		enginetypeField.setEditable(false);
		enginetypeField.setHorizontalAlignment(SwingConstants.CENTER);
		enginetypeField.setFont(new Font("Calibri", Font.PLAIN, 16));
		enginetypeField.setBounds(10, 227, 155, 26);
		pane.add(enginetypeField);
		enginetypeField.setColumns(10);
		
		enginesizeField = new JTextField("null");
		enginesizeField.setEditable(false);
		enginesizeField.setHorizontalAlignment(SwingConstants.CENTER);
		enginesizeField.setFont(new Font("Calibri", Font.PLAIN, 16));
		enginesizeField.setBounds(177, 227, 155, 26);
		pane.add(enginesizeField);
		enginesizeField.setColumns(10);
		
		horsepowerField = new JTextField("null");
		horsepowerField.setEditable(false);
		horsepowerField.setHorizontalAlignment(SwingConstants.CENTER);
		horsepowerField.setFont(new Font("Calibri", Font.PLAIN, 16));
		horsepowerField.setBounds(91, 282, 155, 26);
		pane.add(horsepowerField);
		horsepowerField.setColumns(10);
		
		yearField = new JTextField("null");
		yearField.setEditable(false);
		yearField.setHorizontalAlignment(SwingConstants.CENTER);
		yearField.setFont(new Font("Calibri", Font.PLAIN, 16));
		yearField.setBounds(91, 178, 155, 26);
		pane.add(yearField);
		yearField.setColumns(10);
		
		topspeedField = new JTextField("null");
		topspeedField.setEditable(false);
		topspeedField.setHorizontalAlignment(SwingConstants.CENTER);
		topspeedField.setFont(new Font("Calibri", Font.PLAIN, 16));
		topspeedField.setBounds(91, 332, 155, 26);
		pane.add(topspeedField);
		topspeedField.setColumns(10);
		
		manufacturerlbl = new JLabel("Manufacturer");
		manufacturerlbl.setFont(new Font("Calibri", Font.BOLD, 17));
		manufacturerlbl.setHorizontalAlignment(SwingConstants.CENTER);
		manufacturerlbl.setBounds(10, 105, 154, 16);
		pane.add(manufacturerlbl);
		
		modellbl = new JLabel("Model");
		modellbl.setFont(new Font("Calibri", Font.BOLD, 17));
		modellbl.setBounds(231, 105, 46, 14);
		pane.add(modellbl);
		
		yearlbl = new JLabel("Year");
		yearlbl.setHorizontalAlignment(SwingConstants.CENTER);
		yearlbl.setFont(new Font("Calibri", Font.BOLD, 17));
		yearlbl.setBounds(91, 161, 154, 16);
		pane.add(yearlbl);
		
		enginetypelbl = new JLabel("Engine Type");
		enginetypelbl.setHorizontalAlignment(SwingConstants.CENTER);
		enginetypelbl.setFont(new Font("Calibri", Font.BOLD, 17));
		enginetypelbl.setBounds(9, 210, 154, 16);
		pane.add(enginetypelbl);
		
		enginesizelbl = new JLabel("Engine Size");
		enginesizelbl.setHorizontalAlignment(SwingConstants.CENTER);
		enginesizelbl.setFont(new Font("Calibri", Font.BOLD, 17));
		enginesizelbl.setBounds(175, 210, 154, 16);
		pane.add(enginesizelbl);
		
		lblHorsepower = new JLabel("Horsepower");
		lblHorsepower.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorsepower.setFont(new Font("Calibri", Font.BOLD, 17));
		lblHorsepower.setBounds(91, 264, 154, 16);
		pane.add(lblHorsepower);
		
		lblTopSpeed = new JLabel("Top Speed");
		lblTopSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopSpeed.setFont(new Font("Calibri", Font.BOLD, 17));
		lblTopSpeed.setBounds(91, 317, 154, 16);
		pane.add(lblTopSpeed);
		
		JButton clearBtn = new JButton("EDIT");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editbtnActionListener(e);
			}
		});
		clearBtn.setVerticalAlignment(SwingConstants.TOP);
		clearBtn.setForeground(Color.WHITE);
		clearBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
		clearBtn.setBackground(new Color(50, 205, 50));
		clearBtn.setBounds(10, 375, 100, 26);
		pane.add(clearBtn);
		
		btnConfirmEdit = new JButton("CONFIRM EDIT");
		btnConfirmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmeditbtnActionListener(e);
			}
		});
		btnConfirmEdit.setVerticalAlignment(SwingConstants.TOP);
		btnConfirmEdit.setForeground(Color.WHITE);
		btnConfirmEdit.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnConfirmEdit.setBackground(new Color(50, 205, 50));
		btnConfirmEdit.setBounds(10, 413, 139, 26);
		pane.add(btnConfirmEdit);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deletetbnActionlistener(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setVerticalAlignment(SwingConstants.TOP);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnDelete.setBackground(new Color(50, 205, 50));
		btnDelete.setBounds(231, 375, 100, 26);
		pane.add(btnDelete);
		
		succeslbl = new JLabel("");
		succeslbl.setForeground(new Color(0, 255, 127));
		succeslbl.setHorizontalAlignment(SwingConstants.CENTER);
		succeslbl.setFont(new Font("Calibri", Font.BOLD, 17));
		succeslbl.setBounds(159, 418, 170, 16);
		pane.add(succeslbl);
		
		runSearch();
	}
	
	private void runSearch() {
		String selectSQL = "SELECT `Plate`, `Manufacturer`, `Model`, `Year`, `Engine Type`, `Engine Size`, `Horsepower`, `Top Speed` FROM data WHERE Plate = ?";
		String Plate = MainWindow.getPlate();
		try {
			
			PreparedStatement ps2 = MySQLConnection.getConnection().prepareStatement(selectSQL);
			ps2.setString(1, Plate);
			ResultSet rs = ps2.executeQuery();
			rs.next();
			String plate1 =rs.getString("Plate");
			String manufacturer = rs.getString("Manufacturer");
			String model = rs.getString("Model");
			int year = rs.getInt("Year");
			String enginetype = rs.getString("Engine Type");
			String enginesize = rs.getString("Engine Size");
			int horsepower = rs.getInt("Horsepower");
			int topspeed = rs.getInt("Top Speed");
			platelbl.setText(plate1);
			manufacturerField.setText(manufacturer);
			modelField.setText(model);
			yearField.setText(Integer.toString(year));
			enginetypeField.setText(enginetype);
			enginesizeField.setText(enginesize);
			horsepowerField.setText(Integer.toString(horsepower));
			topspeedField.setText(Integer.toString(topspeed));
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, "CAR Not Found");
			this.dispose();
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Image getImage(String filename) {
	    try {
	        return ImageIO.read(this.getClass().getResourceAsStream(filename));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	private void editbtnActionListener(ActionEvent e)
	{
		manufacturerField.setEditable(true);
		modelField.setEditable(true);
		yearField.setEditable(true);
		enginetypeField.setEditable(true);
		enginesizeField.setEditable(true);
		horsepowerField.setEditable(true);
		topspeedField.setEditable(true);
	}
	
	private void confirmeditbtnActionListener(ActionEvent e)
	{
		String editQuery = "UPDATE data set `Manufacturer` = ?, `Model` = ?, `Year` = ?, `Engine Type` = ?, `Engine Size` = ?, `Horsepower` = ?, `Top Speed` = ? where Plate = ?";
		try {
			PreparedStatement ps3 = MySQLConnection.getConnection().prepareStatement(editQuery);
			ps3.setString(1, manufacturerField.getText());
			ps3.setString(2, modelField.getText());
			ps3.setInt(3, Integer.parseInt(yearField.getText()));
			ps3.setString(4, enginetypeField.getText());
			ps3.setString(5, enginesizeField.getText());
			ps3.setInt(6, Integer.parseInt(horsepowerField.getText()));
			ps3.setInt(7, Integer.parseInt(topspeedField.getText()));
			ps3.setString(8, platelbl.getText());
			ps3.executeUpdate();
			
			manufacturerField.setEditable(false);
			modelField.setEditable(false);
			yearField.setEditable(false);
			enginetypeField.setEditable(false);
			enginesizeField.setEditable(false);
			horsepowerField.setEditable(false);
			topspeedField.setEditable(false);
			
			succeslbl.setText("Edited succesfully");
			ps3.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void deletetbnActionlistener(ActionEvent e)
	{
		try {
			PreparedStatement ps4 = MySQLConnection.getConnection().prepareStatement("delete from data where Plate = ?");
	        ps4.setString(1, platelbl.getText());
	        ps4.executeUpdate();
	        succeslbl.setText("Deleted succesfully");
	        ps4.close();
	       
		} catch (SQLException e1) {
			succeslbl.setText("Error occured");
			succeslbl.setForeground(new Color(255, 0, 0));
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			succeslbl.setText("Error occured");
			succeslbl.setForeground(new Color(255, 0, 0));
			e1.printStackTrace();
		}
	}
}
