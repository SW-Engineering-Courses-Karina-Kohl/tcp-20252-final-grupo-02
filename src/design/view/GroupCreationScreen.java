package design.view;

import javax.swing.*;
import java.awt.*;
import design.view.AddBookScreen;

import data.Constants;
import design.view.components.ButtonComponent;
import design.view.components.BackButtonComponent;
import design.view.components.TextField;
import design.view.components.InfoBarComponent;
import design.view.components.DatePickerComponent;

public class GroupCreationScreen extends JFrame {

    public JButton btnAddBook;
    public JButton btnBackButton;
    public JButton btnInitVote;
    public JRadioButton rbtnPresential;
    public JRadioButton rbtnOnline;
    public TextField txtGroupName;
    public TextField txtBook1;
    public TextField txtBook2;
    public DatePickerComponent txtDate1;
    public DatePickerComponent txtDate2;

    public GroupCreationScreen() {

        setTitle("Group Creation Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));
        main.setBounds(0, -Constants.BACK_BUTTON_BOUND_Y, getWidth(), getHeight());
        main.setOpaque(false);

        // Campo Nome
        txtGroupName = new TextField("Nome do Grupo");
        txtGroupName.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        txtGroupName.setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        txtGroupName.setBackground(Constants.WHITE);
        txtGroupName.setHorizontalAlignment(JTextField.CENTER);

        main.add(txtGroupName);
        main.add(Box.createRigidArea(new Dimension(0, 20)));

        // Painel com livros e datas
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);
        infoPanel.setMaximumSize(new Dimension(Constants.SCREEN_WIDTH, Constants.DIMENSION_FIELD_HEIGHT * 4));

        // Painel de livros 
        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
        bookPanel.setOpaque(false);

        bookPanel.add(createInfoLabel("INSIRA O LIVRO A SER DEBATIDO"));
        bookPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        txtBook1 = new TextField("Livro 1");
        txtBook1.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        bookPanel.add(txtBook1);

        bookPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bookPanel.add(createInfoLabel("INSIRA O LIVRO A SER DEBATIDO"));
        bookPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        txtBook2 = new TextField("Livro 2");
        txtBook2.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        bookPanel.add(txtBook2);

        // Painel de datas 
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.Y_AXIS));
        datePanel.setOpaque(false);

        datePanel.add(createInfoLabel("INSIRA AS DATAS DE VOTAÇÃO"));
        datePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        txtDate1 = new DatePickerComponent("Data Votação 1");
        txtDate1.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        datePanel.add(txtDate1);

        datePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        datePanel.add(createInfoLabel("INSIRA AS DATAS DE VOTAÇÃO"));
        datePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        txtDate2 = new DatePickerComponent("Data Votação 2");
        txtDate2.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        datePanel.add(txtDate2);

        infoPanel.add(bookPanel);
        infoPanel.add(datePanel, BorderLayout.EAST);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));
        containerPanel.setOpaque(false);

        JPanel formatPanel = new JPanel();
        formatPanel.setOpaque(false);
        formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));

        rbtnPresential = new JRadioButton("Presencial");
        rbtnOnline = new JRadioButton("Online");

        formatPanel.add(rbtnPresential);
        formatPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        formatPanel.add(rbtnOnline);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        ButtonGroup group = new ButtonGroup();
        btnAddBook = new ButtonComponent("Adicionar Livro");
        btnInitVote = new ButtonComponent("Começar Votação");

        btnInitVote.addActionListener(e -> {
            if (txtDate1.getDate() == null || txtDate2.getDate() == null || txtBook1.getText().isEmpty() || txtBook2.getText().isEmpty() || txtGroupName.getText().isEmpty() 
            || (!rbtnOnline.isSelected() && !rbtnPresential.isSelected())) {
                JOptionPane.showMessageDialog(this, "Por favor, termine de preencher todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                // demais validações chamar outra classe
                System.out.println(txtDate1.getDate());
                System.out.println(txtDate2.getDate());
            }
        });

        btnAddBook.addActionListener(e -> {
           GroupCreationScreen.this.dispose();
           AddBookScreen addBookScreen = new AddBookScreen();
           addBookScreen.setVisible(true);
        });

        group.add(rbtnPresential);
        group.add(rbtnOnline);

        buttonPanel.add(btnAddBook);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(btnInitVote);

        containerPanel.add(formatPanel);
        containerPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        containerPanel.add(buttonPanel);

        main.add(Box.createVerticalGlue());
        main.add(infoPanel);
        main.add(Box.createRigidArea(new Dimension(0, 30)));
        main.add(containerPanel);

        InfoBarComponent infoBar = new InfoBarComponent("", "VARIAVEL", "");

        main.add(Box.createVerticalGlue());
        main.add(infoBar);

        // LayeredPane para o botão voltar
        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
    }

    private JLabel createInfoLabel(String label) {
        JLabel lblBooks = new JLabel(label);
        lblBooks.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lblBooks;
    }
}
