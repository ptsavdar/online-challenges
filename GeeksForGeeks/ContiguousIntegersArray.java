package GeeksForGeeks;

import java.util.Scanner;

public class ContiguousIntegersArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] < min) min = a[i];
                if (a[i] > max) max = a[i];
            }
            if ((max - min + 1) > n) {
                System.out.println("No");
                continue;
            }

            System.out.println(isContiguous(a, n, min, max) ? "Yes" : "No");
        }

        sc.close();
    }

    private static boolean isContiguous(int[] a, int n, int min, int max) {
        boolean[] bits = new boolean[max - min + 1];
        int cardinality = 0;
        for(int i = 0; i < n; i++) {
            if(!bits[a[i] - min]) {
                bits[a[i] - min] = true;
                cardinality++;
            }
        }

        return cardinality == (max - min + 1);
    }
}
