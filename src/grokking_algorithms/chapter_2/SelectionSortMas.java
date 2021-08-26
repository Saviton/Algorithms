package grokking_algorithms.chapter_2;

import java.util.Arrays;

public class SelectionSortMas {

    public static int[] selectionSort(int[] mas) {
        int[] newMas = new int[mas.length];
        int smallestIndex;

        for (int i = 0; i < newMas.length; i++) {
            smallestIndex = findSmallest(mas);
            newMas[i] = mas[smallestIndex];

            mas = getNewMasWithOutSmallest(mas, smallestIndex);
        }

        return newMas;
    }

    public static int[] getNewMasWithOutSmallest(int[] mas, int smallestIndex) {
        int[] newMas = new int[mas.length - 1];

        for (int i = 0; i < mas.length; i++) {
            if (i < smallestIndex)
                newMas[i] = mas[i];
            else if (i > smallestIndex)
                newMas[i - 1] = mas[i];
        }

        return newMas;
    }

    public static int findSmallest(int[] mas) {
        int smallest = mas[0];
        int smallestIndex = 0;

        for (int i = 0; i < mas.length; i++) {
            if (smallest > mas[i]) {
                smallest = mas[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static void main(String[] args) {
        int[] mas = {21, 4, 6, 2, 6, 8, 3, 5, 7, 8, 11, 23, 34};
        Arrays.sort(mas);
        System.out.println(Arrays.toString(selectionSort(mas)));
    }
}
