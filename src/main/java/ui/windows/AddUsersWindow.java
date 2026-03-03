package ui.windows;

import backend.services.UsersService;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import ui.UIController;

import java.util.List;

public class AddUsersWindow extends BasicWindow {
    private final UIController ui;
    private final UsersService usersService;

    public AddUsersWindow(UIController ui, UsersService usersService) {
        this.ui = ui;
        this.usersService = usersService;

        //Sets the title
        setTitle("Add User");

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
        panel.addComponent(new Label("Enter User Information:"));

        //Name input
        panel.addComponent(new Label("Name:"));
        TextBox nameBox = new TextBox();
        panel.addComponent(nameBox);

        //Email input
        panel.addComponent(new Label("Email:"));
        TextBox emailBox = new TextBox();
        panel.addComponent(emailBox);

        //Graduation Year input
        panel.addComponent(new Label("Graduation Year:"));
        TextBox gradYearBox = new TextBox();
        panel.addComponent(gradYearBox);

        //Submit button
        panel.addComponent(new Button("Submit", () -> {
            try {
                String name = nameBox.getText();
                String email = emailBox.getText();
                int gradYear = Integer.parseInt(gradYearBox.getText());

                //Add user to database
                usersService.addUser(name, email, gradYear);

                //Clear fields
                nameBox.setText("");
                emailBox.setText("");
                gradYearBox.setText("");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }));

        //Back button
        panel.addComponent(new Button("Back", ui::showAddWindow));

        return panel;


    }
}
