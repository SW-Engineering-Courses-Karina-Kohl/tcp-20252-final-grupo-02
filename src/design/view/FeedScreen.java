package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.CardData;
import data.CardFilter;
import data.constData.constants;
import design.view.componentes.BackButtonComponent;
import design.view.componentes.CardComponent;

public class FeedScreen extends JFrame {

    public JButton btnBackButton;
    public JButton btnCard;

    public FeedScreen() {
        setTitle("Feed Screen");
        setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel feedPanel = new JPanel();
        feedPanel.setLayout(new BoxLayout(feedPanel, BoxLayout.Y_AXIS));
        feedPanel.setBorder(BorderFactory.createEmptyBorder(60, 5, 70, 20));
        feedPanel.setBounds(0, 0, getWidth(), getHeight());
        feedPanel.setOpaque(false);

        CardFilter cardFilter = new CardFilter();
        List<CardData> Posts = cardFilter.getFilteredCards(constants.CSV_PATHS[0]); // trocar o arquivo CSV conforme necessário

        JPanel CardPanel = new JPanel();
        CardPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 colunas, varias linhas
        CardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        CardPanel.setOpaque(false);

        for (CardData cardData : Posts) {
            CardComponent card = new CardComponent();
            card.setData(cardData.getGroup(), cardData.getInfo(), cardData.getDate(), cardData.getformat());
            CardPanel.add(card);

            // Define a ação ao clicar no card (tirei da net)
            card.setOnCardClick(() -> {
                System.out.println("Card clicado: " + card.getGroup());
                System.out.println("Info: " + card.getInfo());
                // logica para entrar no grupo
            });
        }

        JScrollPane secondScrollPane = new JScrollPane(CardPanel);
        secondScrollPane.getVerticalScrollBar().setUnitIncrement(16); // velocidade de scroll
        secondScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        secondScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        secondScrollPane.setPreferredSize(new Dimension(0, 200));
        secondScrollPane.setSize(constants.SCREEN_WIDTH - 50, constants.SCREEN_HEIGHT - 100);
        secondScrollPane.setBorder(BorderFactory.createTitledBorder("Feed Geral"));
        feedPanel.add(secondScrollPane);

        add(feedPanel);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setBounds(constants.BACK_BUTTON_BOUND_X, 10, constants.BACK_BUTTON_SIZE, constants.BACK_BUTTON_SIZE);
        // btnBackButton.setBounds(constants.BACK_BUTTON_BOUND_X, constants.BACK_BUTTON_BOUND_Y, constants.BACK_BUTTON_SIZE,constants.BACK_BUTTON_SIZE); // posição absoluta
        add(btnBackButton);
    }
}
