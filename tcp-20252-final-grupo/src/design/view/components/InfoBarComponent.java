package design.view.components;

import javax.swing.*;
import java.awt.*;

public class InfoBarComponent extends JPanel {

    public InfoBarComponent(String format, String participants, String timeLeft) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setOpaque(false);

        add(Box.createHorizontalGlue());
        add(new JLabel(format));
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(new JLabel(participants));
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(new JLabel(timeLeft));
        add(Box.createHorizontalGlue());
    }
}
