package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.CardData;
import data.CardFilter;
import data.Constants;
import design.view.components.CardComponent;

public class HomeScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
    public HomeScreen() {
        setTitle("Home Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ============================================================

        CardFilter cardFilter = new CardFilter();

        List<CardData> firstCards = cardFilter.getFilteredCards(Constants.CSV_PATHS[0]);

        JPanel firstCardPanel = new JPanel();
        firstCardPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Uma coluna, varias linhas

        for (CardData cardData : firstCards) {
            CardComponent card = new CardComponent();
            card.setData(cardData.getGroup(), cardData.getInfo(), cardData.getDate(), cardData.getformat());
            firstCardPanel.add(card);
        }

        JScrollPane firstScrollPane = new JScrollPane(firstCardPanel);
        firstScrollPane.getVerticalScrollBar().setUnitIncrement(16); // velocidade de scroll
        firstScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        firstScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        firstScrollPane.setPreferredSize(new Dimension(0, 200)); // altura do primeiro bloco
        firstScrollPane.setBorder(BorderFactory.createTitledBorder("Seu Feed"));

        mainContainer.add(firstScrollPane);

        /* ============================================================
       SEPARATOR
       ============================================================ */
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        mainContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        mainContainer.add(separator);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 10)));

        // ============================================================
        
        List<CardData> secondCards = cardFilter.getFilteredCards(Constants.CSV_PATHS[1]);

        JPanel secondCardPanel = new JPanel();
        secondCardPanel.setLayout(new GridLayout(0, 2, 20, 20)); // 2 colunas, sem scroll lateral

        for (CardData cardData : secondCards) {
            CardComponent card = new CardComponent();
            card.setData(cardData.getGroup(), cardData.getInfo(), cardData.getDate(), cardData.getformat());
            secondCardPanel.add(card);
        }

        JScrollPane secondScrollPane = new JScrollPane(secondCardPanel);
        secondScrollPane.getVerticalScrollBar().setUnitIncrement(16); // velocidade de scroll
        secondScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        secondScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        secondScrollPane.setBorder(BorderFactory.createTitledBorder("Feed Geral"));

        secondScrollPane.setPreferredSize(new Dimension(0, Constants.SCREEN_HEIGHT - 300));

        mainContainer.add(secondScrollPane);

        add(mainContainer);
    }

}
