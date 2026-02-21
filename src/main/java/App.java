import backend.Database;
import backend.repositories.QuestionRepo;
import backend.repositories.UsersRepo;
import backend.repositories.VolunteerHoursRepo;
import backend.services.QuestionService;
import backend.services.UsersService;
import backend.services.VolunteerHoursService;
import ui.Gui;
import ui.UIController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/*
Initializes everything
UI
    GUI (Window management wrapper) -> UIController (Navigation) -> Windows (What we see)
Backend
    Service (used in UIController) -> Repositories (Queries the db) -> DB (Handles the DB connection)
 */
public class App {
    public static void run() throws SQLException {
        String url = "jdbc:sqlite:db";
        try (
                Database db = new Database(url);
        ) {
            // database
            db.connect();
            Connection conn = db.getConnection();

            // Repositories
            QuestionRepo questionRepo = new QuestionRepo(conn);
            UsersRepo usersRepo = new UsersRepo(conn);
            VolunteerHoursRepo hoursRepo = new VolunteerHoursRepo(conn);

            // Services
            QuestionService questionService = new QuestionService(questionRepo);
            UsersService usersService = new UsersService(usersRepo);
            VolunteerHoursService hoursService = new VolunteerHoursService(hoursRepo);

            // GUI
            Gui gui = new Gui();
            gui.start();
            UIController ui = new UIController(gui, usersService, hoursService);
            ui.showMainMenu();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
