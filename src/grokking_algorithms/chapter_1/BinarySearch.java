package grokking_algorithms.chapter_1;

public class BinarySearch {

    public static Integer binarySearch(int[] list, int item) {
        int low = 0, high = list.length - 1;
        int guess, mid;

        while (low <= high) {
            mid = (low + high) / 2;
            guess = list[mid];

            if (guess == item)
                return mid;

            if (guess > item)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return null;
    }

    public static void main(String[] args) {
        int[] mas = {1, 4, 7, 9, 11, 14, 29, 31};

        System.out.println(binarySearch(mas, 30));

    }
}
