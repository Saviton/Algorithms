package grokking_algorithms.chapter_3;

public class Timer {
    public static void countDown(int i) {
        System.out.println(i);
        if (i <= 0)
            return;
        else
            countDown(i - 1);
    }

    public static void main(String[] args) {
        countDown(7);
    }
}
