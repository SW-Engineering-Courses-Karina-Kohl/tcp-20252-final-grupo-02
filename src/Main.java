
import design.view.LoadingScreen;
import design.view.LoginScreen;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.LoginController;
import data.Constants;

public class Main {

    public static void main(String[] args) {

        applyCustomFont();

        SwingUtilities.invokeLater(() -> {

            // FeedScreen feedScreen = new FeedScreen();
            // feedScreen.setVisible(true);

            LoadingScreen loadingScreen = new LoadingScreen();
            loadingScreen.setVisible(true);

            javax.swing.Timer timer = new javax.swing.Timer (2000, e -> {
                // Depois de 2s, abra a próxima tela
				loadingScreen.dispose();
                LoginScreen loginScreen = new LoginScreen();

                LoginController loginController = new LoginController(loginScreen);
                loginScreen.setVisible(true);
            });
			
			timer.setRepeats(false); // evita abrir várias telas
    		timer.start();

        });
    }

    private static void applyCustomFont() {
        try {
            // Caminho da fonte relativa ao projeto
            File fontFile = new File(Constants.FONT_PATH);

            // Carrega a fonte
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(16f);

            // Registra no ambiente gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Aplica globalmente no Swing
            setUIFont(customFont);

        } catch (FontFormatException | IOException e) {
            System.err.println("Erro ao carregar fonte: " + e.getMessage());
        }
    }

    // Torna a fonte global
    public static void setUIFont(Font font) {
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);

            if (value instanceof Font) {
                UIManager.put(key, font);
            }
        }
    }
}
