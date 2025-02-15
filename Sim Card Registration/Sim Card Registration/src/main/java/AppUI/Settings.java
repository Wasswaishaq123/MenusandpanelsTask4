package AppUI;
import AppLogic.AppTheme;

import javax.swing.*;
import java.awt.*;

public class Settings {
    private JPanel panel;
    private AppTheme themeManager;
    private JFrame frame;

    public Settings(AppTheme themeManager) {
        this.themeManager = themeManager;
        this.frame = frame;
        panel = new JPanel();
        panel.setLayout(null);
        applyTheme();

        JLabel label = new JLabel("Settings", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(250, 20, 300, 30);
        panel.add(label);

        JButton changeThemeButton = new JButton("Change Theme");
        JButton changePasswordButton = new JButton("Change Password");
        JButton changeUserButton = new JButton("Switch User");
        JButton logoutButton = new JButton("Logout");

        changeThemeButton.setBounds(250, 80, 300, 40);
        changePasswordButton.setBounds(250, 140, 300, 40);
        changeUserButton.setBounds(250, 200, 300, 40);
        logoutButton.setBounds(250, 260, 300, 40);

        panel.add(changeThemeButton);
        panel.add(changePasswordButton);
        panel.add(changeUserButton);
        panel.add(logoutButton);

        changeThemeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Theme change functionality coming soon!");
        });

        changePasswordButton.addActionListener(e -> {
            String newPassword = JOptionPane.showInputDialog(panel, "Enter new password:");
            if (newPassword != null && !newPassword.trim().isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Password changed successfully!");
            } else {
                JOptionPane.showMessageDialog(panel, "Password change cancelled.");
            }
        });

        changeUserButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Switching user...");
        });

        logoutButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(panel, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(new Login(themeManager, frame).getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }

    private static class Login {
        private JPanel panel;

        public Login(AppTheme themeManager, JFrame frame) {
            panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JLabel label = new JLabel("Login Page", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            panel.add(label, BorderLayout.NORTH);
        }

        public JPanel getPanel() {
            return panel;
        }
    }
}