package org.example;

/**
 * Граф метро Санкт-Петербурга.
 */
public class MetroGraph {
    private Graph g;
    private static String[] stations = {"Devyatkino", "Grazhdanskiy prospekt", "Akademicheskaya", "Politekhnicheskaya", "Ploshchad Muzhestva", "Lesnaya", "Vyborgskaya", "Ploshchad Lenina",
            "Chernyshevskaya", "Ploshchad Vosstaniya", "Vladimirskaya", "Pushkinskaya", "Tekhnologicheskiy institut 1", "Baltiyskaya", "Narvskaya", "Kirovskiy zavod", "Avtovo",
            "Leninskiy prospekt", "Prospekt Veteranov", "Parnas", "Prospekt Prosveshcheniya", "Ozerki", "Udelnaya", "Pionerskaya", "Chyornaya rechka", "Petrogradskaya",
            "Gorkovskaya", "Nevskiy prospekt", "Sennaya ploshchad", "Frunzenskaya", "Moskovskiye vorota", "Elektrosila", "Park Pobedy", "Moskovskaya",
            "Zvyozdnaya", "Kupchino", "Komendantskiy prospekt", "Staraya Derevnya", "Krestovskiy ostrov", "Chkalovskaya", "Sportivnaya", "Admiralteyskaya", "Obvodny kanal",
            "Volkovskaya", "Bukharestskaya", "Mezhdunarodnaya", "Prospekt Slavy", "Dunayskaya", "Shushary", "Begovaya", "Zenit", "Primorskaya",
            "Vasileostrovskaya", "Ploshchad Aleksandra Nevskogo 1", "Elizarovskaya", "Lomonosovskaya", "Proletarskaya", "Obukhovo", "Rybatskoye", "Gornyy institut", "Ligovskiy prospekt",
            "Novocherkasskaya", "Ladozhskaya", "Prospekt Bolshevikov", "Ulitsa Dybenko", "Mayakovskaya", "Dostoevskaya", "Ploshchad Aleksandra Nevskogo 2", "Zvenigorodskaya",
            "Tekhnologicheskiy institut 2", "Sadovaya", "Spasskaya", "Gostiny dvor"};

    /**
     * Создает граф метро СПб с нулевыми ребрами.
     * @param numStations количество станций
     * @param stations названия станций
     */
    public MetroGraph(int numStations, String[] stations) {
        this.stations = stations;
        this.g = new Graph(numStations, stations);
        initializeMetroGraph();
    }

    /**
     * Возвращает массив названий всех объявленных в поле станций метро СПб.
     * @return массив строк с названиями станций
     */
    public static String[] getStations() {
        return stations;
    }

    /**
     * Возвращает внутренний граф метро для алгоритма Дейкстры.
     * @return объект Graph с матрицей смежности
     */
    public Graph getGraph() {
        return g;
    }

    /**
     * Инициализирует все ребра графа для метро СПб.
     * Добавляет связи между станциями и пересадками между лиинями
     */
    private void initializeMetroGraph() {
        g.addEdge(0, 1, 3);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 3);
        g.addEdge(4, 5, 3);
        g.addEdge(5, 6, 3);
        g.addEdge(6, 7, 2);
        g.addEdge(7, 8, 3);
        g.addEdge(8, 9, 2);
        g.addEdge(9, 10, 2);
        g.addEdge(9, 65, 2);
        g.addEdge(10, 11, 2);
        g.addEdge(11, 12, 2);
        g.addEdge(12, 13, 2);
        g.addEdge(13, 14, 3);
        g.addEdge(14, 15, 4);
        g.addEdge(15, 16, 2);
        g.addEdge(16, 17, 3);
        g.addEdge(17, 18, 2);
        g.addEdge(19, 20, 3);
        g.addEdge(20, 21, 2);
        g.addEdge(21, 22, 3);
        g.addEdge(22, 23, 3);
        g.addEdge(23, 24, 3);
        g.addEdge(24, 25, 4);
        g.addEdge(25, 26, 2);
        g.addEdge(26, 27, 4);
        g.addEdge(27, 28, 2);
        g.addEdge(28, 69, 3);
        g.addEdge(69, 29, 2);
        g.addEdge(29, 30, 2);
        g.addEdge(30, 31, 2);
        g.addEdge(31, 32, 2);
        g.addEdge(32, 33, 3);
        g.addEdge(33, 34, 4);
        g.addEdge(34, 35, 3);
        g.addEdge(36, 37, 3);
        g.addEdge(37, 38, 3);
        g.addEdge(38, 39, 3);
        g.addEdge(39, 40, 2);
        g.addEdge(40, 41, 3);
        g.addEdge(41, 70, 3);
        g.addEdge(70, 68, 2);
        g.addEdge(68, 42, 3);
        g.addEdge(42, 43, 3);
        g.addEdge(43, 44, 3);
        g.addEdge(44, 45, 3);
        g.addEdge(45, 46, 3);
        g.addEdge(46, 47, 2);
        g.addEdge(47, 48, 3);
        g.addEdge(49, 50, 4);
        g.addEdge(50, 51, 4);
        g.addEdge(51, 52, 4);
        g.addEdge(52, 72, 4);
        g.addEdge(72, 65, 3);
        g.addEdge(65, 53, 3);
        g.addEdge(53, 54, 5);
        g.addEdge(54, 55, 3);
        g.addEdge(55, 56, 3);
        g.addEdge(56, 57, 3);
        g.addEdge(57, 58, 4);
        g.addEdge(59, 71, 5);
        g.addEdge(71, 66, 4);
        g.addEdge(66, 60, 2);
        g.addEdge(10, 66, 2);
        g.addEdge(60, 67, 2);
        g.addEdge(67, 61, 3);
        g.addEdge(61, 62, 3);
        g.addEdge(62, 63, 3);
        g.addEdge(63, 64, 2);
        g.addEdge(53, 67, 2);
        g.addEdge(11, 68, 2);
        g.addEdge(69, 12, 1);
        g.addEdge(70, 28, 3);
        g.addEdge(71, 66, 4);
        g.addEdge(71, 70, 3);
        g.addEdge(71, 28, 3);
        g.addEdge(27, 72, 2);
    }
}