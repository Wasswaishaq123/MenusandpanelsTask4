package AppLogic;

import java.awt.*;

public class AppTheme {
    private boolean isDarkMode;

    public AppTheme() {
        isDarkMode = true;
    }
    public Color getBackgroundColor() {
        return isDarkMode ? Color.lightGray : Color.LIGHT_GRAY;
    }

    public Color getForegroundColor() {
        return isDarkMode ? Color.WHITE : Color.BLACK;
    }
}