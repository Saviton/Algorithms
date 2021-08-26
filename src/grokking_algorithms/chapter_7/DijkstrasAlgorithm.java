package grokking_algorithms.chapter_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstrasAlgorithm {
    /** Граф:*/
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    /** Обработанные узлы.*/
    private static List<String> processed = new ArrayList<>();

    private static String findLowestCostNode(Map<String, Double> costs) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        /** Перебираем все узлы.*/
        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();
            /** Если это узел с найменьшей стоимость из уже просмотренных,
             * и он ещё не был обработан.*/
            if (cost < lowestCost && !processed.contains(node.getKey())) {
                /** помечаем этот узел, как узел с найменьшей стоимостью.*/
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }

        return lowestCostNode;
    }

    public static void main(String[] args) {
        /** Хеш-таблица, хеш-таблиц содержащая [точку входа в графе](ключ) и
         * [названия вершин и вес ребер которых можно достичь с начала графа](значение). */
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        /** Хеш-таблица, хеш-таблиц содержащая [название вершины [a] ](ключ) и
         * [названия вершин и вес ребер которых можно достичь из вершины [a] ](значение). */
        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        /** Хеш-таблица, хеш-таблиц содержащая [название вершины [b] ](ключ) и
         * [названия вершин и вес ребер которых можно достичь из вершины [b] ](значение). */
        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        /** хеш-таблица, хеш таблиц характерезующая конец графа.*/
        graph.put("fin", new HashMap<>());

        /** таблица стоимостей*/
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);

        /** таблица родителей*/
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = findLowestCostNode(costs);

        /** Если обработаны все узлы, цикл while завершен.*/
        while (node != null) {
            Double cost = costs.get(node);

            /**хеш-таблица характерезующая соседей*/
            Map<String, Double> neighbors = graph.get(node);

            /** перебор всех соседей текущего узла*/
            for (String n : neighbors.keySet()) {
                double newCost = cost + neighbors.get(n);
                /** Если к соседу можно быстрее добраться через текущий узел*/
                if (costs.get(n) > newCost) {
                    /** обновляем стоимости для текущего узла.*/
                    costs.put(n, newCost);
                    /** этот узел становится новым родителем для соседа.*/
                    parents.put(n, node);
                }
            }
            /** помечаем узел как обработанный, путем занесения его в лист processed.*/
            processed.add(node);

            /** находим следующий узел для обработки и повторяем цикл.*/
            node = findLowestCostNode(costs);
        }

        System.out.println("Cost from the start to each node:");
        System.out.println(costs);
    }
}
