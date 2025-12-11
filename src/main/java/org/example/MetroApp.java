package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Главное JavaFX-приложение Metro.
 */
public class MetroApp extends Application {

    /**
     * Запускает сцену JavaFX с загруженным FXML Metro.fxml, устанавливая размер окна 1300x760 пикселей, а заголовок "MetroPath".
     * @param stage основное окно приложения
     * @throws IOException при ошибке загрузки Metro.fxml
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MetroApp.class.getResource("Metro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 760);
        stage.setTitle("MetroPath");
        stage.setScene(scene);
        stage.show();
    }
}