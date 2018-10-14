package HiredInTech;

import java.util.Scanner;

public class WordsWithTypos {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String word = sc.nextLine();
        String txt = sc.nextLine();
        sc.close();
        System.out.println(countOccurencies(txt, word));
    }

    private static int countOccurencies(String txt, String word) {
        String[] words = txt.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isTypo(word, words[i])) count++;
        }

        return count;
    }

    private static boolean isTypo(String w1, String w2) {
        if (w1.length() - w2.length() < 2) {
            int dist = editDistance(w1, w2);
            if ((w1.length() == w2.length() && dist < 3) || (w1.length() != w2.length() && dist < 2)) return true;
        }

        return false;
    }

    private static int editDistance(String w1, String w2) {
        int m = w1.length(), n = w2.length();
        int dim = Math.max(m, n);
        int[][] c = new int[dim + 1][dim + 1];
        for (int i = 0; i <= dim; i++) {
            c[0][i] = i;
            c[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j<= n; j++) {
                int matchCost = c[i - 1][j - 1] + (w1.charAt(i - 1) == w2.charAt(j - 1)? 0 : 1);
                int insCost = c[i][j - 1] + 1;
                int delCost = c[i - 1][j] + 1;
                c[i][j] = Math.min(Math.min(matchCost, insCost), delCost);
            }
        }

        return c[m][n];
    }
}
