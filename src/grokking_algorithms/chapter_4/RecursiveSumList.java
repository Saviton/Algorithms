package grokking_algorithms.chapter_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSumList {

    public static int recursiveSum(List<Integer> list) {
        if (list.size() == 0)
            return 0;
        int term = list.get(0);
        list.remove(0);
        return term + recursiveSum(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 7, 8, 11));
        System.out.println(list.size());
        System.out.println(recursiveSum(list));
    }
}
