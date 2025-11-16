package design.view;

import javax.swing.*;
import java.awt.*;

import static design.view.componentes.Placeholder.applyPlaceholder;
import data.constData.constants;

public class LoginScreen extends JFrame {

    public JButton btnEntrar;
    public JPasswordField txtSenha;
    public JTextField txtEmailCpf;

    public LoginScreen() {

        setTitle("Login Screen");
        setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel login = new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
        login.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Componentes ---
        // label
        JLabel lblEmailCpf = new JLabel("DIGITE SEU E-MAIL OU CPF");
        lblEmailCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
        // 2. Campo de Texto "E-mail ou CPF"
        txtEmailCpf = new JTextField(20);
        applyPlaceholder(txtEmailCpf, "E-mail ou CPF");
        txtEmailCpf.setBackground(constants.YELLOW); // Cor de fundo
        txtEmailCpf.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtEmailCpf.setMaximumSize(new Dimension(300, 40));

        // 3. label
        JLabel lblSenha = new JLabel("DIGITE SUA SENHA");
        lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        // 4. Campo de Senha
        txtSenha = new JPasswordField();
        applyPlaceholder(txtSenha, "*********");
        txtSenha.setBackground(constants.YELLOW); // Cor de fundo
        txtSenha.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtSenha.setMaximumSize(new Dimension(300, 40));

        // 5. Botão "ENTRAR"
        btnEntrar = new JButton("ENTRAR");
        configurarBotao(btnEntrar);

        // 6. Botão "CADASTRAR"
        JButton btnCadastrar = new JButton("CADASTRAR");
        configurarBotao(btnCadastrar);

        // 7.label
        JButton btnEsqueceuSenha = new JButton("ESQUECEU SUA SENHA");
        btnEsqueceuSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEsqueceuSenha.setFont(new Font("Excalifont", Font.PLAIN, 12));
        btnEsqueceuSenha.setBorderPainted(false); // Remove a borda
        btnEsqueceuSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEsqueceuSenha.setBackground(Color.WHITE);

        // --- Adicionando componentes ao Painel Principal ---
        login.add(Box.createVerticalGlue());
        login.add(lblEmailCpf);
        login.add(Box.createRigidArea(new Dimension(0, 5)));
        login.add(txtEmailCpf);
        login.add(Box.createRigidArea(new Dimension(0, 15)));
        login.add(lblSenha);
        login.add(Box.createRigidArea(new Dimension(0, 5)));
        login.add(txtSenha);
        login.add(Box.createRigidArea(new Dimension(0, 20)));
        login.add(btnEntrar);
        login.add(Box.createRigidArea(new Dimension(0, 10)));
        login.add(btnCadastrar);
        login.add(Box.createRigidArea(new Dimension(0, 15)));
        login.add(btnEsqueceuSenha);
        login.add(Box.createVerticalGlue());

        add(login);

    }

    // Método auxiliar para configurar a aparência dos botões
    private void configurarBotao(JButton botao) {
        botao.setBackground(constants.BLUE);
        botao.setForeground(constants.BLACK);
        botao.setFocusPainted(false);
        botao.setOpaque(true); // Necessário para a cor de fundo funcionar em alguns SOs
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setMaximumSize(new Dimension(200, 40));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
