package ui.windows;

import backend.services.OrganizationsService;
import backend.services.UsersService;
import backend.services.VolunteerHoursService;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import ui.UIController;

import java.util.List;

public class AddWindow extends BasicWindow {

    private final UIController ui;
    private final UsersService usersService;
    private final OrganizationsService organizationsService;
    private final VolunteerHoursService volunteerHoursService;

    //Constructor
    public AddWindow(UIController ui, UsersService usersService, OrganizationsService organizationsService, VolunteerHoursService volunteerHoursService){
        this.ui = ui;
        this.usersService = usersService;
        this.organizationsService = organizationsService;
        this.volunteerHoursService = volunteerHoursService;

        //Sets the title
        setTitle("Add Menu");

        //Centers the window
        setHints(List.of(Hint.CENTERED));

        //Sets the size of the window
        setFixedSize(new TerminalSize(80, 20));

        //Build
        setComponent(build());
    }
    private Component build(){

        Panel panel = new Panel();

        panel.addComponent(new Label ("Select what you would like to add: "));

        //Adds a new user
        panel.addComponent(new Button("Add User", () -> {
            AddUsersWindow addUserWindow =
                    new AddUsersWindow(ui, usersService);
            ui.showWindow(addUserWindow);
        }));

        // Adds a new organization
        panel.addComponent(new Button("Add Organization", () -> {
            AddOrganizationsWindow addOrgWindow =
                    new AddOrganizationsWindow(ui, organizationsService);
            ui.showWindow(addOrgWindow);
        }));

        // Adds a new volunteer entry
        panel.addComponent(new Button("Add Volunteer Entry", () -> {
            AddVolunteerHoursWindow addHoursWindow =
                    new AddVolunteerHoursWindow(ui, volunteerHoursService);
            ui.showWindow(addHoursWindow);
        }));

        //Back button
        panel.addComponent(new Button("Back", ui::showMainMenu));

        return panel;
    }
}
