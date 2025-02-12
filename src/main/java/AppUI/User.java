package AppUI;
import AppLogic.AppTheme;
import javax.swing.*;
import java.awt.*;
import AppLogic.*;

public class User {
    private JPanel panel;
    private AppTheme themeManager;

    public User(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        applyTheme();

        JLabel label = new JLabel("User  Information", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.NORTH);

        JTextArea userInfoArea = new JTextArea(10, 30);
        userInfoArea.setEditable(false);
        userInfoArea.setText("User  information will be displayed here.");
        panel.add(new JScrollPane(userInfoArea), BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }
}

