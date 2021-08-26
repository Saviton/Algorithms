package grokking_algorithms.chapter_9;

import java.util.Arrays;

/**
 * Программа предпологающая насколько слово word_a похоже на word_b
 * Псевдокод:
 * //        if (word_a[i] == word_b[j]) {
 * //            cell[i][j] = cell[i - 1][j - 1] + 1;
 * //        } else {
 * //            cell[i][j] = Math.Max(cell[i - 1][j], cell[i][j - 1]);
 * //        }
 */

public class DynamicProgramming {

    public static void LongestCommonSubSequence(String word_a, String word_b) {
        int[][] cell = new int[word_a.length()][word_b.length()];

        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                if (word_a.charAt(i) == word_b.charAt(j)) {
                    if (i > 0 && j > 0)
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    else
                        cell[i][j] = 1;

                } else {
                    if (i == 0 && j > 0)
                        cell[i][j] = cell[i][j - 1];
                    else if (i > 0 && j == 0)
                        cell[i][j] = cell[i - 1][j];
                    else if (i > 0 && j > 0)
                        cell[i][j] = Math.max(cell[i - 1][j], cell[i][j - 1]);
                    else
                        cell[i][j] = 0;
                }
            }
        }

        printMas(cell);
    }

    public static void main(String[] args) {
        String fish = "fish";
        String hish = "hish";

        LongestCommonSubSequence(fish, hish);

    }

    private static void printMas(int[][] mas) {
        for (int[] row : mas) {
            System.out.println(Arrays.toString(row));
        }
    }

}
