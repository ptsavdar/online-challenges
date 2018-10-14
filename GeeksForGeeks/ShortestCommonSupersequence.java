package GeeksForGeeks;

import java.util.Scanner;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String phrase = sc.nextLine();
            String[] words = phrase.split(" ");
            System.out.println(words[0].length() + words[1].length() - lcsLength(words[0], words[1]));
        }

        sc.close();
    }

    private static int lcsLength(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
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
