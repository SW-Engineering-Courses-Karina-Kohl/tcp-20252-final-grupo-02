package design.view.componentes;

import javax.swing.*;

import data.constData.constants;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextField extends JTextField {

    private String placeholder;
    private boolean showingPlaceholder = true;

    public TextField (String placeholder) {
        this.placeholder = placeholder;

        setBackground(constants.YELLOW); 
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // setBorder(BorderFactory.createLineBorder(constants.BLACK, 2,true));
        setMaximumSize(new Dimension(constants.DIMENSION_FIELD_WIDTH, constants.DIMENSION_FIELD_HEIGHT));
        setPreferredSize(new Dimension(constants.DIMENSION_FIELD_WIDTH, constants.DIMENSION_FIELD_HEIGHT));

        setText(placeholder);
        setForeground(Color.GRAY);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (showingPlaceholder) {
                    setText("");
                    setForeground(Color.BLACK);
                    showingPlaceholder = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY);
                    showingPlaceholder = true;
                }
            }
        });
    }

    @Override
    public String getText() {
        return showingPlaceholder ? "" : super.getText();
    }
}
