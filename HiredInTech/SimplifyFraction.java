package HiredInTech;

import java.util.Arrays;

public class SimplifyFraction {

    public static void simplify_fraction(int numerator, int denominator, int[] result) {
        int gcd = gcd(numerator, denominator);
        result[0] = numerator/gcd;
        result[1] = denominator/gcd;
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (b == a) return b;

        if (b > a) return gcd(a, b%a);

        return gcd(b, a%b);
    }
}
