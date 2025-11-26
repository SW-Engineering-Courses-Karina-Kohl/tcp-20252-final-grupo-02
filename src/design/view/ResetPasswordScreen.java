package design.view;

import javax.swing.*;

import data.Constants;

import java.awt.*;

import design.view.components.ButtonComponent;
import design.view.components.TextField;

public class ResetPasswordScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JButton btnChangePassword;
	public JTextField txtConfirmPassword;
	public JTextField txtPassword;
    
    public ResetPasswordScreen() {

    	setTitle("Bookly - Recuperação de senha");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel resetPasswordPanel = new JPanel();
        resetPasswordPanel.setLayout(new BoxLayout(resetPasswordPanel, BoxLayout.Y_AXIS));
        resetPasswordPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblPassword = new JLabel("DIGITE A NOVA SENHA:");
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtPassword = new TextField("*******");

        JLabel lblConfirmPassword = new JLabel("CONFIRME A NOVA SENHA:");
        lblConfirmPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtConfirmPassword = new TextField("*******");

        btnChangePassword = new ButtonComponent("TROCAR SENHA");

        resetPasswordPanel.add(Box.createVerticalGlue());
        resetPasswordPanel.add(lblPassword);
        resetPasswordPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPasswordPanel.add(txtPassword);
        resetPasswordPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPasswordPanel.add(lblConfirmPassword);
        resetPasswordPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPasswordPanel.add(txtConfirmPassword);
        resetPasswordPanel.add(Box.createRigidArea(new Dimension(0, 35)));
        resetPasswordPanel.add(btnChangePassword);
        resetPasswordPanel.add(Box.createVerticalGlue());

        add(resetPasswordPanel);
        
    }

}
