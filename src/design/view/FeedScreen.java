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
        // setLayout(null);

        JPanel feedPanel = new JPanel();
        feedPanel.setLayout(new BoxLayout(feedPanel, BoxLayout.Y_AXIS));
        feedPanel.setBorder(BorderFactory.createEmptyBorder(60, 10, 10, 10));
        feedPanel.setBounds(0, constants.BACK_BUTTON_BOUND_Y, getWidth(), getHeight());
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
                // System.out.println("Card clicado: " + card.getGroup());
                // System.out.println("Info: " + card.getInfo());

                JOptionPane.showConfirmDialog(
                        null,
                        "Deseja entrar no grupo " + card.getGroup() + " ?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );
            });
        }

        JScrollPane ScrollPane = new JScrollPane(CardPanel);
        ScrollPane.getVerticalScrollBar().setUnitIncrement(16); // velocidade de scroll
        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setPreferredSize(new Dimension(0, 200));
        ScrollPane.setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT - 100);
        ScrollPane.setBorder(BorderFactory.createTitledBorder("Feed Geral"));
        feedPanel.add(ScrollPane);

        JLayeredPane layered = getLayeredPane();
        add(feedPanel, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(constants.BACK_BUTTON_SIZE, constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(constants.SCREEN_WIDTH - (constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
    }
}
