package design.view.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.Constants;

public class VoteComponent extends JPanel {

    public VoteComponent(List<String> options) {
        setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.CARD_HEIGHT));
        setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.CARD_HEIGHT));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < options.size(); i++) {

            JPanel line = new JPanel();
            line.setLayout(new BorderLayout());
            line.setBackground(Constants.GREEN);
            line.setOpaque(true);
            line.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            line.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT +15));
            line.setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT+15));

            JLabel lblOption = new JLabel(options.get(i));
            JRadioButton optionRadio = new JRadioButton();
            optionRadio.setOpaque(false);
            optionRadio.setActionCommand(options.get(i));


            group.add(optionRadio);

            line.add(lblOption, BorderLayout.WEST);
            line.add(optionRadio, BorderLayout.EAST);

            optionsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            optionsPanel.add(line);
        }
        add(optionsPanel);
    }
}
