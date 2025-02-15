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

        Details detailsPanel = new Details(themeManager);
        AddUser addUserPanel = new AddUser(themeManager, detailsPanel);
        Home homePanel = new Home(themeManager, addUserPanel, this);
        Deregister deregisterPanel = new Deregister(themeManager);
        Settings settingsPanel = new Settings(themeManager);
        User userInfoPanel = new User(themeManager);

        mainPanel.add(homePanel.getPanel(), "Home");
        mainPanel.add(detailsPanel.getPanel(), "Details");
        mainPanel.add(deregisterPanel.getPanel(), "Deregister");
        mainPanel.add(addUserPanel.getPanel(), "AddUser");
        mainPanel.add(settingsPanel.getPanel(), "Settings");
        mainPanel.add(userInfoPanel.getPanel(), "User");

        createMenu();

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Dashboard");
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem homeItem = new JMenuItem("Home", resizeIcon("src/main/resources/icons/home.png", 20, 20));
        homeItem.addActionListener(e -> switchPanel("Home"));
        menu.add(homeItem);

        JMenuItem addUserItem = new JMenuItem("Add Client", resizeIcon("src/main/resources/icons/user-plus.png", 20, 20));
        addUserItem.addActionListener(e -> switchPanel("AddUser"));
        menu.add(addUserItem);

        JMenuItem detailsItem = new JMenuItem("Details", resizeIcon("src/main/resources/icons/details.png", 20, 20));
        detailsItem.addActionListener(e -> switchPanel("Details"));
        menu.add(detailsItem);

        JMenuItem deregisterItem = new JMenuItem("Deregister", resizeIcon("src/main/resources/icons/user-minus.png", 20, 20));
        deregisterItem.addActionListener(e -> switchPanel("Deregister"));
        menu.add(deregisterItem);


        JMenuItem userItem = new JMenuItem("Profile", resizeIcon("src/main/resources/icons/user.png", 20, 20));
        userItem.addActionListener(e -> switchPanel("User"));
        menu.add(userItem);

        JMenuItem settingsItem = new JMenuItem("Settings", resizeIcon("src/main/resources/icons/settings.png", 20, 20));
        settingsItem.addActionListener(e -> switchPanel("Settings"));
        settingsMenu.add(settingsItem);

        JMenuItem exitItem = new JMenuItem("Exit", resizeIcon("src/main/resources/icons/log-out.png", 20, 20));
        exitItem.addActionListener(e -> System.exit(0));
        settingsMenu.add(exitItem);

        menuBar.add(menu);
        menuBar.add(settingsMenu);

        frame.setJMenuBar(menuBar);
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
}
