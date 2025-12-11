package org.example;

import java.util.*;

/**
 * Класс, реализующий алгоритм Дейкстры для поиска кратчайшего пути между станциями.
 */
public class DijkstraAlgorithm {

    /**
     * Внутренний класс для хранения результатов выполнения алгоритма Дейкстры.
     */
    public static class PathResult {
        public int[] distances;
        public int[] previous;
        public String path;
        public int totalTime;
        public List<Integer> pathInd;

        /**
         * Конструктор результата пути.
         * @param distances массив расстояний до вершин
         * @param previous массив пройденных вершин
         */
        PathResult(int[] distances, int[] previous) {
            this.distances = distances;
            this.previous = previous;
            this.pathInd = new ArrayList<>();
        }
    }

    /**
     * Метод находит ближайшую непосещённую вершину с минимальным расстоянием до нее.
     * Через цикл for идет проверка на то, что вершину алгортим еще не посетил и расстояние до нее меньше, чем данное
     * @param distance массив текущих расстояний до вершин
     * @param visited массив посещённых алгоритмом вершин
     * @return Возвращает индекс ближайшей вершины или -1 если все вершины посещены
     */
    public static int getClosestVertex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    /**
     * Основной алгоритм Дейкстры для поиска кратчайшего пути от начальной до конечной станции.
     * Алгоритм Дейкстры постепенно выбирает ближайшие вершины, обновляя кратчайшие пути от исходной точки ко всем остальным вершинам графа, тем самым находя оптимальный путь
     * @param g граф метро с матрицей смежности (в минутах)
     * @param src индекс начальной станции
     * @param dest индекс конечной станции
     * @return Возвращает объект PathResult с пройденным путем и затраченным на него временем
     * @throws IllegalArgumentException если индекс начальной или конечной станции находится вне границ графа
     */
    public static PathResult dijkstrasShortestPath(Graph g, int src, int dest) {
        int[] distance = new int[g.numvertices];
        boolean[] visited = new boolean[g.numvertices];
        int[] previous = new int[g.numvertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        Arrays.fill(previous, -1);
        distance[src] = 0;

        for (int i = 0; i < g.numvertices; i++) {
            int closestVertex = getClosestVertex(distance, visited);
            if (closestVertex == -1) break;
            visited[closestVertex] = true;

            for (int j = 0; j < g.numvertices; j++) {
                if (!visited[j] && g.adjMatrix[closestVertex][j] != 0) {
                    int newDist = distance[closestVertex] + g.adjMatrix[closestVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                        previous[j] = closestVertex;
                    }
                }
            }
        }
        PathResult result = new PathResult(distance, previous);
        buildPath(g, result, dest);
        return result;
    }

    /**
     * Восстанавливает путь, пройденный алгоритмом Дейкстры, от конечной до начальной станции и формирует его строковое представление.
     * Заполняет pathInd индексами станций и totalTime временем пути.
     * @param g граф с названиями вершин
     * @param result результат алгоритма
     * @param dest индекс конечной станции
     */
    private static void buildPath(Graph g, PathResult result, int dest) {
        StringBuilder pathStr = new StringBuilder();
        result.totalTime = result.distances[dest];

        if (result.distances[dest] != Integer.MAX_VALUE) {
            List<Integer> path = new ArrayList<>();
            for (int at = dest; at != -1; at = result.previous[at]) {
                path.add(at);
            }
            Collections.reverse(path);

            for (int i = 0; i < path.size(); i++) {
                result.pathInd.add(path.get(i));
                pathStr.append(g.vertexNames[path.get(i)]);
                if (i < path.size() - 1) {
                    pathStr.append(" -> ");
                }
            }
        } else {
            pathStr.append("Path is unavailable");
            result.pathInd.clear();
        }
        result.path = pathStr.toString();
    }
}