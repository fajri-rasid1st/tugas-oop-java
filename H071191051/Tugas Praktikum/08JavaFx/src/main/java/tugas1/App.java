package tugas1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    Stage mainStage;
    int money = 100000;
    String[] foodName = new String[7];
    ConfirmClose cClose = new ConfirmClose();
    int[] foodPrice = { 10000, 8000, 15000, 7000, 3000, 12000, 20000 };

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        // Title of the restaurant
        Circle titleBackground = new Circle(500, 500, 500, Color.valueOf("#33c5e2"));
        titleBackground.setCenterY(-360);
        titleBackground.setCenterX(200);
        Image icon = new Image(new FileInputStream("src\\main\\java\\assets\\0 title restaurant.png"));
        ImageView image = new ImageView(icon);
        image.setFitHeight(250);
        image.setFitWidth(350);
        image.setX(5);
        image.setY(-40);

        // Menu of the restaurant

        // mengambil gambar menu
        Image[] foodMenu = new Image[7];
        for (int i = 0; i < 7; i++) {
            foodMenu[i] = new Image(new FileInputStream("src\\main\\java\\assets\\menu" + (i + 1) + ".png"));
        }

        // menampilkan jumlah orderan
        Order[] order = new Order[7];
        for (int i = 0; i < order.length; i++) {
            order[i] = new Order(0);
        }

        // menampilkan group menu
        FileReader fileInput = new FileReader("src\\main\\java\\tugas1\\ListMenu.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);
        String data = bufferInput.readLine();

        MenuDisplay[] menuDisplay = new MenuDisplay[7];
        Group[] menuGroup = new Group[7];
        int index = 0;

        while (data != null) {
            StringTokenizer sTokens = new StringTokenizer(data, ";");
            foodName[index] = sTokens.nextToken();

            menuDisplay[index] = new MenuDisplay(setImageMenu(foodMenu[index], 120, 120, 15, 15), setRectangleMenu(),
                    setLabelMenu(foodName[index] + "\n" + sTokens.nextToken() + "\n\n\n" + sTokens.nextToken(), 155,
                            20),
                    order[index].setOrderer(155, 75));
            menuGroup[index] = menuDisplay[index].getGroupMenu();

            index++;
            data = bufferInput.readLine();
        }
        bufferInput.close();
        fileInput.close();

        // Order
        Label yourMoney = new Label("Uang kamu : Rp." + money);
        yourMoney.setId("yourMoney");
        yourMoney.setLayoutX(100);

        Button button = new Button("Buat Pesanan");
        button.setId("orderButton");
        button.setPrefHeight(20);
        button.setPrefWidth(320);
        button.setOnAction(e -> {
            try {
                transaction(yourMoney, order);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        // V box
        VBox vb = new VBox(25);
        vb.getChildren().addAll(menuGroup[0], menuGroup[1], menuGroup[2], menuGroup[3], menuGroup[4], menuGroup[5],
                menuGroup[6], yourMoney, button);
        vb.setPadding(new Insets(172, 20, 172, 20)); // top, right, bottom, left

        // Scroll bar
        ScrollBar scBar = new ScrollBar();
        scBar.setOrientation(Orientation.VERTICAL);
        scBar.setPrefHeight(650);
        scBar.setPrefWidth(15);
        scBar.setLayoutX(365);
        scBar.setVisibleAmount(200);
        scBar.setMax(850);
        scBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                vb.setLayoutY(-(newValue.doubleValue()));
            }
        });

        // group
        Group root = new Group(vb, titleBackground, image, scBar);

        // scene
        Scene scene = new Scene(root, 380, 650, Color.valueOf("#134f5c"));
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        // stage
        Image stageIcon = new Image(new FileInputStream("src\\main\\java\\assets\\food2.png"));
        mainStage = stage;
        mainStage.setScene(scene);
        mainStage.setMaximized(false);
        mainStage.setResizable(false);
        mainStage.setTitle("Ngabuburit Resto");
        mainStage.getIcons().add(stageIcon);
        // mainStage.initStyle(StageStyle.TRANSPARENT);
        mainStage.setOnCloseRequest(e -> {
            e.consume();
            try {
                closeProgram();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        mainStage.show();
    }

    private void closeProgram() throws IOException {
        boolean isExit = cClose.display();
        if (isExit) {
            mainStage.close();
        }
    }

    private ImageView setImageMenu(Image foodMenu, double height, double width, double x, double y) {
        ImageView foodImage = new ImageView(foodMenu);
        foodImage.setFitHeight(height);
        foodImage.setFitWidth(width);
        foodImage.setX(x);
        foodImage.setY(y);
        return foodImage;
    }

    private Rectangle setRectangleMenu() {
        Rectangle foodBackground = new Rectangle(328, 148, Color.valueOf("#4abaff"));
        foodBackground.setArcHeight(35);
        foodBackground.setArcWidth(35);
        foodBackground.opacityProperty().set(0.5);
        return foodBackground;
    }

    private Label setLabelMenu(String text, double x, double y) {
        Label foodLabel = new Label(text);
        foodLabel.setLayoutX(x);
        foodLabel.setLayoutY(y);
        foodLabel.setId("labelMenu");
        return foodLabel;
    }

    private void transaction(Label label, Order[] order) throws FileNotFoundException {
        int totalPrice = 0;
        String contenText = "";

        for (int i = 0; i < order.length; i++) {
            contenText = contenText + (order[i].getOrder() + " " + foodName[i] + " seharga Rp."
                    + (order[i].getOrder() * foodPrice[i]) + "\n");
            totalPrice += (order[i].getOrder() * foodPrice[i]);
        }

        if (totalPrice != 0) {
            if (money - totalPrice >= 0) {
                Alert confirmBuy = new Alert(AlertType.CONFIRMATION);
                confirmBuy.initStyle(StageStyle.TRANSPARENT);
                confirmBuy.setTitle("Konfirmasi Pesanan");
                confirmBuy.setHeaderText("Pesanan anda adalah :");
                confirmBuy.setContentText(contenText + "Total : Rp." + totalPrice
                        + "\n\nTekan 'OK' untuk memesan\nTekan 'Cancel' untuk membatalkan");

                Optional<ButtonType> result = confirmBuy.showAndWait();

                if (result.get() == ButtonType.OK) {
                    Transaction succesfull = new Transaction();
                    succesfull.display("Terima kasih telah memesan");
                    for (int i = 0; i < order.length; i++) {
                        order[i].resetOrder();
                    }
                    money -= totalPrice;
                    label.setText("Sisa uang kamu : Rp." + money);
                }
            } else {
                Transaction failed_1 = new Transaction();
                failed_1.display("Uang anda tidak cukup!");
            }
        } else {
            Transaction failed_2 = new Transaction();
            failed_2.display("Anda belum memesan apa-apa!");
        }
    }
}