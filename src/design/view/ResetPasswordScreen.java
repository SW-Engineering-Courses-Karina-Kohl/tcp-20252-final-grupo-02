package design.view;

import javax.swing.*;
import java.awt.*;

import data.constData.constants;
import design.view.componentes.ButtonComponent;
import design.view.componentes.TextField;

public class ResetPasswordScreen extends JFrame {

    public JButton btnVerify;
    public JTextField txtEmailCpf;

    public ResetPasswordScreen() {

        setTitle("Reset Password Screen");
        setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel resetPanel = new JPanel();
        resetPanel.setLayout(new BoxLayout(resetPanel, BoxLayout.Y_AXIS));
        resetPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    
        JLabel lblEmailCpf = new JLabel("DIGITE SEU E-MAIL OU CPF");
        lblEmailCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtEmailCpf = new TextField("E-MAIL OU CPF");

        btnVerify = new ButtonComponent("VERIFICAR");

        resetPanel.add(Box.createVerticalGlue());
        resetPanel.add(lblEmailCpf);
        resetPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        resetPanel.add(txtEmailCpf);
        resetPanel.add(Box.createRigidArea(new Dimension(0, 35)));
        resetPanel.add(btnVerify);
        resetPanel.add(Box.createVerticalGlue());

        add(resetPanel);
    }
    
}
