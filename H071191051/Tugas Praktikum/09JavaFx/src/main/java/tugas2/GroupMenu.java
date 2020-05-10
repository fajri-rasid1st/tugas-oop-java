package tugas2;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class GroupMenu {

    private RadioButton[] rButton = new RadioButton[4];
    private ToggleGroup togel;

    GroupMenu(ToggleGroup togel) {
        this.togel = togel;
    }

    void setRadioButton() {
        for (int i = 1; i < rButton.length + 1; i++) {
            rButton[i - 1] = new RadioButton("  Kelompok " + i);
            rButton[i - 1].setId("radioData");
            rButton[i - 1].setToggleGroup(togel);
        }
    }

    String selectedGroupToggle() {
        if (rButton[0].isSelected()) {
            return "kelompok1";
        } else if (rButton[1].isSelected()) {
            return "kelompok2";
        } else if (rButton[2].isSelected()) {
            return "kelompok3";
        } else if (rButton[3].isSelected()) {
            return "kelompok4";
        } else {
            return null;
        }
    }

    Group groupMenuDisplay() {
        Label label = new Label("Kelompok");
        label.setId("titleData");
        label.setLayoutX(175);
        label.setLayoutY(120);

        GridPane gPane = new GridPane();
        gPane.setHgap(50);
        gPane.setVgap(40);
        GridPane.setConstraints(rButton[0], 0, 0);
        GridPane.setConstraints(rButton[1], 1, 0);
        GridPane.setConstraints(rButton[2], 0, 1);
        GridPane.setConstraints(rButton[3], 1, 1);
        gPane.getChildren().addAll(rButton);
        gPane.setPadding(new Insets(190, 95, 190, 95));

        return new Group(label, gPane);
    }

    void resetTogel() {
        for (int i = 0; i < rButton.length; i++) {
            rButton[i].setSelected(false);
        }
    }
}