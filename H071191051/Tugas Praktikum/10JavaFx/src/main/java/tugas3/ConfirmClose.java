package tugas3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfirmClose {

    private boolean answer;

    public boolean display(String message) {
        Stage stageClose = new Stage(StageStyle.TRANSPARENT);

        Label label = new Label(message);
        label.setId("labelClose");

        Button button_1 = new Button("Ya");
        button_1.setId("buttonClose");
        button_1.setOnAction(e -> {
            answer = true;
            stageClose.close();
        });

        Button button_2 = new Button("Tidak");
        button_2.setId("buttonClose");
        button_2.setOnAction(e -> {
            answer = false;
            stageClose.close();
        });

        VBox vb = new VBox(20);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(label, button_1, button_2);
        vb.setBackground(new Background(new BackgroundFill(Color.valueOf("#8a8a8a"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene sceneClose = new Scene(vb, 260, 200);
        sceneClose.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stageClose.setX(555);
        stageClose.setY(280);
        stageClose.setScene(sceneClose);
        stageClose.setAlwaysOnTop(true);
        stageClose.initModality(Modality.APPLICATION_MODAL);
        stageClose.showAndWait();

        return answer;
    }
}