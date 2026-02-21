package ui.windows;

import backend.services.VolunteerHoursService;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import ui.UIController;

public class TotalHoursWindow extends BasicWindow {

    private final UIController ui;
    private final VolunteerHoursService volunteerHoursService;

    //Constructor
    public TotalHoursWindow(UIController ui, VolunteerHoursService volunteerHoursService) {
        this.ui = ui;
        this.volunteerHoursService = volunteerHoursService;
        setTitle("Total Volunteer Hours");
        setHints(java.util.List.of(Hint.CENTERED));
        setFixedSize(new TerminalSize(80, 20));
        setComponent(build());
    }

    private Component build() {
        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

        // Label asking for name
        panel.addComponent(new Label("Enter the user's name:"));

        // TextBox for user input
        TextBox userBox = new TextBox(new TerminalSize(20, 1));
        panel.addComponent(userBox);

        panel.addComponent(new EmptySpace());

        //Search button
        Label result = new Label("");
        panel.addComponent(result);

        panel.addComponent(new Button("Search for Hours", () -> {
            int n = volunteerHoursService.getTotalVolunteerHoursForUser(userBox.getText());
            result.setText("Total Hours: " + String.valueOf(n));
        }));



        // Back button
        panel.addComponent(new Button("Back", this::close));

        return panel;
    }
}