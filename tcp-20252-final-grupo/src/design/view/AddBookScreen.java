package design.view;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import design.view.components.TextField;
import design.view.components.ButtonComponent;
import design.view.components.BackButtonComponent;
import data.Constants;

public class AddBookScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
    public JButton btnCadastrar;
    public JTextField txtTitle;
    public JTextField txtAuthor;
    public JTextField txtISBN;
    public JTextField txtYear;
    public JTextField txtGenre;
    public JTextField txtPages;
    public JButton btnBackButton;

    public AddBookScreen(com.model.User loggedUser, com.service.BookClubService clubService) {
        setTitle("Add Book Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        main.setBounds(0, -Constants.BACK_BUTTON_SIZE, getWidth(), getHeight());
        main.setOpaque(false);

        JPanel center = new JPanel(new GridBagLayout());
        center.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel lblTitle = new JLabel("INFORME O TÍTULO DO LIVRO");
        center.add(lblTitle, gbc);

        gbc.gridx = 1; 
        JLabel lblAuthor = new JLabel("INFORME O AUTOR DO LIVRO");
        center.add(lblAuthor, gbc);
   
        txtTitle = new TextField("TÍTULO");
        txtAuthor = new TextField("AUTOR");

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        center.add(txtTitle, gbc);

        gbc.gridx = 1;
        center.add(txtAuthor, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel lblISBN = new JLabel("INFORME O CÓDIGO ISBN");
        center.add(lblISBN, gbc);

        gbc.gridx = 1;
        JLabel lblYear = new JLabel("INFORME O ANO DE PUBLICAÇÃO");
        center.add(lblYear, gbc);

        txtISBN = new TextField("ISBN");
        txtYear = new TextField("AAAA");

        gbc.gridy = 3;
        gbc.gridx = 0;
        center.add(txtISBN, gbc);

        gbc.gridx = 1;
        center.add(txtYear, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel lblGenre = new JLabel("INFORME O GÊNERO DO LIVRO");
        center.add(lblGenre, gbc);

        gbc.gridx = 1;
        JLabel lblPages = new JLabel("INFORME O NÚMERO DE PÁGINAS");
        center.add(lblPages, gbc);

        txtGenre = new TextField("GÊNERO");
        txtPages = new TextField("NRO PÁGINAS");

        gbc.gridy = 5;
        gbc.gridx = 0;
        center.add(txtGenre, gbc);

        gbc.gridx = 1;
        center.add(txtPages, gbc);
        // botão centralizado embaixo
        btnCadastrar = new ButtonComponent("CADASTRAR");

        JPanel buttonRow = new JPanel();
        buttonRow.setOpaque(false);
        buttonRow.add(btnCadastrar);

        main.add(center, BorderLayout.CENTER);
        main.add(buttonRow, BorderLayout.SOUTH);

        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.BACK_BUTTON_BOUND_X, Constants.BACK_BUTTON_BOUND_Y);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
    
		btnBackButton.addActionListener(e -> {
			
			AddBookScreen.this.dispose();
            GroupCreationScreen screen = new GroupCreationScreen(loggedUser, clubService);
            new com.GroupCreationController(screen, loggedUser, clubService);
            screen.setVisible(true);

		});
		
		btnCadastrar.addActionListener(e -> {
			
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/files/Books.csv", true))) {
	            writer.write(txtTitle.getText() + ", " + txtAuthor.getText() + ", " + txtISBN.getText() + ", " + txtYear.getText() + ", " + txtGenre.getText() + ", " + txtPages.getText() + "\n");
	        }   catch (IOException ex) {
	                ex.printStackTrace();
	            }
			AddBookScreen.this.dispose();
			GroupCreationScreen screen = new GroupCreationScreen(loggedUser, clubService);
            new com.GroupCreationController(screen, loggedUser, clubService);
            screen.setVisible(true);
		});
        
    }
}
