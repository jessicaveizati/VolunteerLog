package ui;

import com.googlecode.lanterna.gui2.BasicWindow;
import ui.windows.MainMenuWindow;
import ui.windows.AddWindow;
import ui.windows.AllEntriesWindow;
import ui.windows.TotalHoursWindow;
import ui.windows.GroupByWindow;

public class UIController {
    public UIController() {
    }

    public void showMainMenu() {
        new MainMenuWindow(this);
    }

    public void showGroupByWindow() {
        new GroupByWindow(this);
    }

    public void showAddWindow() {
        new AddWindow(this);
    }

    public void showAllEntriesWindow() {
        new AllEntriesWindow(this);
    }

    public void showTotalHoursWindow() {
        new TotalHoursWindow(this);
    }

    public void closeWindow(BasicWindow window) {
        window.close();
    }

    public void closeApp() {
        System.exit(0);
    }

}