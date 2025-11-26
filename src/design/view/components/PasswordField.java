package design.view.components;

import javax.swing.*;

import data.Constants;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PasswordField extends JPasswordField {

	private static final long serialVersionUID = 1L;
	
    private String placeholder;
    private boolean isPlaceholderVisible = true;

    public PasswordField (String placeholder) {
    	
        this.placeholder = placeholder;

        setBackground(Constants.YELLOW); 
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));
        setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH, Constants.DIMENSION_FIELD_HEIGHT));

        setText(this.placeholder);
        setForeground(Color.GRAY);

        addFocusListener(new FocusListener() {
        	
        	@Override
            public void focusGained(FocusEvent e) {
        		
                if (isPlaceholderVisible) {
                	
                    setText("");
                    setForeground(Color.BLACK);
                    isPlaceholderVisible = false;
                    
                }
                
            }

            @Override
            public void focusLost(FocusEvent e) {
            	
                if (getText().isEmpty()) {
                	
                    setText(placeholder);
                    setForeground(Color.GRAY);
                    isPlaceholderVisible = true;
                    
                }
                
            }
            
        });
        
    }

    @Override
    public String getText() {
    	
    	if (isPlaceholderVisible) return "";

    	return super.getText();
        
    }
    
}
