package design.view.components;

import javax.swing.*;

import data.Constants;

import java.awt.*;

public class CardComponent extends JPanel {
	
	private static final long serialVersionUID = 1L;

    private JLabel lblTitle;
    private JLabel lblInfo;
    private JLabel lblDate;
    private JLabel lblFormat;

    public CardComponent() {
    	
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        setBackground(Constants.GREEN);
        setMaximumSize(new Dimension(300, 150));
        setPreferredSize(new Dimension(300, 150));
        setOpaque(true);

        lblTitle = new JLabel("");
        lblInfo = new JLabel("");
        lblDate = new JLabel("");
        lblFormat = new JLabel("");

        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblFormat.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(lblTitle);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(lblInfo);
        add(Box.createRigidArea(new Dimension(0, 35)));
        add(lblDate);
        add(lblFormat);
        
    }

    public void setData(String title, String info, String date, String format) {
    	
        lblTitle.setText(title);
        lblInfo.setText(info);
        lblDate.setText(date);
        lblFormat.setText(format);

        if (info.toLowerCase().contains("encerrado")) setBackground(Constants.RED);          
        else if (info.toLowerCase().contains("pending vote")) setBackground(Constants.YELLOW);    
        else setBackground(Constants.GREEN);

        setOpaque(true);
        repaint();
        
    }
    
}
