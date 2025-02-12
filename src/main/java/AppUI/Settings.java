package AppUI;
import AppLogic.AppTheme;

import javax.swing.*;
import java.awt.*;
public class Settings {
    private JPanel panel;
    private AppTheme themeManager;

    public Settings(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        applyTheme();

        JLabel label = new JLabel("Settings", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.NORTH);

        JTextArea settingsArea = new JTextArea(10, 30);
        settingsArea.setEditable(false);
        settingsArea.setText("Settings options will be available here.");
        panel.add(new JScrollPane(settingsArea), BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }
}

