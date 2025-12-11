package org.example;

import org.apache.log4j.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Контроллер FXML, управляющий выбором станций, поиском пути и визуализацией результата.
 */
public class MetroController {
    private static final Logger log = Logger.getLogger(MetroController.class);
    private StationSelector selector;

    @FXML
    private Button r0, r1, r2, r3, r4, r5, r6, r7, r8, r9,
            r10, r11, r12, r13, r14, r15, r16, r17, r18,
            b19, b20, b21, b22, b23, b24, b25, b26, b27,
            b28, b29, b30, b31, b32, b33, b34, b35, p36,
            p37, p38, p39, p40, p41, p42, p43, p44, p45,
            p46, p47, p48, g49, g50, g51, g52, g53, g54,
            g55, g56, g57, g58, o59, o60, o61, o62, o63,
            o64, g65, o66,o67,p68, b69, p70, o71,g72;

    @FXML
    private Button result;

    @FXML
    private Label label;

    @FXML
    private ImageView map;

    /**
     * Инициализирует контроллер при загрузке FXML.
     * Создает граф метро, настраивает обработчики кнопок и логирование.
     */
    @FXML
    private void initialize() {
        log.info("The app is ready to use");
        String[] stations = MetroGraph.getStations();
        MetroGraph g = new MetroGraph(stations.length, stations);
        List<Button> buttons = Arrays.asList(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9,
                r10, r11, r12, r13, r14, r15, r16, r17, r18,
                b19, b20, b21, b22, b23, b24, b25, b26, b27,
                b28, b29, b30, b31, b32, b33, b34, b35, p36,
                p37, p38, p39, p40, p41, p42, p43, p44, p45,
                p46, p47, p48, g49, g50, g51, g52, g53, g54,
                g55, g56, g57, g58, o59, o60, o61, o62, o63,
                o64, g65, o66, o67, p68, b69, p70, o71, g72);
        selector = new StationSelector(buttons, map);

        IntStream.range(0, buttons.size())
                .forEach(i -> buttons.get(i)
                        .setOnAction(e -> selector.selectStation(i, buttons.get(i))));

        result.setOnAction(e -> {
            log.debug("Shortest path is being searching for");
            try {
                DijkstraAlgorithm.PathResult res =
                        DijkstraAlgorithm.dijkstrasShortestPath(g.getGraph(), selector.getSrc(), selector.getDest());
                log.info("Path: " + res.path + " " + res.totalTime + " min");
                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).getStyleClass().add("highlighted");
                }

                for (int stationIndex : res.pathInd) {
                    buttons.get(stationIndex).getStyleClass().remove("highlighted");
                }
                selector.clearSelection();
                label.setText(Integer.toString(res.totalTime));
                map.getStyleClass().add("ghost-image");
            } catch (ArrayIndexOutOfBoundsException ex) {
                log.error("Error: choose station");
                ErrorBox.showError();
            }
        });
    }
}