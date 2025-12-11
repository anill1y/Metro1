package org.example;

import javafx.application.Application;

/**
 * Главный класс приложения.
 * @author Анна
 */
public class Main {

    /**
     * Точка входа в приложение.
     * Метод передает аргументы командной строки в Application.launch().
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Application.launch(MetroApp.class, args);
    }
}