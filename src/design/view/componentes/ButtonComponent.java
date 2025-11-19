package design.view.componentes;

import javax.swing.*;
import javax.swing.border.LineBorder;

import data.constData.constants;

import java.awt.*;

public class ButtonComponent extends JButton {
     
    public ButtonComponent (String text) {
        super(text);

        setText(text);
        setBackground(constants.BLUE);
        // setForeground(constants.BLACK);
        setBorder(BorderFactory.createLineBorder(constants.DARK_BLUE, 2, true));
        setBorderPainted(true);
        setOpaque(true); // Necessário para a cor de fundo funcionar em alguns SOs
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setMaximumSize(new Dimension(constants.BUTTON_WIDTH, constants.BUTTON_HEIGHT));
        setPreferredSize(new Dimension(constants.BUTTON_WIDTH, constants.BUTTON_HEIGHT));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
