package grokking_algorithms.chapter_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSortList {

    public static List<Integer> selectionSort(List<Integer> arr) {
        List<Integer> newArr = new ArrayList<Integer>();
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            newArr.add(arr.get(findSmallest(arr)));
            arr.remove(findSmallest(arr));
        }

        return newArr;
    }

    public static int findSmallest(List<Integer> arr) {
        int smallest = arr.get(0);
        int smallestIndex = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (smallest > arr.get(i)) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(21, 4, 6, 2, 6, 8, 3, 5, 7, 8, 11, 23, 34));
        System.out.println(selectionSort(arr));
    }
}
