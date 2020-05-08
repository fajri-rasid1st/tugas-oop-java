package tugas1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Order {
    private int numberOfOrder;
    private Button increase = new Button("+");
    private Button decrease = new Button("-");
    private TextField tf = new TextField("0");

    Order(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    HBox setOrderer(double x, double y) {

        tf.setEditable(false);
        tf.setPrefWidth(40);
        tf.setAlignment(Pos.CENTER);

        increase.setOnAction(e -> {
            tf.setText(String.valueOf(++numberOfOrder));
        });

        decrease.setOnAction(e -> {
            if (getOrder() > 0) {
                tf.setText(String.valueOf(--numberOfOrder));
            }
        });

        HBox hBox = new HBox(decrease, tf, increase);
        hBox.setSpacing(5);
        hBox.setLayoutX(x);
        hBox.setLayoutY(y);
        return hBox;
    }

    int getOrder() {
        return Integer.valueOf(tf.getText());
    }

    void resetOrder() {
        tf.clear();
        numberOfOrder *= 0;
        tf.setText(String.valueOf(numberOfOrder));
    }
}