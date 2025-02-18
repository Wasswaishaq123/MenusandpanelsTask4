package AppLogic;
import javax.swing.*;
import java.awt.*;
import AppLogic.AppTheme;
import AppUI.*;

public class AppFrame {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private AppTheme themeManager;

    public AppFrame() {
        frame = new JFrame("SIM Card Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        themeManager = new AppTheme();


        mainPanel.add(new Home(themeManager).getPanel(), "Home");
        mainPanel.add(new Details(themeManager).getPanel(), "Details");
        mainPanel.add(new Deregister(themeManager).getPanel(), "Deregister");
        mainPanel.add(new User(themeManager).getPanel(), "User  ");
        mainPanel.add(new Settings(themeManager).getPanel(), "Settings");


        createMenu();

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Dashboard");
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem homeItem = new JMenuItem("Home", new ImageIcon("src/main/resources/icons/home.png"));
        homeItem.addActionListener(e -> switchPanel("Home"));
        menu.add(homeItem);

        JMenuItem detailsItem = new JMenuItem("Details", new ImageIcon("src/main/resources/icons/details.png"));
        detailsItem.addActionListener(e -> switchPanel("Details"));
        menu.add(detailsItem);

        JMenuItem deregisterItem = new JMenuItem("Deregister", new ImageIcon("src/main/resources/icons/deregister.png"));
        deregisterItem.addActionListener(e -> switchPanel("Deregister"));
        menu.add(deregisterItem);

        JMenuItem userItem = new JMenuItem("User", new ImageIcon("src/main/resources/icons/user.png"));
        userItem.addActionListener(e -> switchPanel("User"));
        menu.add(userItem);


        JMenuItem settingsItem = new JMenuItem("Settings", new ImageIcon("src/main/resources/icons/settings.png"));
        settingsItem.addActionListener(e -> switchPanel("Settings"));
        settingsMenu.add(settingsItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        settingsMenu.add(exitItem);

        menuBar.add(menu);
        menuBar.add(settingsMenu);

        frame.setJMenuBar(menuBar);
    }
    private void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

}