package ui.windows;

import backend.services.UsersService;
import backend.services.VolunteerHoursService;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialog;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialogBuilder;
import models.Users;
import ui.UIController;

import java.util.List;

public class SeeUsersWindow extends BasicWindow {

    private final UIController ui;
    private final UsersService usersService;
    private final VolunteerHoursService volunteerHoursService;

    //Constructor
    public SeeUsersWindow(UIController ui, UsersService usersService, VolunteerHoursService volunteerHoursService) {
        this.ui = ui;
        this.usersService = usersService;
        this.volunteerHoursService = volunteerHoursService;

        //Sets the title
        setTitle("See Users");

        //Centers the window
        setHints(List.of(Hint.CENTERED));

        //Sets the size of the window
        setFixedSize(new TerminalSize(80, 20));

        //Build
        setComponent(build());
    }


    private Component build(){

        Panel panel = new Panel();

        List<Users> users = usersService.getAllUsers();

        panel.addComponent(new Label("ID | Name | Email | Graduation Year"));
        panel.addComponent(new Label("-----------------------------------------"));

        for (Users user : users) {
            String row = user.id() + " | " +
                    user.name() + " | " +
                    user.email() + " | " +
                    user.graduation_year();

            panel.addComponent(new Label(row));
        }

        panel.addComponent(new EmptySpace());

        //Check total hours by user
        panel.addComponent(new Button("Check Total Volunteer Hours", () -> {
            TotalHoursWindow hoursWindow = new TotalHoursWindow(ui, volunteerHoursService);
            ui.showWindow(hoursWindow);
        }));

        panel.addComponent(new EmptySpace());
        panel.addComponent(new Button("Back", ui::showMainMenu));

        return panel;
    }
    
}
