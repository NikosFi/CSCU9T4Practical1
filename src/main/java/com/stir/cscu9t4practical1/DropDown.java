package com.stir.cscu9t4practical1;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class DropDown
{

    static class MyComboBoxRenderer extends JLabel implements ListCellRenderer
    {
        private String _title;

        public MyComboBoxRenderer(String title)
        {
            _title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean hasFocus)
        {
            if (index == -1 && value == null) setText(_title);
            else setText(value.toString());

            if(index == 1){
                setForeground(new Color(145,123,16));
                setBackground(new Color(45,45,45));

            }
            if(index == 2){
                setForeground(new Color(77,105,205));
                setBackground(new Color(26,35,48));
            }
            if(index == 3){
                setForeground(new Color(137,71,255));
                setBackground(new Color(26,35,48));
            }
            if (isSelected) {
                setBackground(new Color(223,123,123));
            }
            return this;
        }


    }
}