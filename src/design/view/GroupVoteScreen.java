package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.Constants;
import design.view.components.BackButtonComponent;
import design.view.components.VoteComponent;
import design.view.components.ButtonComponent;

public class GroupVoteScreen extends JFrame {

    private JButton btnBackButton;
    private List<String> listOptions;
    private List<String> listDateOptions;
    public JButton btnVoteButton;

    public GroupVoteScreen(String Group) {

        setTitle("Group Vote Screen - " + Group);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        main.setOpaque(false);
        main.setBounds(0, -Constants.BACK_BUTTON_BOUND_Y, getWidth(), getHeight());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
        mainPanel.setOpaque(false); 

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        container.setOpaque(false);

        JLabel lblGroupName = new JLabel(Group);
        lblGroupName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblChooseBook = new JLabel("ESCOLHA O LIVRO A SER DEBATIDO");
        lblChooseBook.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblChooseDate = new JLabel("ESCOLHA A DATA PARA O DEBATE");
        lblChooseDate.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblFormat = new JLabel("Presencial"); // mudar aqui
        JLabel lblParticipants = new JLabel("15 participantes"); // mudar aqui
        JLabel lblTime = new JLabel("5 dias para o término da votação"); // mudar aqui

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
        infoPanel.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
        infoPanel.setOpaque(false);
        infoPanel.add(Box.createHorizontalGlue());
        infoPanel.add(lblFormat);
        infoPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        infoPanel.add(lblParticipants);
        infoPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        infoPanel.add(lblTime);
        infoPanel.add(Box.createHorizontalGlue());
        
        // Exemplo de dados
        listOptions = List.of("Livro 1", "Livro 2");
        listDateOptions = List.of("01/07/2024", "08/07/2024");

        VoteComponent voteComponent = new VoteComponent(listOptions);
        voteComponent.setAlignmentX(Component.CENTER_ALIGNMENT);

        VoteComponent dateComponent = new VoteComponent(listDateOptions);
        dateComponent.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnVoteButton = new ButtonComponent("ENVIAR"); // FAZER VALIDAÇÃO
        btnVoteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        container.add(lblChooseBook);
        container.add(Box.createRigidArea(new Dimension(0, 40)));
        container.add(voteComponent);
        container.add(Box.createRigidArea(new Dimension(0, 40)));
        container.add(lblChooseDate);
        container.add(Box.createRigidArea(new Dimension(0, 40)));
        container.add(dateComponent);

        mainPanel.add(Box.createHorizontalGlue());
        mainPanel.add(container);
        mainPanel.add(Box.createRigidArea(new Dimension(40, 0)));
        mainPanel.add(btnVoteButton);
        mainPanel.add(Box.createHorizontalGlue());

        main.add(Box.createVerticalGlue());
        main.add(lblGroupName);
        main.add(mainPanel);
        main.add(infoPanel);
        main.add(Box.createVerticalGlue());

        add(main, BorderLayout.CENTER);

        JLayeredPane layered = getLayeredPane();

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.BACK_BUTTON_BOUND_X, Constants.BACK_BUTTON_BOUND_Y);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
    }
}
