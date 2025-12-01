package design.view;

import javax.swing.*;
import java.awt.*;

import data.Constants;

import design.view.components.BackButtonComponent;
import design.view.components.ButtonComponent;

public class GroupManagementScreen extends JFrame {

    private String groupName;
    public JButton btnBackButton;
    public JButton btnNewVote;
    public JButton btnDeleteGroup;

    public GroupManagementScreen(String groupName) {
        this.groupName = groupName;
        setTitle("Group Management - " + groupName);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40, 30, 10, 30));
        main.setBounds(0, 10, getWidth(), getHeight());
        main.setOpaque(false);

        btnNewVote = new ButtonComponent("NOVA VOTAÇÃO");
        btnDeleteGroup = new ButtonComponent("DELETAR");

        btnNewVote.addActionListener(e -> {
            GroupManagementScreen.this.dispose();
            NewVoteScreen newVoteScreen = new NewVoteScreen(groupName);
            newVoteScreen.setVisible(true);
            // System.out.println("Criar nova votação para o grupo: " + groupName);
        });
        btnDeleteGroup.addActionListener(e -> {
            // Lógica para deletar o grupo
            GroupManagementScreen.this.dispose();
            DeleteGroupScreen deleteGroupScreen = new DeleteGroupScreen(groupName);
            deleteGroupScreen.setVisible(true);
        });

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.setOpaque(false);

        container.add(Box.createHorizontalGlue());
        container.add(btnDeleteGroup);
        container.add(Box.createRigidArea(new Dimension(20, 0)));
        container.add(btnNewVote);
        container.add(Box.createHorizontalGlue());

        JLabel lblGroupName = new JLabel(groupName);
        lblGroupName.setAlignmentX(Component.CENTER_ALIGNMENT);

        main.add(lblGroupName);
        main.add(Box.createRigidArea(new Dimension(0, 20)));
        main.add(Box.createVerticalGlue());
        main.add(container);
        main.add(Box.createVerticalGlue());

        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
    }

}
