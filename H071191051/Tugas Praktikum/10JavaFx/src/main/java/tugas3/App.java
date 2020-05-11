package tugas3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {
    Stage primaryStage;
    ImageView image_1, image_2;
    FileChooser fileChooser = new FileChooser();

    @Override
    public void start(Stage stage) throws IOException {

        // import gambar
        image_1 = new ImageView(new Image(new FileInputStream("src\\main\\java\\assets3\\Picture1.png")));
        image_2 = new ImageView(new Image(new FileInputStream("src\\main\\java\\assets3\\Picture2.png")));

        // Group
        Group root = new Group(initialDisplay(image_1, image_2));

        // Scene
        Scene scene = new Scene(root, 530, 620, Color.valueOf("#8a8a8a"));
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        // Stage
        primaryStage = stage;
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeApp();
        });
        primaryStage.setTitle("Reading file.txt");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.getIcons().add(new Image(new FileInputStream("src\\main\\java\\assets3\\Picture3.png")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void closeApp() {
        ConfirmClose confirm = new ConfirmClose();
        boolean isClose = confirm.display("Anda yakin ingin keluar?");
        if (isClose) {
            primaryStage.close();
        }
    }

    Group initialDisplay(ImageView image_1, ImageView image_2) {
        image_1.setX(15);
        image_1.setY(62);
        image_2.setX(-8);
        image_2.setY(10);

        TextArea text = new TextArea();
        text.setId("textArea");
        text.setPromptText("File *.txt yang anda masukkan akan terbaca disini");
        text.setEditable(false);
        text.setPrefSize(400, 430);
        text.setLayoutX(65);
        text.setLayoutY(100);
        text.opacityProperty().set(0.6);

        Button selectFile = new Button("Select First File");
        selectFile.setId("selectFile");
        selectFile.setLayoutX(180);
        selectFile.setLayoutY(550);
        selectFile.setOnAction(e -> {
            HandlingChooser handler = new HandlingChooser();
            Window window = selectFile.getScene().getWindow();

            try {
                File file = handler.getFile(fileChooser, primaryStage, window);
                if (!handler.readFile(file).isEmpty()) {
                    text.setText(handler.readFile(file));
                } else {
                    text.setText("Isi file tidak ada");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        return new Group(image_1, image_2, text, selectFile);
    }
}