package design.view;

import javax.swing.*;
import java.awt.*;

import data.constData.constants;

public class LoadingScreen extends JFrame {

    public LoadingScreen() {
        setTitle("Loading Screen");
        setSize(constants.SCREEN_WIDTH, constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loadingScreen = new JPanel();
        loadingScreen.setLayout(new BoxLayout(loadingScreen, BoxLayout.Y_AXIS));
        loadingScreen.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel loadingLabel = new JLabel("CARREGANDO...");
        loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel loadingGifLabel = new JLabel(
                "<html><img src='file:" + constants.LOADING_GIF_PATH + "' width='"+ (constants.LOAGING_WIDTH)+"' height='"+ (constants.LOAGING_HEIGHT) +"'></html>");
        loadingGifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadingGifLabel.setHorizontalAlignment(SwingConstants.CENTER);

        loadingScreen.add(loadingGifLabel);
        loadingScreen.add(loadingLabel);

        add(loadingScreen);
    }
}
