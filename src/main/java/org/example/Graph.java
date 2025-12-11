package org.example;

/**
 * Класс графа сети метро.
 */
public class Graph {
    public int numvertices;
    public int[][] adjMatrix;
    public String[] vertexNames;

    /**
     * Создает граф с заданным количеством вершин и названиями станций.
     * Инициализирует матрицу смежности нулями.
     * @param numVertices количество всех станций
     * @param vertexNames массив названий станций
     */
    public Graph(int numVertices, String[] vertexNames) {
        this.numvertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
        this.vertexNames = vertexNames;

        for(int i = 0; i < numVertices; i++) {
            for(int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    /**
     * Добавляет в матрицу, представляющую граф, ребро между станциями с весом в минутах.
     * @param from индекс начальной станции
     * @param to индекс конечной станции
     * @param weight время поездки в минутах
     */
    public void addEdge(int from, int to, int weight) {
        adjMatrix[from][to] = weight;
        adjMatrix[to][from] = weight;
    }
}