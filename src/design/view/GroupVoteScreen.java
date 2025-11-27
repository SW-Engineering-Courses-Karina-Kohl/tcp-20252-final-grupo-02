package design.view;

import javax.swing.*;
import java.awt.*;

import data.Constants;


public class GroupVoteScreen extends JFrame {

    public GroupVoteScreen(String Group) {
        setTitle("Group Vote Screen - " + Group);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel label = new JLabel("Votação para o grupo: " + Group);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }

}
