package design.view;

import javax.swing.*;

import java.awt.*;

import data.Constants;
import design.view.components.ButtonComponent;
import design.view.components.BackButtonComponent;
import design.view.components.TextField;

public class ResetPasswordScreen1 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JTextField txtPassword;
    public JTextField txtConfirmPassword;
    public JButton btnCadastrar;
    public JButton btnBackButton;

    public ResetPasswordScreen1() {
        setTitle("Reset Password Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setLayout(null); 

        JPanel resetPanel = new JPanel();
        resetPanel.setLayout(new BoxLayout(resetPanel, BoxLayout.Y_AXIS));
        resetPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        resetPanel.setBounds(0,-Constants.BACK_BUTTON_SIZE,getWidth(), getHeight());
        resetPanel.setOpaque(false);

        JLabel lblPassword = new JLabel("DIGITE A NOVA SENHA");
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtPassword = new TextField("********");

        JLabel lblConfirmPassword = new JLabel("CONFIRMAR A NOVA SENHA");
        lblConfirmPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtConfirmPassword = new TextField("********");

        btnCadastrar = new ButtonComponent("CADASTRAR");

        resetPanel.add(Box.createVerticalGlue());
        resetPanel.add(lblPassword);
        resetPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPanel.add(txtPassword);
        resetPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPanel.add(lblConfirmPassword);
        resetPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPanel.add(txtConfirmPassword);
        resetPanel.add(Box.createRigidArea(new Dimension(0, 35)));
        resetPanel.add(btnCadastrar);
        resetPanel.add(Box.createVerticalGlue());

        JLayeredPane layered = getLayeredPane();
        add(resetPanel, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.BACK_BUTTON_BOUND_X, Constants.BACK_BUTTON_BOUND_Y);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
    }
}
