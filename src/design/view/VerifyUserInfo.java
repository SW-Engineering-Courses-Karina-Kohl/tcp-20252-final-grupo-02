package design.view;

import javax.swing.*;

import data.Constants;

import java.awt.*;

import design.view.components.ButtonComponent;
import design.view.components.TextField;

public class VerifyUserInfo extends JFrame {
	
	private static final long serialVersionUID = 1L;

    public JButton btnVerifyUserInfo;
    public JTextField txtUserInfo;

    public VerifyUserInfo() {

        setTitle("Bookly - Recuperação de senha");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel resetPasswordPanel = new JPanel();
        resetPasswordPanel.setLayout(new BoxLayout(resetPasswordPanel, BoxLayout.Y_AXIS));
        resetPasswordPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JLabel lblUserInfo = new JLabel("DIGITE SEU E-MAIL OU CPF:");
        lblUserInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtUserInfo = new TextField("E-MAIL OU CPF");

        btnVerifyUserInfo = new ButtonComponent("VERIFICAR");

        resetPasswordPanel.add(Box.createVerticalGlue());
        resetPasswordPanel.add(lblUserInfo);
        resetPasswordPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPasswordPanel.add(txtUserInfo);
        resetPasswordPanel.add(Box.createRigidArea(new Dimension(0, 35)));
        resetPasswordPanel.add(btnVerifyUserInfo);
        resetPasswordPanel.add(Box.createVerticalGlue());

        add(resetPasswordPanel);
        
    }
    
}
