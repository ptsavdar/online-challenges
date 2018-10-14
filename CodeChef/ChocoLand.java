package CodeChef;

import java.util.Scanner;

public class ChocoLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int s = scanner.nextInt();
            System.out.println(calculateDays(n, k, s));
        }
    }

    private static int calculateDays(int n, int k, int s) {
        if (k > n) return -1;

        int chocosNeeded = k * s;
        int minBuyingDays = (int) Math.ceil((float)chocosNeeded / n);
        int maxActualBuyingDays = s - Math.floorDiv(s, 7);
        if (maxActualBuyingDays < minBuyingDays) return -1;

        return minBuyingDays;
    }
}
