package Control;

import design.view.LoginScreen;
import javax.swing.JOptionPane;

public class LoginController {
    private LoginScreen loginScreen;

    public LoginController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        initController();
    }

    private void initController() {
        loginScreen.btnEntrar.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String emailCpf = loginScreen.txtEmailCpf.getText();
        String senha = new String(loginScreen.txtSenha.getPassword());

        if (authenticateUser(emailCpf, senha)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private boolean authenticateUser(String emailCpf, String senha) {
        if (emailCpf.equals("admin@email.com") && senha.equals("12345")) {
            JOptionPane.showMessageDialog(loginScreen, "Login successful!");
            loginScreen.dispose();
            return true;
        }else{
            JOptionPane.showMessageDialog(loginScreen, "Invalid credentials.");
            return false;
        }
    }
}
