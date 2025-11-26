package com;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;


import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.tinylog.Logger;

import data.Constants;
import design.view.LoadingScreen;
import design.view.LoginScreen;

public class Main {
	
    public static void main(String[] args) {

        applyCustomFont();

		AppSystem appSystem = new AppSystem();

		appSystem.readBooks();
		appSystem.readUsers();

        SwingUtilities.invokeLater(() -> {
        	
            LoadingScreen loadingScreen = new LoadingScreen();
            loadingScreen.setVisible(true);

            javax.swing.Timer timer = new javax.swing.Timer (2000, e -> {
            	
				loadingScreen.dispose();
				
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
                
                LoginController loginController = new LoginController(loginScreen);
                
            });
			
			timer.setRepeats(false);
    		timer.start();

        });
        
    }

    private static void applyCustomFont() {
    	
        try {

            File customFontFile = new File(Constants.FONT_PATH);

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, customFontFile).deriveFont(16f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            setUIFont(customFont);

        } catch (FontFormatException | IOException e) {
        	
            Logger.error("Erro ao carregar arquivo de fonte: " + e.getMessage());
            
        }
        
    }

    public static void setUIFont(Font font) {
    	
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        
        while (keys.hasMoreElements()) {
        	
            Object key = keys.nextElement();
            Object value = UIManager.get(key);

            if (value instanceof Font) UIManager.put(key, font); 

        }
        
    }

}
