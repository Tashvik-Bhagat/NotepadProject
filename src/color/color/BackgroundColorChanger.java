package color;

import javax.swing.*;
import java.awt.*;

public class BackgroundColorChanger {
    private JTextArea textArea;

    public BackgroundColorChanger(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void changeBackgroundColor() {
        Color newColor = JColorChooser.showDialog(null, "Select Background Color", textArea.getBackground());
        if (newColor != null) {
            textArea.setBackground(newColor);
        }
    }
}
