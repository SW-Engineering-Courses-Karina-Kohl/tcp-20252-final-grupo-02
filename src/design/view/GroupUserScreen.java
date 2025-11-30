package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.CardData;
import data.CardFilter;
import design.view.components.BackButtonComponent;
import design.view.components.ButtonComponent;
import data.Constants;
import design.view.components.CardComponent;

import design.view.GroupCreationScreen;

public class GroupUserScreen extends JFrame{
    
    public JButton btnManage;
    public JButton btnCreateNewGroup;
    public JButton btnBackButton;

    public GroupUserScreen(){
        setTitle("Group User Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setLayout(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40,30,10,30));
        main.setBounds(0, 10, getWidth(), getHeight());
        main.setOpaque(false);

        CardFilter cardFilter = new CardFilter();
        List<CardData> UserPosts = cardFilter.getFilteredCards(Constants.CSV_PATHS[1]);
        
        JPanel CardPanel = new JPanel();
        CardPanel.setLayout(new BoxLayout(CardPanel, BoxLayout.Y_AXIS));
        CardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        CardPanel.setOpaque(false);

        for (CardData cardData : UserPosts){
            
            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            row.setBorder(BorderFactory.createEmptyBorder(10,30,15,30));
            row.setOpaque(false);

            CardComponent card = new CardComponent();
            card.setData(cardData.getGroup(), cardData.getInfo(),null, null);
            card.setMaximumSize(new Dimension(Constants.CARD_WIDTH+200, Constants.CARD_HEIGHT));
            card.setPreferredSize(new Dimension(Constants.CARD_WIDTH+200, Constants.CARD_HEIGHT));
            // CardPanel.add(card);

            if (cardData.getInfo().equals("Encerrado")) {
                row.add(card);
                row.add(Box.createHorizontalGlue());

                CardPanel.add(row);
                continue; 
            }
            btnManage = new ButtonComponent("GERENCIAR");
            btnManage.setMaximumSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
            btnManage.setPreferredSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));

            btnManage.addActionListener(e -> {
                GroupUserScreen.this.dispose();
                GroupManagementScreen groupManagementScreen = new GroupManagementScreen(cardData.getGroup());
                groupManagementScreen.setVisible(true);
            });
            // CardPanel.add(btnManage);

            row.add(card);
            row.add(Box.createHorizontalGlue());
            row.add(btnManage);

            CardPanel.add(row);
        }

        JScrollPane ScrollPane = new JScrollPane(CardPanel);
        ScrollPane.getVerticalScrollBar().setUnitIncrement(16); // velocidade de scroll
        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setPreferredSize(new Dimension(0, 100));
        ScrollPane.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        ScrollPane.setBorder(BorderFactory.createTitledBorder("Seus Grupos"));

        main.add(ScrollPane);
        main.add(Box.createRigidArea(new Dimension(0, 5)));

        btnCreateNewGroup = new ButtonComponent("CRIAR NOVO GRUPO");
        btnCreateNewGroup.setMaximumSize(new Dimension(Constants.BUTTON_WIDTH+200, Constants.BUTTON_HEIGHT));
        btnCreateNewGroup.setPreferredSize(new Dimension(Constants.BUTTON_WIDTH+200, Constants.BUTTON_HEIGHT));
        main.add(btnCreateNewGroup);

        btnCreateNewGroup.addActionListener(e -> {
            GroupUserScreen.this.dispose();
            GroupCreationScreen groupCreationScreen = new GroupCreationScreen();
            groupCreationScreen.setVisible(true);
        });

        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);

    }

}
