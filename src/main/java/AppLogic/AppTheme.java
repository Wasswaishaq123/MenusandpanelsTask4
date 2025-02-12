package AppLogic;

import java.awt.*;

public class AppTheme {
    private boolean isDarkMode;

    public AppTheme() {
        isDarkMode = true;
    }

    public void toggleTheme() {
        isDarkMode = !isDarkMode;
    }

    public Color getBackgroundColor() {
        return isDarkMode ? Color.DARK_GRAY : Color.LIGHT_GRAY;
    }

    public Color getForegroundColor() {
        return isDarkMode ? Color.WHITE : Color.BLACK;
    }
}