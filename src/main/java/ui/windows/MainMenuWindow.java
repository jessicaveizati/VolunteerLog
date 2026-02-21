package ui.windows;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import ui.UIController;
import ui.windows.SeeUsersWindow;
import ui.windows.AddWindow;
import ui.windows.AllEntriesWindow;
import ui.windows.TotalHoursWindow;


import java.util.List;

public class MainMenuWindow extends BasicWindow{

    //Reference to the UI controller, makes it possible to open other windows
    private final UIController ui;

    //Constructor
    public MainMenuWindow(UIController ui){
        this.ui = ui;
        //Sets the title
        setTitle("Main Menu");

        //Centers the window
        setHints(List.of(Hint.CENTERED));

        //Sets the size of the window
        setFixedSize(new TerminalSize(80, 20));

        //Build
        setComponent(build());

    }

    //Holds the name and action of a button
    private record MenuItem(String name, Runnable action) {}

    //Creates and arranges all UI components
    private Component build (){

        Panel panel = new Panel();

        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL)
        );

        MenuItem[] menu = {
                new MenuItem("1) See Users", ui::showSeeUsersWindow),
                new MenuItem("2) See Organizations", ui::showSeeOrganizationsWindow),
                new MenuItem("3) Add Entry", ui::showAddWindow),
                new MenuItem("4) View All Volunteer Entries", ui:: showAllEntriesWindow),
                new MenuItem("5) See Total Hours", ui::showTotalHoursWindow),
                new MenuItem("6) Exit", ui::closeApp)
        };

        for(MenuItem item : menu) {
            panel.addComponent(new Button(item.name(),item.action()));
        }

        return panel;
    }




}
