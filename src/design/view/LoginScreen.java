package design.view;

import javax.swing.*;

import data.Constants;

import java.awt.*;

import design.view.components.ButtonComponent;
import design.view.components.PasswordField;
import design.view.components.TextField;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
    public JButton btnEntrar;
    public JButton btnCadastrar;
    public JButton btnEsqueceuSenha;
    public JPasswordField txtSenha;
    public JTextField txtEmailCpf;

    public LoginScreen() {

        setTitle("Login Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color background = getContentPane().getBackground();
        System.out.println("Cor da tela: " + background);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Componentes ---
        // label
        JLabel lblEmailCpf = new JLabel("DIGITE SEU E-MAIL OU CPF");
        lblEmailCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
        // 2. Campo de Texto "E-mail ou CPF"
        txtEmailCpf = new TextField("E-mail ou CPF");

        // 3. label
        JLabel lblSenha = new JLabel("DIGITE SUA SENHA");
        lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        // 4. Campo de Senha
        txtSenha = new PasswordField("*********");
       
        // 5. Botão "ENTRAR"
        btnEntrar = new ButtonComponent("ENTRAR");

        // 6. Botão "CADASTRAR"
        btnCadastrar = new ButtonComponent("CADASTRAR");

        // 7.label
        btnEsqueceuSenha = new JButton("ESQUECEU SUA SENHA");
        btnEsqueceuSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEsqueceuSenha.setFont(new Font("Excalifont", Font.PLAIN, 12));
        btnEsqueceuSenha.setBorderPainted(false); // Remove a borda
        btnEsqueceuSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEsqueceuSenha.setBackground(Constants.WHITE);

        // --- Adicionando componentes ao Painel Principal ---
        loginPanel.add(Box.createVerticalGlue());
        loginPanel.add(lblEmailCpf);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        loginPanel.add(txtEmailCpf);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        loginPanel.add(lblSenha);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        loginPanel.add(txtSenha);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        loginPanel.add(btnEntrar);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        loginPanel.add(btnCadastrar);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        loginPanel.add(btnEsqueceuSenha);
        loginPanel.add(Box.createVerticalGlue());

        add(loginPanel);

    }
}
