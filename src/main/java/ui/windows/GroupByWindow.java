package ui.windows;

import com.googlecode.lanterna.gui2.ComboBox;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.Panel;
import ui.UIController;

public class GroupByWindow{
    private Component build(){

        Panel panel = new Panel();

        //The user can select how to group volunteer entries through a dropdown(group by volunteer hours or by organization)
        ComboBox<String> combo = new ComboBox<>("Group by volunteer hours", "Group by organization");
        panel.addComponent(combo);

        //Display the grouped results
        //Back button to the main menu

        return panel;
    }

    public GroupByWindow(UIController uiController) {

    }
}
