package design.view;

import javax.swing.*;

import data.Constants;

import java.awt.*;

public class LoadingScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
    public LoadingScreen() {
        setTitle("Loading Screen");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loadingScreen = new JPanel();
        loadingScreen.setLayout(new BoxLayout(loadingScreen, BoxLayout.Y_AXIS));
        loadingScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel loadingLabel = new JLabel("CARREGANDO...");
        loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel loadingGifLabel = new JLabel(
                "<html><img src='file:" + Constants.LOADING_GIF_PATH + "' width='"+ (Constants.LOAGING_WIDTH)+"' height='"+ (Constants.LOAGING_HEIGHT) +"'></html>");
        loadingGifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadingGifLabel.setHorizontalAlignment(SwingConstants.CENTER);

        loadingScreen.add(loadingGifLabel);
        loadingScreen.add(loadingLabel);

        add(loadingScreen);
    }
}
