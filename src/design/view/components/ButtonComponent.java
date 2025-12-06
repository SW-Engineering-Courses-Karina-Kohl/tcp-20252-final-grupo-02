package design.view.components;

import javax.swing.*;

import data.Constants;

import java.awt.*;

public class ButtonComponent extends JButton {
     
	private static final long serialVersionUID = 1L;

	public ButtonComponent (String text) {
    	
        super(text);

        setText(text);
        setBackground(Constants.BLUE);
        setBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 2, true));
        setBorderPainted(true);
        setOpaque(true);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setMaximumSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
        setPreferredSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }
    
}
