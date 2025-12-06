package design.view;

import javax.swing.*;

import data.Constants;

import java.awt.*;

import design.view.components.ButtonComponent;
import design.view.components.PasswordField;
import design.view.components.TextField;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JButton btnForgotPassword;
    public JButton btnLogin;
    public JButton btnSignin;
    public JPasswordField txtPassword;
    public JTextField txtUserInfo;

    public LoginScreen() {

        setTitle("Bookly - Login");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUserInfo = new JLabel("DIGITE SEU E-MAIL OU CPF:");
        lblUserInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtUserInfo = new TextField("E-mail ou CPF");

        JLabel lblPassword = new JLabel("DIGITE SUA SENHA:");
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtPassword = new PasswordField("********");
       
        btnLogin = new ButtonComponent("ENTRAR");
        btnSignin = new ButtonComponent("CADASTRAR");

        btnForgotPassword = new JButton("ESQUECEU SUA SENHA?");
        btnForgotPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnForgotPassword.setFont(new Font("Excalifont", Font.PLAIN, 12));
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnForgotPassword.setBackground(Color.WHITE);

        loginPanel.add(Box.createVerticalGlue());
        loginPanel.add(lblUserInfo);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        loginPanel.add(txtUserInfo);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        loginPanel.add(lblPassword);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        loginPanel.add(txtPassword);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        loginPanel.add(btnLogin);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginPanel.add(btnSignin);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        loginPanel.add(btnForgotPassword);
        loginPanel.add(Box.createVerticalGlue());

        add(loginPanel);

    }
    
}
