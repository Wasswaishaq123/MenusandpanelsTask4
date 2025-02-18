package ApplicationLogic;

import org.junit.jupiter.api.Test;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class AppFrameTest {

    @Test
    void testCreateMenu() {
        // Create a frame and menu bar
        JFrame frame = new JFrame();
        JMenuBar menuBar = new JMenuBar();

        // Create the Dashboard menu
        JMenu menu = new JMenu("Dashboard");

        JMenuItem homeItem = new JMenuItem("Home");
        JMenuItem detailsItem = new JMenuItem("Details");
        JMenuItem deregisterItem = new JMenuItem("DeRegister");
        JMenuItem userItem = new JMenuItem("User");

        menu.add(homeItem);
        menu.add(detailsItem);
        menu.add(deregisterItem);
        menu.add(userItem);

        // Create the Settings menu
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem settingsItem = new JMenuItem("Settings");
        JMenuItem exitItem = new JMenuItem("Exit");

        settingsMenu.add(settingsItem);
        settingsMenu.add(exitItem);

        // Add menus to menu bar
        menuBar.add(menu);
        menuBar.add(settingsMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Perform assertions
        assertNotNull(frame.getJMenuBar(), "Menu bar should be set on the frame");
        assertEquals(2, menuBar.getMenuCount(), "There should be two menus: Dashboard and Settings");

        JMenu dashboardMenu = menuBar.getMenu(0);
        assertEquals("Dashboard", dashboardMenu.getText(), "First menu should be 'Dashboard'");
        assertEquals(4, dashboardMenu.getItemCount(), "Dashboard should have 4 items");

        assertEquals("Home", dashboardMenu.getItem(0).getText(), "First item should be 'Home'");
        assertEquals("Details", dashboardMenu.getItem(1).getText(), "Second item should be 'Details'");
        assertEquals("Deregister", dashboardMenu.getItem(2).getText(), "Third item should be 'Deregister'");
        assertEquals("User", dashboardMenu.getItem(3).getText(), "Fourth item should be 'User'");

        JMenu settingsMenuTest = menuBar.getMenu(1);
        assertEquals("Settings", settingsMenuTest.getText(), "Second menu should be 'Settings'");
        assertEquals(2, settingsMenuTest.getItemCount(), "Settings should have 2 items");

        assertEquals("Settings", settingsMenuTest.getItem(0).getText(), "First item in Settings should be 'Settings'");
        assertEquals("Exit", settingsMenuTest.getItem(1).getText(), "Last item in Settings should be 'Exit'");
    }
}
