package tugas2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBox {
    void display(String message, ImageView image) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label();
        label.setId("closeLabel_1");
        label.setText(message);

        Button button = new Button("Kembali");
        button.setId("closeButton");
        button.setOnAction(event -> {
            window.close();
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(image, label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 520, 380, Color.valueOf("#e6e6e6"));
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());

        window.setScene(scene);
        window.initStyle(StageStyle.TRANSPARENT);
        window.setAlwaysOnTop(true);
        window.showAndWait();
    }
}