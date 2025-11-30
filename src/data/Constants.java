package data;

import java.awt.*;

/*  

cores (transparencia 70%)
vermelho sair e grupo encerrado - #ffc9c9
amarelo campos de informação - #ffec99
verde grupo votação encerrada e infos do grupo - #b2f2bb
azul botoes - #a5d8ff 

 */
public class Constants {

    public static final Color YELLOW = new Color(255, 236, 153); // #ffec99
    public static final Color RED = new Color(255, 201, 201); // #ffc9c9
    public static final Color GREEN = new Color(178, 242, 187); // #b2f2bb
    public static final Color BLUE = new Color(165, 216, 255); // #a5d8ff
    public static final Color DARK_BLUE = new Color(129, 170, 201); // #81aac9
    public static final Color BLACK = new Color(50, 50, 50); // #323232
    public static final Color WHITE = new Color(238, 238, 238); // #eeeeee

    // Configurações de tamanho da Janela Principal com base na tela do usuário
    // Utiliza 80% da largura e altura da tela com tookit e dimension
    public static final int SCREEN_WIDTH;
    public static final int SCREEN_HEIGHT;
    public static final int LOAGING_WIDTH;
    public static final int LOAGING_HEIGHT;

    static { //  descobri que da pra fazer bloco estatico... fazer para os acima
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        SCREEN_WIDTH = (int) Math.round(screenSize.width * 0.8);
        SCREEN_HEIGHT = (int) Math.round(screenSize.height * 0.8);
        BACK_BUTTON_BOUND_X = SCREEN_WIDTH - 90;

        LOAGING_WIDTH = (int) Math.round(SCREEN_WIDTH * 0.4);
        LOAGING_HEIGHT = (int) Math.round(SCREEN_WIDTH * 0.4);
    }

    public static final String FONT_PATH = "src/design/font/Excalifont-Regular.otf";
    public static final String LOADING_GIF_PATH = "src/design/view/assets/loading.gif";
    public static final String[] CSV_PATHS = {
        "src/data/files/HomeContent.csv",
        "src/data/files/UserContent.csv",
        "src/data/files/Pending.csv"
    };

    public static final int BUTTON_WIDTH = 150;
    public static final int BUTTON_HEIGHT = 40;
    public static final int CARD_WIDTH = 300;
    public static final int CARD_HEIGHT = 150;
    public static final int DIMENSION_FIELD_WIDTH = 350;
    public static final int DIMENSION_FIELD_HEIGHT = 40;
    public static final int BACK_BUTTON_SIZE = 40;
    public static final int BACK_BUTTON_BOUND_X;
    public static final int BACK_BUTTON_BOUND_Y = 60;
}
