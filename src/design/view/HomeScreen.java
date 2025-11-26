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
    	
        setTitle("Bookly - Página inicial");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        CardFilter cardFilter = new CardFilter();

        List<CardData> firstCards = cardFilter.getFilteredCards(Constants.CSV_PATHS[0]);

        JPanel firstCardPanel = new JPanel();
        firstCardPanel.setLayout(new GridLayout(0, 2, 10, 10));

        for (CardData cardData : firstCards) {
        	
            CardComponent card = new CardComponent()
            		;
            card.setData(cardData.getTitle(), cardData.getInfo(), cardData.getDate(), cardData.getFormat());
            firstCardPanel.add(card);
            
        }

        JScrollPane firstScrollPane = new JScrollPane(firstCardPanel);
        firstScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        firstScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        firstScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        firstScrollPane.setPreferredSize(new Dimension(0, 200));
        firstScrollPane.setBorder(BorderFactory.createTitledBorder("Clubes do livro que você participa"));

        mainContainer.add(firstScrollPane);

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        mainContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        mainContainer.add(separator);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        
        List<CardData> secondCards = cardFilter.getFilteredCards(Constants.CSV_PATHS[1]);

        JPanel secondCardPanel = new JPanel();
        secondCardPanel.setLayout(new GridLayout(0, 2, 20, 20));

        for (CardData cardData : secondCards) {
        	
            CardComponent card = new CardComponent();
            
            card.setData(cardData.getTitle(), cardData.getInfo(), cardData.getDate(), cardData.getFormat());
            secondCardPanel.add(card);
            
        }

        JScrollPane secondScrollPane = new JScrollPane(secondCardPanel);
        secondScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        secondScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        secondScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        secondScrollPane.setBorder(BorderFactory.createTitledBorder("Todos os clubes do livro"));
        secondScrollPane.setPreferredSize(new Dimension(0, Constants.SCREEN_HEIGHT - 300));

        mainContainer.add(secondScrollPane);

        add(mainContainer);
        
    }

}
