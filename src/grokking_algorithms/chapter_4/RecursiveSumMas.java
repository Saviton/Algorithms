package grokking_algorithms.chapter_4;

import java.util.Arrays;

public class RecursiveSumMas {

    public static int recursiveSum(int[] mas) {
        if (mas.length == 0)
            return 0;
        return mas[0] + recursiveSum(Arrays.copyOfRange(mas, 1, mas.length));

    }

    public static void main(String[] args) {
        int[] mas = {1, 5, 4};
        System.out.println(recursiveSum(mas));

    }
}
