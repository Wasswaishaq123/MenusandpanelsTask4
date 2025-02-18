package AppUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import AppLogic.*;

public class Details {
    private JPanel panel;
    private AppTheme themeManager;
    private JTextArea detailsArea;
    private List<String> userDetailsList;

    public Details(AppTheme themeManager) {
        this.themeManager = themeManager;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        applyTheme();

        userDetailsList = new ArrayList<>();

        JLabel label = new JLabel("The Client Information", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.NORTH);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void applyTheme() {
        panel.setBackground(themeManager.getBackgroundColor());
        panel.setForeground(themeManager.getForegroundColor());
    }

    public void addUserDetails(String details) {
        userDetailsList.add(details);
        updateDetailsArea();
    }

    private void updateDetailsArea() {
        StringBuilder allDetails = new StringBuilder();
        for (String userDetails : userDetailsList) {
            allDetails.append(userDetails).append("\n\n");
        }
        detailsArea.setText(allDetails.toString());
    }
}
