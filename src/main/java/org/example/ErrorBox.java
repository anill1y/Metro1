package org.example;

import javafx.scene.control.Alert;

/**
 * Класс для отображения ошибок при неправильном выборе станций.
 */
public class ErrorBox {

    /**
     * Показывает диалоговое окно ошибки с сообщением "Choose station".
     * Используется при отсутствии выбранных станций для поиска пути.
     */
    public static void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Choose station");
        alert.showAndWait();
    }
}