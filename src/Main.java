import design.view.LoginScreen;
import javax.swing.SwingUtilities;

import Control.LoginController;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LoginScreen loginScreen = new LoginScreen();
			LoginController loginController = new LoginController(loginScreen);
			loginScreen.setVisible(true);
		});
	}

}
