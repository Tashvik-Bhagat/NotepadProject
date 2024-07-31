package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import file.FileOperations;
import edit.ClipboardManager;
import format.FontFormatter;
import color.BackgroundColorChanger;

public class NotepadGUI extends JFrame implements ActionListener {
    private JTextArea textArea;
    private ClipboardManager clipboardManager;
    private FontFormatter fontFormatter;
    private BackgroundColorChanger colorChanger;
    private FileOperations fileOperations;

    public NotepadGUI() {
        // Initialize components
        textArea = new JTextArea();
        clipboardManager = new ClipboardManager(textArea);
        fontFormatter = new FontFormatter(textArea);
        colorChanger = new BackgroundColorChanger(textArea);
        fileOperations = new FileOperations(this, textArea);

        // Set up the frame
        setTitle("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu formatMenu = new JMenu("Format");
        JMenu colorMenu = new JMenu("Color");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(colorMenu);

        // File menu items
        addMenuItem(fileMenu, "New");
        addMenuItem(fileMenu, "Open");
        addMenuItem(fileMenu, "Save");
        addMenuItem(fileMenu, "Save As");
        addMenuItem(fileMenu, "Exit");

        // Edit menu items
        addMenuItem(editMenu, "Cut");
        addMenuItem(editMenu, "Copy");
        addMenuItem(editMenu, "Paste");

        // Format menu items
        addMenuItem(formatMenu, "Font Size");
        addMenuItem(formatMenu, "Font Type");
        addMenuItem(formatMenu, "Word Wrap");

        // Color menu items
        addMenuItem(colorMenu, "Change Background Color");

        // Add components to frame
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setVisible(true);
    }

    private void addMenuItem(JMenu menu, String itemName) {
        JMenuItem menuItem = new JMenuItem(itemName);
        menuItem.addActionListener(this);
        menu.add(menuItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                textArea.setText("");
                break;
            case "Open":
                fileOperations.openFile();
                break;
            case "Save":
                fileOperations.saveFile();
                break;
            case "Save As":
                fileOperations.saveFileAs();
                break;
            case "Exit":
                System.exit(0);
                break;
            case "Cut":
                clipboardManager.cut();
                break;
            case "Copy":
                clipboardManager.copy();
                break;
            case "Paste":
                clipboardManager.paste();
                break;
            case "Font Size":
                fontFormatter.setFontSize();
                break;
            case "Font Type":
                fontFormatter.setFontType();
                break;
            case "Word Wrap":
                textArea.setLineWrap(!textArea.getLineWrap());
                break;
            case "Change Background Color":
                colorChanger.changeBackgroundColor();
                break;
        }
    }
}
