package tugas1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Transaction {
    public void display(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label();
        label.setText(message);
        label.setId("labelClose");

        Button button = new Button("Kembali");
        button.setId("buttonClose");
        button.setOnAction(event -> {
            window.close();
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 320, 110, Color.valueOf("#e6e6e6"));
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        window.setResizable(false);
        window.setMaximized(false);
        window.setAlwaysOnTop(true);
        window.setX(517);
        window.setY(280);
        window.initStyle(StageStyle.TRANSPARENT);
        window.setScene(scene);
        window.showAndWait();
    }
}