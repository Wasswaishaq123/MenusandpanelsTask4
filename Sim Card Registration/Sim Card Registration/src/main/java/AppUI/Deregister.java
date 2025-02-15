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
        deregisterPanel.add(new JLabel("Enter SIM Number:"));
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
}