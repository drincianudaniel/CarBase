package carbase.connection;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Operations {
	public static boolean isLogin(String username, String password, JFrame frame)
	{
		try {
			Connection myConn = MySQLConnection.getConnection();
			String mySqlQuery = "SELECT UID, Nickname from login where Username = '" + username + "' AND Password = '" + password + "'";
			PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				LoginSession.UID  = resultSet.getInt("UID");
				LoginSession.Nickname = resultSet.getString("Nickname");
				
				return true;
			}
		}catch (Exception exception)
		{
			JOptionPane.showMessageDialog(frame, "Database error: " + exception.getMessage());
		}
		
		return false;
		
	}
}
