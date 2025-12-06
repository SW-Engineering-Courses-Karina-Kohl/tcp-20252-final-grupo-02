package design.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.HomeController;
import com.model.BookClub;
import com.model.User;
import com.service.BookClubService;
import design.view.components.BackButtonComponent;
import design.view.components.CardComponent;
import data.Constants;

public class FeedScreen extends JFrame {

    public JButton btnBackButton;
    

    public FeedScreen(User loggedUser, BookClubService clubService) {
        
        setTitle("Feed Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel feedPanel = new JPanel();
        feedPanel.setLayout(new BoxLayout(feedPanel, BoxLayout.Y_AXIS));
        feedPanel.setBorder(BorderFactory.createEmptyBorder(60, 10, 10, 10));
        feedPanel.setBounds(0, Constants.BACK_BUTTON_BOUND_Y, getWidth(), getHeight());
        feedPanel.setOpaque(false);

    
        List<BookClub> availableGroups = clubService.getAllClubs().stream()
            .filter(club -> !club.getParticipants().contains(loggedUser)
                    && club.getCreator().getId() != loggedUser.getId())
            .toList();

        JPanel CardPanel = new JPanel();
        CardPanel.setLayout(new GridLayout(0, 3, 10, 10)); 
        CardPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        CardPanel.setOpaque(false);

        for (BookClub club : availableGroups) {
            CardComponent card = new CardComponent();
            card.setData(club.getName(),
                    "Membros: " + club.getParticipants().size(),
                    "", "");

          
                card.setOnCardClick(() -> {
                int option = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja entrar no grupo " + club.getName() + "?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    clubService.joinClub(club, loggedUser);
                    JOptionPane.showMessageDialog(this,
                            "Você entrou no grupo " + club.getName() + "!");
                    
                }
            });

            CardPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(CardPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(0, 200));
        scrollPane.setBorder(BorderFactory.createTitledBorder("Grupos Disponíveis"));
        feedPanel.add(scrollPane);

        JLayeredPane layered = getLayeredPane();
        add(feedPanel, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);
        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);

        btnBackButton.addActionListener(e -> {
            this.dispose(); 
            HomeScreen home = new HomeScreen();
            new HomeController(home, loggedUser, clubService); // recria o controller para atualizar os grupos
            home.setVisible(true);
        });

    }
}
