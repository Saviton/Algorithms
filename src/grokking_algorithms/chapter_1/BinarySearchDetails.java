package grokking_algorithms.chapter_1;

public class BinarySearchDetails {

    public static Integer binarySearch(int[] mas, int item) {
        int low = 0;
        int high = mas.length - 1;
        int mid, guess;
        int k = 1;

        while (low <= high) {
            mid = (high + low) / 2;
            guess = mas[mid];

            System.out.println("*** " + k + " Iteration: " + "***");
            System.out.println("item: " + item);
            System.out.println("mid : " + mid);
            System.out.println("low: " + low + ", high: " + high);
            System.out.println("current diapason: ");
            for (int i = low; i <= high; i++) {
                if (i == mid)
                    System.out.print("|" + mas[i] + "| ");
                else
                    System.out.print(mas[i] + " ");
            }
            System.out.println();
            k++;

            if (guess == item)
                return mid;
            if (guess > item) {
                high = mid - 1;
                System.out.println("guess>item");
            } else {
                low = mid + 1;
                System.out.println("guess<item");
            }

            System.out.println("\n");
        }

        return null;
    }

    public static void main(String[] args) {
        int[] mas = {2, 16, 21, 34, 41, 47, 54, 56, 58, 61, 63, 64, 67, 72, 74, 75, 79, 81};

        System.out.println(binarySearch(mas, 24));

    }
}
