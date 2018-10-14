package HiredInTech;

import java.util.Scanner;

public class CountStringOccurences {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String txt = sc.nextLine();
        String pattern = sc.nextLine();
        sc.close();
        System.out.println(countOccurences(txt, pattern));
    }

    private static int countOccurences(String txt, String pattern) {
        int[] f = buildFailureFunction(pattern);

        int i = 0, j = 0, counts = 0;
        while (true) {
            if(j == txt.length()) break;
            if(txt.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;
                if (i == pattern.length()) {
                    i = f[i];
                    counts++;
                }
            } else if (i > 0) {
                i = f[i];
            } else j++;
        }

        return counts;
    }

    private static int[] buildFailureFunction(String pattern) {
        int[] f = new int[pattern.length() + 1];

        for (int i = 2; i <= pattern.length(); i++) {
            int j = f[i - 1];
            while (true) {
                if(pattern.charAt(j) == pattern.charAt(i - 1)) {
                    f[i] = j + 1;
                    break;
                }
                if(j == 0) {
                    f[i] = 0;
                    break;
                }
                j = f[j];
            }
        }

        return f;
    }
}
