package GeeksForGeeks;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            String word1 = sc.nextLine();
            String word2 = sc.nextLine();
            System.out.println(lcsLength(word1, word2, m, n));
        }

        sc.close();
    }

    private static int lcsLength(String word1, String word2, int m, int n) {
        int[][] c = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
                }
            }
        }
        return c[m][n];
    }
}
