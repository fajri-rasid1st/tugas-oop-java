package tugas1;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class MenuDisplay {
    private Rectangle rectangle;
    private ImageView view;
    private Label label;
    private HBox hb;

    MenuDisplay(ImageView view, Rectangle rectangle, Label label, HBox hb) {
        this.view = view;
        this.rectangle = rectangle;
        this.label = label;
        this.hb = hb;
    }

    Group getGroupMenu() {
        return new Group(rectangle, view, label, hb);
    }
}