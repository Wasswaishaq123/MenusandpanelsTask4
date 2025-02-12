package AppUI;

import javax.swing.*;
import java.awt.*;
import AppLogic.*; // Importing ThemeManager

public class Details {
    private JPanel panel;
    private AppTheme themeManager;

    public Details(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        applyTheme();

        JLabel label = new JLabel("SIM Card Registration Details", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.CENTER);

        JTextArea detailsArea = new JTextArea(10, 30);
        detailsArea.setEditable(false);
        detailsArea.setText("Details about the registered SIM cards will be displayed here.");
        panel.add(new JScrollPane(detailsArea), BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }
}