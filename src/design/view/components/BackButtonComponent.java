package design.view.components;

import javax.swing.*;
import java.awt.*;
import data.Constants;

public class BackButtonComponent extends JButton {

    public BackButtonComponent() {

        setText("X");
        setFocusPainted(true);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        // setForeground(Constants.BLACK);
        setBackground(Constants.RED);
        setPreferredSize(new Dimension(Constants.BACK_BUTTON_SIZE, Constants.BACK_BUTTON_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diameter = Math.min(getWidth(), getHeight()) - 4; // margem de 2 pixels
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        // CÍRCULO (fundo)
        g2.setColor(getBackground());
        g2.fillOval(x, y, diameter, diameter);

        // BORDA PRETA
        g2.setColor(Constants.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(x, y, diameter, diameter);

        // TEXTO "X" CENTRALIZADO
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();

        g2.drawString(
            getText(),
            getWidth() / 2 - textWidth / 2,
            getHeight() / 2 + textHeight / 3
        );

        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = getWidth() / 2;
        int centerX = radius;
        int centerY = radius;

        return (Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)) <= Math.pow(radius, 2);
    }
}