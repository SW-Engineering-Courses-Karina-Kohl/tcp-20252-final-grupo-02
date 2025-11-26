package design.view;

import javax.swing.*;

import data.Constants;

import java.awt.*;

import design.view.components.ButtonComponent;
import design.view.components.PasswordField;
import design.view.components.TextField;

public class RegistrationScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JButton btnBack;
	public JButton btnSignin;
    public JTextField txtName;
    public JTextField txtSurname;
    public JPasswordField txtConfirmPassword;
    public JPasswordField txtPassword;
    public JTextField txtCpf;
    public JTextField txtEmail;

    public RegistrationScreen() {
    	
        setTitle("Bookly - Cadastro de novo usuário");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel regScreenPanel = new JPanel();
        regScreenPanel.setLayout(new BorderLayout());
        regScreenPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        regScreenPanel.setOpaque(false);

        JPanel regScreenCenterPanel = new JPanel(new GridBagLayout());
        regScreenCenterPanel.setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;
        
        
       
        gbc.gridx = 0;
        
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel lblName = new JLabel("DIGITE SEU NOME:");
        regScreenCenterPanel.add(lblName, gbc);

        gbc.gridx = 1;
        JLabel lblSurname = new JLabel("DIGITE SEU SOBRENOME:");
        regScreenCenterPanel.add(lblSurname, gbc);

        txtName = new TextField("Nome");
        txtSurname = new TextField("Sobrenome");
   
        gbc.gridy = 1;
        
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        regScreenCenterPanel.add(txtName, gbc);

        gbc.gridx = 1;
        regScreenCenterPanel.add(txtSurname, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel lblEmail = new JLabel("DIGITE SEU E-MAIL:");
        regScreenCenterPanel.add(lblEmail, gbc);

        gbc.gridx = 1;
        JLabel lblCpf = new JLabel("DIGITE SEU CPF:");
        regScreenCenterPanel.add(lblCpf, gbc);

        // Linha 3 - campos email / cpf
        txtEmail = new TextField("Endereço de e-mail");
        txtCpf = new TextField("CPF");

        gbc.gridy = 3;
        gbc.gridx = 0;
        regScreenCenterPanel.add(txtEmail, gbc);

        gbc.gridx = 1;
        regScreenCenterPanel.add(txtCpf, gbc);

        // Linha 4 - Labels senha / confirmar
        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel lblSenha = new JLabel("DIGITE SUA SENHA:");
        regScreenCenterPanel.add(lblSenha, gbc);

        gbc.gridx = 1;
        JLabel lblConfirmar = new JLabel("CONFIRME SUA SENHA:");
        regScreenCenterPanel.add(lblConfirmar, gbc);

        // Linha 5 - campos senha / confirmar
        txtPassword = new PasswordField("********");
        txtConfirmPassword = new PasswordField("********");

        gbc.gridy = 5;
        gbc.gridx = 0;
        regScreenCenterPanel.add(txtPassword, gbc);

        gbc.gridx = 1;
        regScreenCenterPanel.add(txtConfirmPassword, gbc);

        btnSignin = new ButtonComponent("CADASTRAR");

        JPanel btnRow = new JPanel();
        btnRow.setOpaque(false);
        btnRow.add(btnSignin);

        regScreenPanel.add(regScreenCenterPanel, BorderLayout.CENTER);
        regScreenPanel.add(btnRow, BorderLayout.SOUTH);

        add(regScreenPanel);
        
    }
    
}
