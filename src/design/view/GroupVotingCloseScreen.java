package design.view;

import javax.swing.*;
import java.awt.*;

import data.Constants;
import design.view.components.BackButtonComponent;
import design.view.components.GroupVotingInfoComponent;

public class GroupVotingCloseScreen extends JFrame {

    private JButton btnBackButton;

    public GroupVotingCloseScreen(String Group, String Info) {
        setTitle("Group Close Screen - " + Group);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        main.setOpaque(true);
        main.setBounds(0, -Constants.BACK_BUTTON_BOUND_Y, getWidth(), getHeight());

        JLabel lblGroupName = new JLabel(Group);
        lblGroupName.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(lblGroupName);

        //logica para verificar se o grupo está encerrado
        if (Info.equals("Encerrado")) {
            JLabel lblClose = new JLabel();
            lblClose.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
            lblClose.setText("Encerrado em : DATA");
            lblClose.setOpaque(true);

            main.add(lblClose);
        } else {
            // temos que mudar aqui
            GroupVotingInfoComponent infoComponent
                    = new GroupVotingInfoComponent(
                            "NOME DO LIVRO",
                            "DATA",
                            "Presencial",
                            "15 participantes"
                    );

            main.add(infoComponent);

        }

        add(main, BorderLayout.CENTER);

        JLayeredPane layered = getLayeredPane();

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
    }

}
