package CodeChef;

import java.util.Scanner;

public class Multiple3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            long k = s.nextLong();
            int d0 = s.nextInt();
            int d1 = s.nextInt();
            System.out.println(isMultiple(k, d0, d1) ? "YES" : "NO");
            System.out.println(isMultipleShort(k, d0, d1) ? "YES" : "NO");
        }
    }

    public static boolean isMultiple(long k, int d0, int d1) {
        long sum = d0 + d1;
        for(long i = 2; i < k; i++) {
            long di = sum % 10;
            sum += di;
        }
        System.out.println(sum);

        return sum % 3L == 0L;
    }

    public static boolean isMultipleShort(long k, int d0, int d1) {
        long firstEven = d0 + d1;
        long sum = firstEven;
        firstEven %= 10;
        k -=2;

        while (firstEven % 2 != 0) {
            sum += firstEven;
            k--;
            firstEven = sum % 10;
        }

        if(firstEven == 0) return false;

        sum += Math.floor(k/4L) * 20;
        firstEven = firstEven / 2;
        for(int j = 0; j < k % 4; j++) {
            firstEven = (firstEven * 2) % 10;
            sum += firstEven;
        }

        return sum % 3L == 0L;
    }
}
