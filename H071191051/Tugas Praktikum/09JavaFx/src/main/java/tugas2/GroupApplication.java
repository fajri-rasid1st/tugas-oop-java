package tugas2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GroupApplication extends Application {
    private Stage primaryStage;
    private Scene scene;
    private ImageView[] icons = new ImageView[7];
    private ConfirmClose confirmClose = new ConfirmClose();
    private DataHandling dataHandle = new DataHandling();
    private AlertBox alert = new AlertBox();
    File file = new File("src\\main\\java\\tugas2\\Group.txt");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        file.createNewFile();
        // mengambil semua gambar
        for (int i = 0; i < icons.length; i++) {
            icons[i] = new ImageView(
                    new Image(new FileInputStream("src\\main\\java\\assets\\Picture" + (i + 1) + ".png")));
        }

        // tampilan pilihan kelompok
        GroupMenu gMenu = new GroupMenu(new ToggleGroup());
        gMenu.setRadioButton();
        Group groupMenu = gMenu.groupMenuDisplay();

        // tampilan pilihan biodata
        BiodataMenu bioMenu = new BiodataMenu(icons[2], icons[3], new TextField(), new TextField(),
                new CheckBox("Laki-laki"), new CheckBox("Perempuan"));
        Group biodataMenu = bioMenu.groupBiodataDisplay();

        // added and setting button to close window
        Button buttonClose = new Button();
        buttonClose.setGraphic(icons[0]);
        buttonClose.setBackground(Background.EMPTY);
        buttonClose.setLayoutX(780);
        buttonClose.setOnMouseEntered(e -> {
            scene.setCursor(Cursor.HAND);
        });
        buttonClose.setOnMouseExited(e -> {
            scene.setCursor(Cursor.DEFAULT);
        });
        buttonClose.setOnAction(e -> {
            closeProgram();
        });

        // added button to handling Data Save
        Button save = new Button("Save");
        save.setId("handlingButton");
        save.setLayoutX(717);
        save.setLayoutY(367);
        save.setOnAction(e -> {
            bioMenu.setTextNim(bioMenu.getTf_1().getText());
            bioMenu.setTextName(bioMenu.getTf_2().getText());

            if (bioMenu.getTextNim().isBlank() || bioMenu.getTextNim().isEmpty()) {
                alert.display("Silahkan masukkan NIM anda", icons[1]);
            } else if (bioMenu.getTextName().isBlank() || bioMenu.getTextName().isEmpty()) {
                alert.display("Silahkan masukkan nama anda", icons[1]);
            } else if (bioMenu.getGender().equals("transgender")) {
                alert.display("Hanya boleh memilih satu gender", icons[1]);
            } else if (bioMenu.getGender().equals("tidak ada")) {
                alert.display("Silahkan pilih gender anda", icons[1]);
            } else if (gMenu.selectedGroupToggle() == null) {
                alert.display("Silahkan pilih kelompok anda", icons[1]);
            } else {
                alert.display("Data anda berhasil disimpan", icons[5]);
                try {
                    dataHandle.addData(String.format("%s;%s;%s;%s.", bioMenu.getTextNim(), bioMenu.getTextName(),
                            bioMenu.getGender(), gMenu.selectedGroupToggle()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                bioMenu.getTf_1().clear();
                bioMenu.getTf_2().clear();
                bioMenu.getcBox_1().setSelected(false);
                bioMenu.getcBox_2().setSelected(false);
                gMenu.resetTogel();
            }
        });

        // added button to handling Data view
        Button viewInfo = new Button("Lihat kelompok");
        viewInfo.setId("handlingButton");
        viewInfo.setLayoutX(80);
        viewInfo.setLayoutY(367);
        viewInfo.setOnAction(e -> {
            try {
                if (dataHandle.seeData().isBlank() || dataHandle.seeData().isEmpty()) {
                    alert.display("Belum ada yang mendaftar", icons[1]);
                } else {
                    alert.display("Nama pendaftar:\n" + dataHandle.seeData(), icons[4]);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        // group
        Group root = new Group(sceneDisplay(), biodataMenu, groupMenu, buttonClose, save, viewInfo);

        // scene
        scene = new Scene(root, 840, 420, Color.valueOf("#134f5c"));
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());

        // stage
        primaryStage = stage;
        primaryStage.setTitle("Pembagian kelompok");
        primaryStage.getIcons().add(new Image(new FileInputStream("src\\main\\java\\assets\\Picture5.png")));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    private void closeProgram() {
        boolean confirm = confirmClose.display();
        if (confirm) {
            primaryStage.close();
        }
    }

    private Group sceneDisplay() {
        // added circle, region, hbox, imageView, rectangle.
        Circle[] sceneCircle = new Circle[2];
        Region[] sceneRegion = new Region[2];
        Rectangle rect = new Rectangle(860, 100, Color.valueOf("#e09b00"));
        ImageView imageView_1 = icons[6];
        HBox hbox = new HBox(15);

        for (int i = 0; i < sceneRegion.length; i++) {
            sceneCircle[i] = new Circle();
            sceneCircle[i].setFill(Color.valueOf("#e09b00"));
            sceneRegion[i] = new Region();
            sceneRegion[i].setId("region");
            hbox.getChildren().add(sceneRegion[i]);
        }
        // setting hBox
        hbox.setPadding(new Insets(110, 62, 110, 62));

        // setting imageView and rectangle
        imageView_1.setFitHeight(105);
        imageView_1.setFitWidth(650);
        imageView_1.setX(90);
        imageView_1.setY(10);
        rect.setY(350);

        // setting circles
        // circle [0]
        sceneCircle[0].setRadius(80);
        sceneCircle[0].setLayoutX(830);
        sceneCircle[0].setLayoutY(5);

        // circle [1]
        sceneCircle[1].setRadius(400);
        sceneCircle[1].setLayoutX(-30);
        sceneCircle[1].setLayoutY(420);
        sceneCircle[1].setFill(Color.TRANSPARENT);
        sceneCircle[1].setStrokeWidth(140);
        sceneCircle[1].setStroke(Color.valueOf("#0c343d"));

        return new Group(sceneCircle[0], sceneCircle[1], hbox, rect, imageView_1);
    }
}