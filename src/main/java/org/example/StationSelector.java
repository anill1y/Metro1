package org.example;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.util.List;

/**
 * Класс управляет выбором начальной и конечной станций на карте метро.
 */
public class StationSelector {
    private int src = -1;
    private int dest = -1;
    private Button s;
    private Button d;
    private final List<Button> buttons;
    private final ImageView map;

    /**
     * Создает селектор станций для списка кнопок и карты метро.
     * @param buttons список всех кнопок станций
     * @param map ImageView с картой метро
     */
    public StationSelector(List<Button> buttons, ImageView map) {
        this.buttons = buttons;
        this.map = map;
    }

    /**
     * Обрабатывает клик по кнопке для выбора начальной и конечной станции
     * Метод позволяет отслеживать порядок нажатия кнопок станций для их подсветки, используя css
     * @param stationIndex индекс станции
     * @param button кнопка станции для подсветки
     */
    public  void selectStation(int stationIndex, Button button) {
        if (src == -1) {
            src = stationIndex;
            s = button;
            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).getStyleClass().remove("highlighted");
            }
            s.getStyleClass().add("highlighted");
            map.getStyleClass().remove("ghost-image");
        } else if (dest == -1 && stationIndex != src) {
            dest = stationIndex;
            d = button;
            d.getStyleClass().add("highlighted");
        } else if (stationIndex == src) {
            s.getStyleClass().remove("highlighted");
            src = -1;
            s = null;
        } else if (stationIndex == dest) {
            d.getStyleClass().remove("highlighted");
            dest = -1;
            d = null;;
        } else {
            if (d != null) {
                d.getStyleClass().remove("highlighted");
            }
            dest = stationIndex;
            d = button;
            d.getStyleClass().add("highlighted");
        }
    }

    /**
     * Метод очищает выбор станций и убирает подсветку пути
     */
    public void clearSelection() {
        if (s != null) {
            s.getStyleClass().remove("highlighted");
        }
        if (d != null) {
            d.getStyleClass().remove("highlighted");
        }
        src = -1;
        dest = -1;
        s = null;
        d = null;
    }

    /**
     * Возвращает индекс начальной станции или -1, если она не была выбрана.
     * @return индекс начальной станции(src) или -1
     */
    public int getSrc() {
        return src;
    }

    /**
     * Возвращает индекс конечной станции или -1 если она не была выбрана.
     *
     * @return индекс конечной станции (dest) или -1
     */
    public int getDest() {
        return dest;
    }
}