package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    void testAddEdge() {
        String[] names = {"A", "B", "C"};
        Graph graph = new Graph(3, names);

        graph.addEdge(0, 1, 5);

        assertEquals(5, graph.adjMatrix[0][1]);
        assertEquals(5, graph.adjMatrix[1][0]);
        assertEquals(0, graph.adjMatrix[0][2]);
    }
}