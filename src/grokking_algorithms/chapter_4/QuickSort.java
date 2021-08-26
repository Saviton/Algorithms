package grokking_algorithms.chapter_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Быстрая сортировка. *
 */
public class QuickSort {

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2)
            return list;
        int pivot = list.get(0);

        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (pivot >= list.get(i))
                less.add(list.get(i));
            else
                greater.add(list.get(i));
        }

/**
 return quickSort(less) + pivot + quickSort(greater);
 */
        return Stream.of(
                quickSort(less).stream(),
                Stream.of(pivot),
                quickSort(greater).stream())
                .flatMap(Function.identity()).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(21, 4, 6, 2, 6, 8, 3, 5, 7, 8, 11, 23, 34));
        System.out.println(quickSort(arr));
    }
}
