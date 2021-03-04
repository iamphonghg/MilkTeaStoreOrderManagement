package view;

import model.MyFont;

import javax.swing.*;
import java.awt.*;

public class FunctionButton extends JButton {
    public String namePanelDisplay;
    public FunctionButton(String nameButton, String namePanelDisplay) {
        this.setText(nameButton);
        this.setFont(MyFont.MAIN_FONT_BIGGER);
        this.setForeground(Color.WHITE);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setBackground(null);
        this.namePanelDisplay = namePanelDisplay;
    }

    public String getNamePanelDisplay() {
        return namePanelDisplay;
    }
}
