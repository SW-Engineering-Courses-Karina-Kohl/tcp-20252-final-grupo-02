package design.view;

import javax.swing.*;
import java.awt.*;

import data.Constants;

public class GroupVotingCloseScreen extends JFrame {

    public GroupVotingCloseScreen(String Group, String Info) {
        setTitle("Group Close Screen - " + Group);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(40, 30, 40, 30));

        // System.out.println(Info);
        //logica para verificar se o grupo está encerrado
        if (Info.equals("Encerrado")) {
            JLabel lblClose = new JLabel();
            lblClose.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
            lblClose.setText("Encerrado em : DATA");
            lblClose.setOpaque(true);
            lblClose.setHorizontalAlignment(SwingConstants.CENTER);
            lblClose.setBackground(Constants.RED);

            main.add(lblClose);
        } else {
            JLabel label = new JLabel("Livro a ser debatido");
            label.setHorizontalAlignment(SwingConstants.CENTER);

            main.add(label);
        }

        add(main);
    }

}
