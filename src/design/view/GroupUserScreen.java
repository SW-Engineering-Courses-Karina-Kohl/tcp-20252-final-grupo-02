package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.CardData;
import data.CardFilter;
import design.view.componentes.BackButtonComponent;
import design.view.componentes.ButtonComponent;
import data.constData.constants;
import design.view.componentes.CardComponent;

public class GroupUserScreen extends JFrame{
    
    public JButton btnManage;
    public JButton btnCreateNewGroup;
    public JButton btnBackButton;

    public GroupUserScreen(){
        setTitle("Group User Screen");
        setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setLayout(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40,30,10,30));
        main.setBounds(0, 10, getWidth(), getHeight());
        main.setOpaque(false);

        CardFilter cardFilter = new CardFilter();
        List<CardData> UserPosts = cardFilter.getFilteredCards(constants.CSV_PATHS[1]);
        
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
            card.setMaximumSize(new Dimension(constants.CARD_WIDTH+200, constants.CARD_HEIGHT));
            card.setPreferredSize(new Dimension(constants.CARD_WIDTH+200, constants.CARD_HEIGHT));
            // CardPanel.add(card);

            btnManage = new ButtonComponent("GERENCIAR");
            btnManage.setMaximumSize(new Dimension(constants.BUTTON_WIDTH, constants.BUTTON_HEIGHT));
            btnManage.setPreferredSize(new Dimension(constants.BUTTON_WIDTH, constants.BUTTON_HEIGHT));

            btnManage.addActionListener(e -> {
                System.out.println("click "+ cardData.getGroup());
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
        ScrollPane.setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        ScrollPane.setBorder(BorderFactory.createTitledBorder("Seus Grupos"));

        main.add(ScrollPane);
        main.add(Box.createRigidArea(new Dimension(0, 5)));

        btnCreateNewGroup = new ButtonComponent("CRIAR NOVO GRUPO");
        btnCreateNewGroup.setMaximumSize(new Dimension(constants.BUTTON_WIDTH+200, constants.BUTTON_HEIGHT));
        btnCreateNewGroup.setPreferredSize(new Dimension(constants.BUTTON_WIDTH+200, constants.BUTTON_HEIGHT));
        main.add(btnCreateNewGroup);

        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(constants.BACK_BUTTON_SIZE, constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(constants.SCREEN_WIDTH - (constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);

    }

}
