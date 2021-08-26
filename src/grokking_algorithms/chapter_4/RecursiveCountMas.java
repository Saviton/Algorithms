package grokking_algorithms.chapter_4;

import java.util.Arrays;

public class RecursiveCountMas {

    public static int count(int[] mas) {
        if (mas.length == 0)
            return 0;
        return 1 + count(Arrays.copyOfRange(mas, 1, mas.length));
    }

    public static void main(String[] args) {
        int[] mas = {1, 5, 4, 9};
        System.out.println(count(mas));
    }
}
