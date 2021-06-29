package carbase.connection;

import javax.swing.JFrame;

import carbase.ui.LoginWindow;

public class Logout {
	public static void logout(JFrame context, LoginWindow loginScreen) {
		LoginSession.isLoggedIn = false;
		context.setVisible(false);
		loginScreen.setVisible(true);
	}
		
}
