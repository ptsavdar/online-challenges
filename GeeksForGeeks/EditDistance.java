package GeeksForGeeks;

import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            String phrase = sc.nextLine();
            String[] words = phrase.split(" ");
            System.out.println(editDistance(words[0], words[1], m, n));
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
                int matchCost = c[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1)? 0 : 1);
                int insCost = c[i][j - 1] + 1;
                int delCost = c[i - 1][j] + 1;
                c[i][j] = Math.min(Math.min(matchCost, insCost), delCost);
            }
        }

        return c[m][n];
    }
}
