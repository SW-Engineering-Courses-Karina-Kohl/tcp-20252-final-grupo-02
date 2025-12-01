package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.Constants;
import design.view.components.BackButtonComponent;
import design.view.components.ButtonComponent;
import design.view.components.CardComponent;

public class ParticipateScreen extends JFrame {

    private JButton btnBackButton;

    public ParticipateScreen(com.model.User loggedUser, com.service.BookClubService clubService) {
        setTitle("Participate Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40, 30, 10, 30));
        main.setBounds(0, 10, getWidth(), getHeight());
        main.setOpaque(false);

        
        List<com.model.BookClub> userGroups = clubService.getClubsForUser(loggedUser);
        JPanel CardPanel = new JPanel();
        CardPanel.setLayout(new BoxLayout(CardPanel, BoxLayout.Y_AXIS));
        CardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        CardPanel.setOpaque(false);

        for (com.model.BookClub bc : userGroups) {
           
            if (!bc.getParticipants().contains(loggedUser)) continue;

            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            row.setBorder(BorderFactory.createEmptyBorder(10, 30, 15, 30));
            row.setOpaque(false);

            CardComponent card = new CardComponent();
            card.setData(bc.getName(), "Membros: " + bc.getParticipants().size(), null, null);
            row.add(card);
            row.add(Box.createHorizontalGlue());

                JButton btnExit = new ButtonComponent ("SAIR");
                btnExit.setMaximumSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
                btnExit.setPreferredSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
                btnExit.addActionListener(e -> {
                    System.out.println("Clique em SAIR do grupo: " + bc.getName());
        
                });

            
            row.add(btnExit);
            CardPanel.add(row);
        }

        JScrollPane scrollPane = new JScrollPane(CardPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Grupos em que está participando"));
        main.add(scrollPane);

        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);
        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);

        
        btnBackButton.addActionListener(e -> {
            this.dispose();
            HomeScreen homeScreen = new HomeScreen();
            new com.HomeController(homeScreen, loggedUser, clubService);
            homeScreen.setVisible(true);
        });
    }
}
