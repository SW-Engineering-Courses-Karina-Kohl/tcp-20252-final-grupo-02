package data;

import java.awt.*;

public class Constants {

    public static final Color YELLOW = new Color(255, 236, 153); // #FFEC99
    public static final Color RED = new Color(255, 201, 201); // #FFC9C9
    public static final Color GREEN = new Color(178, 242, 187); // #B2F2BB
    public static final Color BLUE = new Color(165, 216, 255); // #A5D8FF
    public static final Color DARK_BLUE = new Color(129, 170, 201); // #81AAC9
    public static final Color BLACK = new Color(50, 50, 50); // #323232

    public static final int SCREEN_WIDTH;
    public static final int SCREEN_HEIGHT;
    public static final int LOAGING_WIDTH;
    public static final int LOAGING_HEIGHT;
    
    public static final int BUTTON_WIDTH = 150;
    public static final int BUTTON_HEIGHT = 40;
    public static final int DIMENSION_FIELD_WIDTH = 350;
    public static final int DIMENSION_FIELD_HEIGHT = 40;
    
    public static final String FONT_PATH = "src/design/font/Excalifont-Regular.otf";
    public static final String LOADING_GIF_PATH = "src/design/view/assets/loading.gif";
    public static final String USERS_PATH = "src/data/files/Users.csv";
    public static final String BOOKS_PATH = "src/data/files/Books.csv";
    public static final String HOME_CONTENT_PATH = "src/data/files/HomeContent.csv";
    public static final String USER_CONTENT_PATH = "src/data/files/UserContent.csv";
    
    public static final int USERS_ENTRIES_PER_LINE = 5;

    static {
    
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        SCREEN_WIDTH = (int) Math.round(screenSize.width * 0.8);
        SCREEN_HEIGHT = (int) Math.round(screenSize.height * 0.8);

        LOAGING_WIDTH = (int) Math.round(SCREEN_WIDTH * 0.4);
        LOAGING_HEIGHT = (int) Math.round(SCREEN_WIDTH * 0.4);
        
    }
    
}
