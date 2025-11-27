package design.view;

import java.util.List;

import javax.swing.*;
import java.awt.*;

import data.CardData;
import data.CardFilter;
import data.Constants;
import design.view.components.BackButtonComponent;
import design.view.components.ButtonComponent;
import design.view.components.CardComponent;

import design.view.ExitScreen;
import design.view.GroupVoteScreen;

public class ParticipateScreen extends JFrame {

    private JButton btnExit;
    private JButton btnBackButton;

    public ParticipateScreen() {
        setTitle("Participate Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40, 30, 10, 30));
        main.setBounds(0, 10, getWidth(), getHeight());
        main.setOpaque(false);

        CardFilter cardFilter = new CardFilter();
        List<CardData> UserPosts = cardFilter.getFilteredCards(Constants.CSV_PATHS[1]); // trocar o arquivo!!!

        JPanel CardPanel = new JPanel();
        CardPanel.setLayout(new BoxLayout(CardPanel, BoxLayout.Y_AXIS));
        CardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        CardPanel.setOpaque(false);

        for (CardData cardData : UserPosts) {

            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            row.setBorder(BorderFactory.createEmptyBorder(10, 30, 15, 30));
            row.setOpaque(false);

            CardComponent card = new CardComponent();
            card.setData(cardData.getGroup(), cardData.getInfo(), null, null);
            card.setMaximumSize(new Dimension(Constants.CARD_WIDTH + 200, Constants.CARD_HEIGHT));
            card.setPreferredSize(new Dimension(Constants.CARD_WIDTH + 200, Constants.CARD_HEIGHT));
            // CardPanel.add(card);
            
            // criar classe separadas para cuidar das validações
            if (cardData.getInfo().equals("Encerrado")) {
                row.add(card);
                row.add(Box.createHorizontalGlue());
                row.add(new JLabel("")); 
                CardPanel.add(row);
                continue;
            }
                btnExit = new ButtonComponent("SAIR");
                btnExit.setMaximumSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
                btnExit.setPreferredSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
                btnExit.addActionListener(e -> {
                    System.out.println("click " + cardData.getGroup());

                    ParticipateScreen.this.dispose();
                    ExitScreen exitScreen = new ExitScreen(cardData.getGroup());
                    exitScreen.setVisible(true);
                });
           

                card.setOnCardClick(() -> {
                    if (cardData.getInfo().equals("Pending Vote")) {
                        ParticipateScreen.this.dispose();
                        GroupVoteScreen groupVoteScreen = new GroupVoteScreen(cardData.getGroup());
                        groupVoteScreen.setVisible(true);
                    }
                });

            row.add(card);
            row.add(Box.createHorizontalGlue());
            row.add(btnExit);

            CardPanel.add(row);
        }

        JScrollPane ScrollPane = new JScrollPane(CardPanel);
        ScrollPane.getVerticalScrollBar().setUnitIncrement(16); // velocidade de scroll
        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setPreferredSize(new Dimension(0, 100));
        ScrollPane.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        ScrollPane.setBorder(BorderFactory.createTitledBorder("Grupos em que está participando"));

        main.add(ScrollPane);
        main.add(Box.createRigidArea(new Dimension(0, 5)));

        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);

    }
}
