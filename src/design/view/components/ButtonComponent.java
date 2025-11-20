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
        // setForeground(constants.BLACK);
        setBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 2, true));
        setBorderPainted(true);
        setOpaque(true); // Necessário para a cor de fundo funcionar em alguns SOs
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setMaximumSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
        setPreferredSize(new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }
    
}
