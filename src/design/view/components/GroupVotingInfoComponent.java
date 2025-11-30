package design.view.components;

import javax.swing.*;
import java.awt.*;

import data.Constants;

public class GroupVotingInfoComponent extends JPanel {

    public GroupVotingInfoComponent(String bookName, String dateLimit, String format, String participants) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        JLabel lblInfo = new JLabel("LIVRO A SER DEBATIDO");
        lblInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblInfo);

        JLabel lblBook = new JLabel(bookName);
        lblBook.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblBook.setOpaque(true);
        lblBook.setBackground(Constants.GREEN);
        lblBook.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        lblBook.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT + 15));
        lblBook.setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT + 15));
        add(lblBook);

        JLabel lblInfo2 = new JLabel("DATA LIMITE");
        lblInfo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lblInfo2);

        JLabel lblDate = new JLabel(dateLimit);
        lblDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblDate.setOpaque(true);
        lblDate.setBackground(Constants.GREEN);
        lblDate.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        lblDate.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT + 15));
        lblDate.setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT + 15));
        add(lblDate);

        InfoBarComponent info = new InfoBarComponent(format, participants, "");

        add(Box.createVerticalStrut(10));
        add(info);
    }
}
