package tugas1;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfirmClose {

    private boolean answer;

    public boolean display() throws IOException {
        Stage window = new Stage();

        Label label = new Label();
        label.setText("Anda yakin ingin keluar?");
        label.setId("labelClose");

        Button yes = new Button("yes");
        yes.setMinWidth(25);
        yes.setId("buttonClose");
        yes.setOnAction(e -> {
            answer = true;
            window.close();
        });

        Button no = new Button("no");
        no.setMinWidth(38);
        no.setId("buttonClose");
        no.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(12);
        layout.getChildren().addAll(label, yes, no);
        layout.setAlignment(Pos.CENTER);

        Scene sceneClose = new Scene(layout, 350, 140);
        sceneClose.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        window.setScene(sceneClose);
        window.setX(505);
        window.setY(250);
        window.setResizable(false);
        window.setMaximized(false);
        window.setAlwaysOnTop(true);
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.TRANSPARENT);
        window.showAndWait();

        return answer;
    }
}