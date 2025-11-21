package design.view;

import javax.swing.*;
import java.awt.*;

import data.constData.constants;
import design.view.componentes.ButtonComponent;
import design.view.componentes.BackButtonComponent;
import design.view.componentes.TextField;

public class ResetPasswordScreen1 extends JFrame {
    public JTextField txtPassword;
    public JTextField txtConfirmPassword;
    public JButton btnCadastrar;
    public JButton btnBackButton;

    public ResetPasswordScreen1() {
        setTitle("Reset Password Screen");
        setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 

        JPanel resetPanel = new JPanel();
        resetPanel.setLayout(new BoxLayout(resetPanel, BoxLayout.Y_AXIS));
        resetPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        resetPanel.setBounds(0,-constants.BACK_BUTTON_SIZE,getWidth(), getHeight());
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

        add(resetPanel);

        btnBackButton = new BackButtonComponent();
        // System.out.println(constants.BACK_BUTTON_BOUND_X);
        btnBackButton.setBounds(constants.BACK_BUTTON_BOUND_X, constants.BACK_BUTTON_BOUND_Y, constants.BACK_BUTTON_SIZE,constants.BACK_BUTTON_SIZE); // posição absoluta
        add(btnBackButton);
    }

}
