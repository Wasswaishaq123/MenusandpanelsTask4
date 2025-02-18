package AppUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import AppLogic.*;

public class AddUser {
    private JPanel panel;
    private AppTheme themeManager;
    private Map<String, String> countryCodes;
    private Details detailsPanel;
    private String selectedProvider;

    public AddUser(AppTheme themeManager, Details detailsPanel) {
        this.themeManager = themeManager;
        this.detailsPanel = detailsPanel;
        panel = new JPanel();
        panel.setLayout(null);
        applyTheme();

        initializeCountryCodes();

        JLabel label = new JLabel("Add User");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(150, 10, 200, 30);
        panel.add(label);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 25);
        JTextField nameField = new JTextField(20);
        nameField.setBounds(150, 50, 200, 25);
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 90, 100, 25);
        JTextField emailField = new JTextField(20);
        emailField.setBounds(150, 90, 200, 25);
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 130, 100, 25);
        JTextField phoneField = new JTextField(20);
        phoneField.setBounds(150, 130, 200, 25);
        panel.add(phoneLabel);
        panel.add(phoneField);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(50, 170, 100, 25);
        String[] countries = {"Uganda", "Kenya", "Congo", "Somali", "Ghana", "Sudan", "South Sudan", "Others"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        countryBox.setBounds(150, 170, 200, 25);
        panel.add(countryLabel);
        panel.add(countryBox);

        countryBox.addActionListener(e -> {
            String selectedCountry = (String) countryBox.getSelectedItem();
            String countryCode = countryCodes.getOrDefault(selectedCountry, "+");
            phoneField.setText(generatePhoneNumber(countryCode));
        });

        JLabel idLabel = new JLabel("National ID/Passport:");
        idLabel.setBounds(50, 210, 150, 25);
        JTextField idField = new JTextField(20);
        idField.setBounds(150, 210, 200, 25);
        panel.add(idLabel);
        panel.add(idField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 250, 100, 30);
        panel.add(submitButton);

        submitButton.addActionListener(e -> {
            String enteredDetails = "Name: " + nameField.getText() + "\n" +
                    "Email: " + emailField.getText() + "\n" +
                    "Phone: " + phoneField.getText() + "\n" +
                    "Country: " + countryBox.getSelectedItem() + "\n" +
                    "National ID/Passport: " + idField.getText() + "\n" +
                    "Service Provider: " + selectedProvider + "\n" +
                    "User " + nameField.getText() + " has registered on " + selectedProvider;
            detailsPanel.addUserDetails(enteredDetails);
            JOptionPane.showMessageDialog(panel, "User Added:\n" + enteredDetails);
            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
            idField.setText("");
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setSelectedProvider(String selectedProvider) {
        this.selectedProvider = selectedProvider;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }

    private void initializeCountryCodes() {
        countryCodes = new HashMap<>();
        countryCodes.put("Uganda", "+256");
        countryCodes.put("Kenya", "+254");
        countryCodes.put("Congo", "+243");
        countryCodes.put("Somali", "+252");
        countryCodes.put("Ghana", "+233");
        countryCodes.put("Sudan", "+249");
        countryCodes.put("South Sudan", "+211");
        countryCodes.put("Others", "+");
    }

    private String generatePhoneNumber(String countryCode) {
        Random random = new Random();
        return countryCode + (700000000 + random.nextInt(99999999));
    }
}
