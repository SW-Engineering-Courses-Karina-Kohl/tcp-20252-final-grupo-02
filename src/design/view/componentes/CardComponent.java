package design.view.componentes;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import data.constData.constants;

public class CardComponent extends JPanel {

    private JLabel lblGroup;
    private JLabel lblInfo;
    private JLabel lblDate;
    private JLabel lblFormat;
    private Runnable onClickAction = null; // ação a ser executada ao clicar no card (tirei da net)

    public CardComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(constants.GREEN);
        setMaximumSize(new Dimension(constants.CARD_WIDTH, constants.CARD_HEIGHT));
        setPreferredSize(new Dimension(constants.CARD_WIDTH, constants.CARD_HEIGHT));
        setAlignmentY(CENTER_ALIGNMENT);
        setOpaque(true);

        lblGroup = new JLabel("");
        lblInfo = new JLabel("");
        lblDate = new JLabel("");
        lblFormat = new JLabel("");

        lblGroup.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblFormat.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(lblGroup);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(lblInfo);
        add(Box.createRigidArea(new Dimension(0, 35)));
        add(lblDate);
        add(lblFormat);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (onClickAction != null) {
                    onClickAction.run();
                }
            }
        });
    }

    // Permite definir a ação de clique no card
    public void setOnCardClick(Runnable action) {
        this.onClickAction = action;
    }

    public void setData(String group, String info, String date, String format) {
        lblGroup.setText(group);
        lblInfo.setText(info);
        lblDate.setText(date);
        lblFormat.setText(format);

        if (info.toLowerCase().contains("encerrado")) {
            setBackground(constants.RED);
        } else if (info.toLowerCase().contains("pending vote")) {
            setBackground(constants.YELLOW);
        } else {
            setBackground(constants.GREEN);
        }

        setOpaque(true);
        repaint();
    }

    public String getGroup() {
        return lblGroup.getText();
    }
    public String getInfo() {
        return lblInfo.getText();
    }
    public String getDate() {
        return lblDate.getText();
    }
    public String getFormat() {
        return lblFormat.getText();
    }
}
