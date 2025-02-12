package AppUI;

import javax.swing.*;
import java.awt.*;
import AppLogic.*;// Importing ThemeManager

public class Home {
    private JPanel panel;
    private AppTheme themeManager;

    public Home(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        applyTheme();

        JLabel label = new JLabel("Welcome to the SIM Card Registration System", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }
}