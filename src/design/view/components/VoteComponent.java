package design.view.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import data.Constants;

public class VoteComponent extends JPanel {

    public VoteComponent(List<String> options) {
        setBackground(Constants.GREEN);
        setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.CARD_HEIGHT));
        setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.CARD_HEIGHT));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setOpaque(false);

        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < options.size(); i++) {

            JPanel line = new JPanel();
            line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
            line.setOpaque(false);
            line.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));

            JLabel lblOption = new JLabel(options.get(i));
            JRadioButton optionRadio = new JRadioButton();
            optionRadio.setOpaque(false);

            group.add(optionRadio);

            line.add(Box.createHorizontalGlue());
            line.add(lblOption);
            line.add(Box.createRigidArea(new Dimension(10, 0)));
            line.add(optionRadio);
            line.add(Box.createHorizontalGlue());

            optionsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            optionsPanel.add(line);
        }
        add(optionsPanel);
    }
}
