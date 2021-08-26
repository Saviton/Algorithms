package grokking_algorithms.chapter_4;

import java.util.Arrays;

public class RecursiveMax {

    public static int recursiveMaxInMas(int[] mas) {
        if (mas.length == 2)
            return Math.max(mas[0], mas[1]);
        int subMax = recursiveMaxInMas(Arrays.copyOfRange(mas, 1, mas.length));
        return Math.max(mas[0], subMax);

    }

    public static void main(String[] args) {
        int[] mas = {1, 5, 4, 5};
        System.out.println(recursiveMaxInMas(mas));
    }
}
