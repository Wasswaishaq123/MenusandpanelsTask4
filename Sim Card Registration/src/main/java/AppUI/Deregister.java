package AppUI;

import javax.swing.*;
import java.awt.*;
import AppLogic.*;

public class Deregister {
    private JPanel panel;
    private AppTheme themeManager;

    public Deregister(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        applyTheme();

        JLabel label = new JLabel("Deregister SIM Card", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.NORTH);

        JTextField simNumberField = new JTextField(20);
        JButton deregisterButton = new JButton("Deregister");
        deregisterButton.addActionListener(e -> {
            String simNumber = simNumberField.getText();
            JOptionPane.showMessageDialog(panel, "SIM Card " + simNumber + " deregistered.");
        });

        JPanel deregisterPanel = new JPanel();
        // Fixed the line to create a JLabel with icon and text
        JLabel phoneLabel = new JLabel("Enter SIM Number:", resizeIcon("src/main/resources/icons/phone.png", 20, 20), JLabel.LEFT);
        deregisterPanel.add(phoneLabel);
        deregisterPanel.add(simNumberField);
        deregisterPanel.add(deregisterButton);
        panel.add(deregisterPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }

    // Helper method to resize the icon
    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
