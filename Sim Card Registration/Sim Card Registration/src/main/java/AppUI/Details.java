package AppUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import AppLogic.*;

public class Details {
    private JPanel panel;
    private AppTheme themeManager;
    private Map<String, String> countryCodes;

    public Details(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(null);
        applyTheme();

        initializeCountryCodes();

        JLabel label = new JLabel("SIM Card Registration Details", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(50, 10, 400, 30);
        panel.add(label);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 25);
        JTextField nameField = new JTextField(20);
        nameField.setBounds(190, 60, 200, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 25);
        JTextField emailField = new JTextField(20);
        emailField.setBounds(190, 100, 200, 25);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 140, 100, 25);
        JTextField phoneField = new JTextField(20);
        phoneField.setBounds(190, 170, 200, 25);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(50, 210, 100, 25);
        String[] countries = {"Uganda", "Kenya", "Congo", "Somali", "Ghana", "Sudan", "South Sudan", "Others"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        countryBox.setBounds(190, 210, 200, 25);

        countryBox.addActionListener(e -> {
            String selectedCountry = (String) countryBox.getSelectedItem();
            String countryCode = countryCodes.getOrDefault(selectedCountry, "+");
            phoneField.setText(generatePhoneNumber(countryCode));
        });

        JLabel idLabel = new JLabel("National ID/Passport:");
        idLabel.setBounds(50, 250, 150, 25);
        JTextField idField = new JTextField(20);
        idField.setBounds(190, 250, 200, 25);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(190, 290, 100, 30);

        JTextArea detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        scrollPane.setBounds(50, 340, 400, 150);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(countryLabel);
        panel.add(countryBox);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(submitButton);
        panel.add(scrollPane);

        submitButton.addActionListener(e -> {
            String enteredDetails = "Name: " + nameField.getText() + "\n" +
                    "Email: " + emailField.getText() + "\n" +
                    "Phone: " + phoneField.getText() + "\n" +
                    "Country: " + countryBox.getSelectedItem() + "\n" +
                    "National ID/Passport: " + idField.getText() + "\n";

            detailsArea.append("\n" + enteredDetails);
            nameField.setText("");
            emailField.setText("");
            idField.setText("");
        });
    }
    public JPanel getPanel() {
        return panel;
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
