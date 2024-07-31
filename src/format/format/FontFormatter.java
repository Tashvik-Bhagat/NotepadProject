package format;

import javax.swing.*;
import java.awt.*;

public class FontFormatter {
    private JTextArea textArea;

    public FontFormatter(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void setFontSize() {
        String sizeStr = JOptionPane.showInputDialog("Enter Font Size:");
        if (sizeStr != null) {
            try {
                int size = Integer.parseInt(sizeStr);
                textArea.setFont(textArea.getFont().deriveFont((float) size));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setFontType() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String font = (String) JOptionPane.showInputDialog(null, "Select Font", "Font Selection", JOptionPane.QUESTION_MESSAGE, null, fonts, textArea.getFont().getFamily());
        if (font != null) {
            textArea.setFont(new Font(font, Font.PLAIN, textArea.getFont().getSize()));
        }
    }
}
