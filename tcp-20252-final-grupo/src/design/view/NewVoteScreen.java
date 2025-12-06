package design.view;

import javax.swing.*;

import com.GroupUserScreenController;

import java.awt.*;

import data.Constants;
import design.view.components.ButtonComponent;
import design.view.components.BackButtonComponent;
import design.view.components.TextField;

public class NewVoteScreen extends JFrame {

    private TextField txtCodeConfirm;
    private String codeConfirm = String.valueOf((int)(Math.random() * 10000)); // gerar um codigo aleatório
    private JButton btnAlterButton;
    private JButton btnBackButton;

    public NewVoteScreen(String group, com.model.User loggedUser, com.service.BookClubService clubService) {
        setTitle("New Vote Screen - " + group);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40,30,40,30));
        main.setBounds(0, 10, getWidth(), getHeight());
        main.setOpaque(false);

        JLabel lblGroupName = new JLabel(group);
        lblGroupName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lbLabellConfirm = new JLabel("Realmente deseja alterar o Livro e data do grupo "+group+"?");
        lbLabellConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JRadioButton rbYes = new JRadioButton("Sim");
        rbYes.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JLabel lblCodeConfirm = new JLabel("Código de confirmação: "+codeConfirm);
        lblCodeConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtCodeConfirm = new TextField("Digite o código de confirmação");
        container.add(lblCodeConfirm);
        container.add(txtCodeConfirm);

        btnAlterButton = new ButtonComponent("ALTERAR");
        // transferir isso pra uma classe separada pra validar
        btnAlterButton.addActionListener(e -> {
                    String enteredCode = txtCodeConfirm.getText();
                    if (enteredCode.equals(codeConfirm) && rbYes.isSelected()) {
                        System.out.println("Alterando o grupo: " + group);
                        NewVoteScreen.this.dispose();
                        GroupCreationScreen groupCreationScreen = new GroupCreationScreen(loggedUser, clubService);
                        groupCreationScreen.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Código incorreto ou opção não selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                });

        main.add(Box.createVerticalGlue());
        main.add(lblGroupName);
        main.add(Box.createRigidArea(new Dimension(0, 50)));
        main.add(lbLabellConfirm);
        main.add(Box.createRigidArea(new Dimension(0, 50)));
        main.add(rbYes);
        main.add(Box.createRigidArea(new Dimension(0, 50)));
        main.add(container);
        main.add(Box.createRigidArea(new Dimension(0, 50)));
        main.add(btnAlterButton);
        main.add(Box.createVerticalGlue());

        JLayeredPane layered = getLayeredPane();
        add(main, BorderLayout.CENTER);

        btnBackButton = new BackButtonComponent();
        btnBackButton.setSize(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE);
        btnBackButton.setLocation(Constants.SCREEN_WIDTH - (Constants.BACK_BUTTON_SIZE * 2), 0);

        layered.add(btnBackButton, JLayeredPane.PALETTE_LAYER);
        
		btnBackButton.addActionListener(e -> {
			
			NewVoteScreen.this.dispose();
			
            GroupManagementScreen groupManagementScreen = new GroupManagementScreen(group, loggedUser, clubService);
            groupManagementScreen.setVisible(true);

		});
        
    }
    
}
