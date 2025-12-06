package design.view;

import javax.swing.*;

import data.Constants;

import java.awt.*;

public class LoadingScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
    public LoadingScreen() {
    	
        setTitle("Bookly - Carregando programa...");
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loadingPanel = new JPanel();
        loadingPanel.setLayout(new BoxLayout(loadingPanel, BoxLayout.Y_AXIS));
        loadingPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblLoadingText = new JLabel("CARREGANDO...");
        lblLoadingText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblLoadingGif = new JLabel("<html><img src='file:" + Constants.LOADING_GIF_PATH + "' width='"+ (Constants.LOAGING_WIDTH)+"' height='"+ (Constants.LOAGING_HEIGHT) +"'></html>");
        lblLoadingGif.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblLoadingGif.setHorizontalAlignment(SwingConstants.CENTER);

        loadingPanel.add(lblLoadingGif);
        loadingPanel.add(lblLoadingText);

        add(loadingPanel);
        
    }
    
}
