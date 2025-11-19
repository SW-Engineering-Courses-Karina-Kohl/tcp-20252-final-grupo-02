package design.view;

import javax.swing.*;
import java.awt.*;

import design.view.componentes.TextField;
import design.view.componentes.PasswordField;
import design.view.componentes.ButtonComponent;
import data.constData.constants;

public class RegistrationScreen extends JFrame {

    public JButton btnCadastrar;
    public JButton btnVoltar;
    public JTextField txtNome;
    public JTextField txtSobrenome;
    public JPasswordField txtSenha;
    public JPasswordField txtConfirmarSenha;
    public JTextField txtEmail;
    public JTextField txtCpf;

    public RegistrationScreen() {
        setTitle("Registration Screen");
        setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        main.setOpaque(false);

        // painel central que terá os campos
        JPanel center = new JPanel(new GridBagLayout());
        center.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;

        // Linha 0 - Nome (col 0)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel lblNome = new JLabel("DIGITE SEU PRIMEIRO NOME");
        center.add(lblNome, gbc);

        gbc.gridx = 1; // coluna direita do título (sobrenome)
        JLabel lblSobrenome = new JLabel("DIGITE SEU SOBRENOME");
        center.add(lblSobrenome, gbc);

        // Linha 1 - campos (linha 0 dos campos, abaixo dos labels)
        txtNome = new TextField("NOME");
        txtSobrenome = new TextField("SOBRENOME");
   
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        center.add(txtNome, gbc);

        gbc.gridx = 1;
        center.add(txtSobrenome, gbc);

        // Linha 2 - Labels email / cpf
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel lblEmail = new JLabel("DIGITE SEU E-MAIL");
        center.add(lblEmail, gbc);

        gbc.gridx = 1;
        JLabel lblCpf = new JLabel("DIGITE SEU CPF");
        center.add(lblCpf, gbc);

        // Linha 3 - campos email / cpf
        txtEmail = new TextField("E-MAIL");
        txtCpf = new TextField("CPF");

        gbc.gridy = 3;
        gbc.gridx = 0;
        center.add(txtEmail, gbc);

        gbc.gridx = 1;
        center.add(txtCpf, gbc);

        // Linha 4 - Labels senha / confirmar
        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel lblSenha = new JLabel("DIGITE SUA SENHA");
        center.add(lblSenha, gbc);

        gbc.gridx = 1;
        JLabel lblConfirmar = new JLabel("CONFIRME SUA SENHA");
        center.add(lblConfirmar, gbc);

        // Linha 5 - campos senha / confirmar
        txtSenha = new PasswordField("********");
        txtConfirmarSenha = new PasswordField("********");

        gbc.gridy = 5;
        gbc.gridx = 0;
        center.add(txtSenha, gbc);

        gbc.gridx = 1;
        center.add(txtConfirmarSenha, gbc);
        // botão centralizado embaixo
        btnCadastrar = new ButtonComponent("CADASTRAR");

        JPanel buttonRow = new JPanel();
        buttonRow.setOpaque(false);
        buttonRow.add(btnCadastrar);

        // monta tudo
        main.add(center, BorderLayout.CENTER);
        main.add(buttonRow, BorderLayout.SOUTH);

        add(main);
    }
}
