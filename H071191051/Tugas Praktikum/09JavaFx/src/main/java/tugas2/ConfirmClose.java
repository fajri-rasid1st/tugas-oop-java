package tugas2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfirmClose {

    private boolean answer;

    boolean display() {
        Stage close = new Stage();
        close.initModality(Modality.APPLICATION_MODAL);

        Label label_1 = new Label("Anda yakin ingin keluar?");
        label_1.setId("closeLabel_1");
        Label label_2 = new Label("(Data anda akan disimpan)");
        label_2.setId("closeLabel_2");

        Button yes = new Button("  ya  ");
        yes.setMinWidth(45);
        yes.setId("closeButton");
        yes.setOnAction(e -> {
            answer = true;
            close.close();
        });

        Button no = new Button("tidak");
        no.setMinWidth(40);
        no.setId("closeButton");
        no.setOnAction(e -> {
            answer = false;
            close.close();
        });

        HBox hb = new HBox(30);
        hb.getChildren().addAll(yes, no);
        hb.setAlignment(Pos.CENTER);

        VBox vb = new VBox(10);
        vb.getChildren().addAll(label_1, label_2, hb);
        vb.setAlignment(Pos.CENTER);

        Scene sceneClose = new Scene(vb, 360, 180, Color.valueOf("#e09b00"));
        sceneClose.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());

        close.setScene(sceneClose);
        close.setAlwaysOnTop(true);
        close.initStyle(StageStyle.TRANSPARENT);
        close.showAndWait();

        return answer;
    }
}