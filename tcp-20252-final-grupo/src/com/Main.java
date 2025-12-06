package com;

import data.Constants;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        applyCustomFont();

        AppController app = new AppController();
        app.start();
    }

    private static void applyCustomFont() {
        try {
            File fontFile = new File(Constants.FONT_PATH);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(16f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            setUIFont(customFont);

        } catch (FontFormatException | IOException e) {
            System.err.println("Erro ao carregar fonte: " + e.getMessage());
        }
    }

    public static void setUIFont(Font font) {
        java.util.Enumeration<Object> keys = javax.swing.UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = javax.swing.UIManager.get(key);

            if (value instanceof Font) {
                javax.swing.UIManager.put(key, font);
            }
        }
    }
}
