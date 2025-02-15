package AppUI;

import javax.swing.*;
import java.awt.*;
import AppLogic.*;

public class Home {
    private JPanel panel;
    private AppTheme themeManager;

    public Home(AppTheme themeManager, AddUser addUserPanel, AppFrame appFrame) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        applyTheme();

        JLabel label = new JLabel("Welcome to the SIM Card Registration System", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.NORTH);

        JPanel servicePanel = new JPanel();
        servicePanel.setLayout(new FlowLayout());
        JLabel serviceLabel = new JLabel("Select Service Provider:");
        String[] providers = {"Airtel", "MTN", "Vodafone", "Safaricom", "Tigo", "Others"};
        JComboBox<String> providerBox = new JComboBox<>(providers);
        JButton submitButton = new JButton("Proceed");

        servicePanel.add(serviceLabel);
        servicePanel.add(providerBox);
        servicePanel.add(submitButton);

        panel.add(servicePanel, BorderLayout.CENTER);

        submitButton.addActionListener(e -> {
            String selectedProvider = (String) providerBox.getSelectedItem();
            addUserPanel.setSelectedProvider(selectedProvider);
            appFrame.switchPanel("AddUser");
            JOptionPane.showMessageDialog(panel, "You selected: " + selectedProvider);
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }
}
