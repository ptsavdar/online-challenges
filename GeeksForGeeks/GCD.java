package GeeksForGeeks;

import java.util.Arrays;

public class GCD {
    public int generalizedGCD(int num, int[] arr)
    {
        return computeGcd(arr);
    }

    private int computeGcd(int[] arr) {
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return gcd(arr[0], arr[1]);

        int n = Math.floorDiv(arr.length, 2);
        int left = computeGcd(Arrays.copyOfRange(arr, 0, n));
        int rigth = computeGcd(Arrays.copyOfRange(arr, n, arr.length));

        return gcd(left, rigth);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (b == a) return b;

        if (b > a) return gcd(a, b%a);

        return gcd(b, a%b);
    }
}
