package design.view.componentes;

import javax.swing.*;
import java.awt.*;
import data.constData.constants;

public class CardComponent extends JPanel {

    private JLabel lblGroup;
    private JLabel lblInfo;
    private JLabel lblDate;
    private JLabel lblFormat;

    public CardComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        setBackground(constants.GREEN);
        setMaximumSize(new Dimension(300, 150));
        setPreferredSize(new Dimension(300, 150));
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
}
