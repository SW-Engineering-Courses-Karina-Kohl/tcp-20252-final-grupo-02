package design.view.components;

import javax.swing.*;
import java.awt.*;

import data.Constants;
import com.toedter.calendar.JDateChooser;

public class DatePickerComponent extends JPanel {

    private JDateChooser dateChooser;

    public DatePickerComponent(String placeholder) {

        setLayout(new BorderLayout());
        setOpaque(false);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy hh:mm");
        dateChooser.setOpaque(false);
        dateChooser.getDateEditor().getUiComponent().setBackground(Constants.YELLOW);
        dateChooser.setPreferredSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH,Constants.DIMENSION_FIELD_HEIGHT));
        dateChooser.setMaximumSize(new Dimension(Constants.DIMENSION_FIELD_WIDTH,Constants.DIMENSION_FIELD_HEIGHT));

        // Estilo placeholder para o JDateChooser
        JTextField editor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        editor.setText(placeholder);
        editor.setForeground(Color.GRAY);

        editor.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (editor.getText().equals(placeholder)) {
                    editor.setText("");
                    editor.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (editor.getText().isEmpty()) {
                    editor.setText(placeholder);
                    editor.setForeground(Color.GRAY);
                }
            }
        });

        add(dateChooser, BorderLayout.CENTER);
    }

    public java.util.Date getDate() {
        return dateChooser.getDate();
    }

    public void setDate(java.util.Date date) {
        dateChooser.setDate(date);
    }
}
