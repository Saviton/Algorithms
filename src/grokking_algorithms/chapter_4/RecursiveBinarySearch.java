package grokking_algorithms.chapter_4;

public class RecursiveBinarySearch {

    public static Integer recursiveBinarySearch(int[] mas, int item) {
        return recursiveBinarySearch(mas, item, 0, mas.length);
    }

    public static Integer recursiveBinarySearch(int[] mas, int item, int low, int high) {
        int mid = (low + high) / 2, guess = mas[mid];

        /** базовый случай: */
        if (guess == item)
            return mid;
        if (low > high)
            return null;

        /** рекурсивный случай:*/
        if (guess > item) {
            high = mid - 1;
            return recursiveBinarySearch(mas, item, low, high);
        } else {
            low = mid + 1;
            return recursiveBinarySearch(mas, item, low, high);
        }
    }

    public static void main(String[] args) {
        int[] mas = {1, 4, 7, 9, 11, 14, 29, 31};

        System.out.println(recursiveBinarySearch(mas, 0));
    }
}
