package ui;

import backend.services.UsersService;
import backend.services.VolunteerHoursService;
import com.googlecode.lanterna.gui2.BasicWindow;
import ui.windows.*;

public class UIController {

    Gui gui;
    private final UsersService usersService;
    private final VolunteerHoursService volunteerHoursService;

    public UIController(Gui gui, UsersService usersService, VolunteerHoursService volunteerHoursService) {
        this.gui = gui;
        this.usersService = usersService;
        this.volunteerHoursService = volunteerHoursService;
    }

    public VolunteerHoursService getVolunteerHoursService() {
        return volunteerHoursService;
    }


    public void showMainMenu() {
        gui.show(new MainMenuWindow(this));
    }

    public void showSeeUsersWindow() {
        gui.show(new SeeUsersWindow(this, usersService, volunteerHoursService));
    }

    public void showSeeOrganizationsWindow() {
        gui.show(new SeeOrganizationsWindow(this));
    }

    public void showAddWindow() {
        gui.show(new AddWindow(this));
    }

    public void showAllEntriesWindow() {
        gui.show(new AllEntriesWindow(this));
    }

    public void showTotalHoursWindow() {
        gui.show(new TotalHoursWindow(this, volunteerHoursService));
    }

    public void closeWindow(BasicWindow window) {
        window.close();
    }

    public void closeApp() {
        System.exit(0);
    }

    public void showWindow(BasicWindow window) {
        gui.show(window);
    }
}