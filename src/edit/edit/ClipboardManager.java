package edit;

import javax.swing.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class ClipboardManager {
    private JTextArea textArea;

    public ClipboardManager(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void cut() {
        textArea.cut();
    }

    public void copy() {
        textArea.copy();
    }

    public void paste() {
        textArea.paste();
    }
}
