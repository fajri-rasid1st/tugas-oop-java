package tugas3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HandlingChooser {

    File getFile(FileChooser fileCs, Stage stage, Window window) throws IOException {

        fileCs.setInitialDirectory(new File("src\\main\\java\\assets3"));
        fileCs.setTitle("Open text file");
        fileCs.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));

        File file = fileCs.showOpenDialog(stage);

        return file;
    }

    String readFile(File file) throws FileNotFoundException {
        String text = "";
        Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name());

        while (sc.hasNextLine()) {
            text = text + sc.nextLine();
            text += "\n";
        }

        sc.close();
        return text;
    }
}