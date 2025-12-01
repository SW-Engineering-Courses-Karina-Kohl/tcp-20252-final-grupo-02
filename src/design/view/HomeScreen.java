package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.CardData;
import data.CardFilter;
import design.view.components.ButtonComponent;
import data.Constants;
import design.view.components.CardComponent;

public class HomeScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    public JButton btnMyGroups;
    public JButton btnShowMyGroups;
    public JButton btnEnterGroup;
    private JPanel firstCardPanel;
    private JScrollPane firstScrollPane;
    private JPanel secondCardPanel;
	
    public HomeScreen() {
        setTitle("Home Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ============================================================

        firstCardPanel = new JPanel();
        firstCardPanel.setLayout(new GridLayout(0, 2, 10, 10));// Uma coluna, varias linhas
        firstCardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        firstScrollPane = new JScrollPane(firstCardPanel);
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
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));
        buttonsContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonsContainer.setPreferredSize(new Dimension(Constants.BUTTON_WIDTH, 0));
        buttonsContainer.setMaximumSize(new Dimension(Constants.BUTTON_WIDTH, Integer.MAX_VALUE));
        buttonsContainer.setMinimumSize(new Dimension(Constants.BUTTON_WIDTH, 0));

        btnMyGroups = new ButtonComponent("MEUS GRUPOS");
        btnMyGroups.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnShowMyGroups = new ButtonComponent("VER GRUPOS");
        btnShowMyGroups.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEnterGroup = new ButtonComponent("ENTRAR");
        btnEnterGroup.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsContainer.add(Box.createVerticalGlue()); 
        buttonsContainer.add(btnMyGroups);
        buttonsContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsContainer.add(btnShowMyGroups);
        buttonsContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsContainer.add(btnEnterGroup);
        buttonsContainer.add(Box.createVerticalGlue());


        secondCardPanel = new JPanel();
        secondCardPanel.setLayout(new GridLayout(0, 2, 20, 20)); // 2 colunas, sem scroll lateral
        secondCardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        JScrollPane secondScrollPane = new JScrollPane(secondCardPanel);
        secondScrollPane.getVerticalScrollBar().setUnitIncrement(16); // velocidade de scroll
        secondScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        secondScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        secondScrollPane.setBorder(BorderFactory.createTitledBorder("Feed Geral"));

        secondScrollPane.setPreferredSize(new Dimension(0, Constants.SCREEN_HEIGHT - 300));

        JPanel secondContainer = new JPanel(new BorderLayout(10, 10));
        secondContainer.add(secondScrollPane, BorderLayout.CENTER);
        secondContainer.add(buttonsContainer, BorderLayout.EAST);

        mainContainer.add(secondContainer);
        add(mainContainer);
    }

    // converte BookClub -> CardComponent e popula painel
    public void populateMyGroups(java.util.List<com.model.BookClub> myClubs) {
    
        for (com.model.BookClub bc : myClubs) {
         design.view.components.CardComponent card = new design.view.components.CardComponent();
            // adapte os getters conforme seu CardComponent espera:
            // por exemplo: card.setData(groupName, info, date, format)
            String groupName = bc.getName();
            String info = "Membros: " + bc.getParticipants().size();
         String date = ""; // se tiver data relevante
         String format = ""; // qualquer formatação que usar

            card.setData(groupName, info, date, format);
            firstCardPanel.add(card);
        }
        firstCardPanel.revalidate();
        firstCardPanel.repaint();
        
    }

    public void populateGeneralFeed(java.util.List<com.model.BookClub> allClubs, com.model.User loggedUser) {
        secondCardPanel.removeAll(); // limpa antes de popular

        for (com.model.BookClub bc : allClubs) {
            // ignora os grupos do próprio usuário
            if (bc.getCreator().getId() == loggedUser.getId() || bc.getParticipants().contains(loggedUser)) {
                continue;
            }

            design.view.components.CardComponent card = new design.view.components.CardComponent();
            String groupName = bc.getName();
            String info = "Membros: " + bc.getParticipants().size();
            String date = "";   // ou alguma data relevante
            String format = ""; // ou alguma info de formato

            card.setData(groupName, info, date, format);
            secondCardPanel.add(card);
        }

        secondCardPanel.revalidate();
        secondCardPanel.repaint();
    }



}
