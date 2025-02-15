package AppUI;

import javax.swing.*;
import java.awt.*;
import AppLogic.*;

public class User {
    private JPanel panel;
    private AppTheme themeManager;

    public User(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(null);
        applyTheme();

        JLabel profilePicLabel = new JLabel(resizeIcon("src/main/resources/icons/user.png", 100, 100));
        profilePicLabel.setBounds(200, 10, 100, 100);
        profilePicLabel.setOpaque(true);
        profilePicLabel.setBackground(Color.WHITE);
        profilePicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profilePicLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(profilePicLabel);

        JLabel nameLabel = new JLabel(resizeIcon("src/main/resources/icons/user.png", 20, 20));
        JLabel nameValue = new JLabel("Ikuzo Caleb");
        nameValue.setFont(new Font("Calibri", Font.BOLD, 20));
        addComponent(nameLabel, nameValue, 130);

        JLabel emailLabel = new JLabel(resizeIcon("src/main/resources/icons/mail.png", 20, 20));
        JLabel emailValue = new JLabel("cnzabb@gmail.com");
        emailValue.setFont(new Font("Calibri", Font.BOLD, 20));
        addComponent(emailLabel, emailValue, 180);

        JLabel phoneLabel = new JLabel(resizeIcon("src/main/resources/icons/phone.png", 20, 20));
        JLabel phoneValue = new JLabel("+256 767579099");
        phoneValue.setFont(new Font("Calibri", Font.BOLD, 20));
        addComponent(phoneLabel, phoneValue, 210);

        JLabel countryLabel = new JLabel(resizeIcon("src/main/resources/icons/country-icon.png", 20, 20));
        JLabel countryValue = new JLabel("Uganda");
        countryValue.setFont(new Font("Calibri", Font.BOLD, 20));
        addComponent(countryLabel, countryValue, 260);
    }

    private void addComponent(JLabel iconLabel, JLabel valueLabel, int yPosition) {
        iconLabel.setBounds(200, yPosition, 20, 20);
        valueLabel.setBounds(250, yPosition, 200, 20);
        panel.add(iconLabel);
        panel.add(valueLabel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
