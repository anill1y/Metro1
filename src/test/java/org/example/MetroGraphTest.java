package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetroGraphTest {
    @Test
    void testGetStations() {
        String[] stations = MetroGraph.getStations();
        assertEquals(73, stations.length);
        assertEquals("Devyatkino", stations[0]);
        assertEquals("Gostiny dvor", stations[72]);
    }

    @Test
    void testMetroGraphEdges() {
        MetroGraph metro = new MetroGraph(73, MetroGraph.getStations());
        Graph g = metro.getGraph();
        assertEquals(3, g.adjMatrix[0][1]);
        assertEquals(3, g.adjMatrix[1][0]);
    }
}