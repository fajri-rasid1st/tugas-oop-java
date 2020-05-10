package tugas2;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BiodataMenu {
    private TextField tf_1;
    private TextField tf_2;
    private CheckBox cBox_1;
    private CheckBox cBox_2;
    private ImageView icon_1;
    private ImageView icon_2;

    BiodataMenu(ImageView icon_1, ImageView icon_2, TextField tf_1, TextField tf_2, CheckBox cBox_1, CheckBox cBox_2) {
        this.icon_1 = icon_1;
        this.icon_2 = icon_2;
        this.tf_1 = tf_1;
        this.tf_2 = tf_2;
        this.cBox_1 = cBox_1;
        this.cBox_2 = cBox_2;
    }

    Group groupBiodataDisplay() {
        Label title = setLabel("Data", "titleData");
        Label nim = new Label("NIM");
        nim.setId("labelBiodata");
        Label name = new Label("Nama");
        name.setId("labelBiodata");
        Label gender = new Label("Gender");
        gender.setId("labelBiodata");

        tf_1.setPromptText("Masukkan NIM anda");
        tf_1.setMinWidth(200);
        tf_1.setId("textField");

        tf_2.setPromptText("Masukkan nama anda");
        tf_2.setMinWidth(200);
        tf_2.setId("textField");

        cBox_1.setId("checkBox");
        cBox_2.setId("checkBox");

        GridPane gPane = new GridPane();
        gPane.setHgap(20);
        gPane.setVgap(10);
        GridPane.setConstraints(nim, 0, 0);
        GridPane.setConstraints(tf_1, 1, 0);
        GridPane.setConstraints(name, 0, 1);
        GridPane.setConstraints(tf_2, 1, 1);
        GridPane.setConstraints(gender, 0, 2);
        GridPane.setConstraints(cBox_1, 1, 2);
        GridPane.setConstraints(cBox_2, 1, 3);
        gPane.getChildren().addAll(nim, tf_1, name, tf_2, gender, cBox_1, cBox_2);
        gPane.setPadding(new Insets(175, 465, 175, 465));

        icon_1.setFitHeight(30);
        icon_1.setFitWidth(30);
        icon_1.setX(670);
        icon_1.setY(283);
        icon_2.setFitHeight(30);
        icon_2.setFitWidth(30);
        icon_2.setX(670);
        icon_2.setY(250);

        return new Group(title, gPane, line(560, 198), line(560, 235), icon_1, icon_2);
    }

    Label setLabel(String words, String id) {
        Label label = new Label(words);
        label.setId(id);
        label.setLayoutX(570);
        label.setLayoutY(120);
        return label;
    }

    Rectangle line(double x, double y) {
        Rectangle rect = new Rectangle(195, 2, Color.rgb(228, 228, 228));
        rect.setX(x);
        rect.setY(y);
        return rect;
    }

    // ---------------------------
    TextField getTf_1() {
        return tf_1;
    }

    void setTextNim(String tf__1) {
        this.tf_1.setText(tf__1);
    }

    String getTextNim() {
        return tf_1.getText();
    }

    // ---------------------------
    TextField getTf_2() {
        return tf_2;
    }

    void setTextName(String tf__2) {
        this.tf_2.setText(tf__2);
    }

    String getTextName() {
        return tf_2.getText();
    }

    // ----------------------------

    String getGender() {
        if (cBox_1.isSelected() && !cBox_2.isSelected()) {
            return cBox_1.getText();
        } else if (!cBox_1.isSelected() && cBox_2.isSelected()) {
            return cBox_2.getText();
        } else if (!cBox_1.isSelected() && !cBox_2.isSelected()) {
            return "tidak ada";
        } else {
            return "transgender";
        }
    }

    CheckBox getcBox_1() {
        return cBox_1;
    }

    CheckBox getcBox_2() {
        return cBox_2;
    }
}