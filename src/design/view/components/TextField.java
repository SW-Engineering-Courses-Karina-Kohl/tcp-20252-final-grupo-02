package design.view.components;

import javax.swing.*;

import data.Constants;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextField extends JTextField {

	private static final long serialVersionUID = 1L;
	
    private String placeholder;
    private boolean showingPlaceholder = true;

    public TextField (String placeholder) {
        this.placeholder = placeholder;

        setBackground(Constants.YELLOW); 
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // setBorder(BorderFactory.createLineBorder(constants.BLACK, 2,true));
        setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));

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
