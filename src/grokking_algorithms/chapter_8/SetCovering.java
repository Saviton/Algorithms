package grokking_algorithms.chapter_8;

import java.util.*;

public class SetCovering {
    public static void main(String... args) {
        /** Список всех необходимых нам станций.*/
        var statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        /** Список радиостанций, с которыми можно заключить контракт.
         * Хранится в формате хеш-таблицы, где название(key), и штаты на которые вещает(value).*/
        var stations = new LinkedHashMap<String, Set<String>>();

        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        /** Список станций с которыми будет заключен контракт.*/
        var finalStations = new HashSet<String>();
        /** Пока есть штат, на котором не транслируют нашу программу.*/
        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            var statesCovered = new HashSet<String>();

            for (var station : stations.entrySet()) {
                /** Передаем в covered, станции с которыми ещё не заключён контракт.*/
                var covered = new HashSet<>(statesNeeded);
                /** Пересечение множества covered и значений хеш-таблицы station.*/
                covered.retainAll(station.getValue());

                /** Покрывает ли стация covered, больше штатов чем текущая станция.*/
                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }
            /** Из списка нужных штатов, удаляем штаты,
             * которые покрыты радиостанцией, с которой мы заключили контракт.*/
            statesNeeded.removeIf(statesCovered::contains);

            if (bestStation != null) {
                finalStations.add(bestStation);
            }
        }

        System.out.println(finalStations);
    }
}