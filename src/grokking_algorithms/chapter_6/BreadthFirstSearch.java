package grokking_algorithms.chapter_6;

import java.util.*;

/** Реализация алгоритма поиска в ширину.
 * */
public class BreadthFirstSearch {
    private static Map<String, List<String>> graph = new HashMap<>();

    private static boolean search(String name) {
        /** Очередь, в которую будут добавляться имена по которым будет проходить проверка.*/
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));
        /** Очередь содержащая имена по которым уже прошла проверка, во избежание избыточных операцций.*/
        Queue<String> searched = new ArrayDeque<>();

        while (!searchQueue.isEmpty()) {
            /** Извлечение имени, которая находится в начале списка.*/
            String person = searchQueue.poll();

            if (!searched.contains(person)) {
                if (person_is_seller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }

        return false;
    }

    /**
     * Глупая проверка, для имитации свойства характерного для продавца манго.
     */
    private static boolean person_is_seller(String name) {
        return name.endsWith("m");
    }


    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        search("you");
    }
}
