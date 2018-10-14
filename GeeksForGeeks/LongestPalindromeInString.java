package GeeksForGeeks;

import java.util.Scanner;

public class LongestPalindromeInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String word = sc.nextLine();
            String reverse = new StringBuilder(word).reverse().toString();
            System.out.println(editDistance(word, reverse, word.length(), reverse.length()));
        }

        sc.close();
    }

    private static int editDistance(String word1, String word2, int m, int n) {
        int dim = Math.max(m, n);
        int[][] c = new int[dim + 1][dim + 1];
        for (int i = 0; i <= dim; i++) {
            c[0][i] = i;
            c[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j<= n; j++) {
                int insCost = c[i][j - 1] + 1;
                int delCost = c[i - 1][j] + 1;
                c[i][j] = Math.min(insCost, delCost);
            }
        }

        return c[m][n];
    }
}
