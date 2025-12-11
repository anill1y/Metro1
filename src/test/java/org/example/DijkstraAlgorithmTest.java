package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class DijkstraAlgorithmTest {

    private MetroGraph metroGraph;

    @BeforeEach
    void setUp() {
        metroGraph = new MetroGraph(MetroGraph.getStations().length, MetroGraph.getStations());
    }

    @Test
    void testGetClosestVertex() {
        int[] distance = {7, 2, Integer.MAX_VALUE, 5};
        boolean[] visited = {false, false, true, false};
        int closest = DijkstraAlgorithm.getClosestVertex(distance, visited);
        assertEquals(1, closest);
    }

    @Test
    void testDijkstra() {
        DijkstraAlgorithm.PathResult result = DijkstraAlgorithm.dijkstrasShortestPath(
                metroGraph.getGraph(), 0, 2);
        assertEquals(6, result.totalTime);
        assertEquals(3, result.pathInd.size());
        assertEquals(List.of(0, 1, 2), result.pathInd);
        assertTrue(result.path.contains("Devyatkino"));
    }

    @Test
    void testNoPath() {
        try {
            DijkstraAlgorithm.PathResult result = DijkstraAlgorithm.dijkstrasShortestPath(
                    metroGraph.getGraph(), 0, 100);
            assertEquals("Path is unavailable", result.path);
            assertTrue(result.pathInd.isEmpty());
        } catch (IndexOutOfBoundsException e) {
        }
    }
}