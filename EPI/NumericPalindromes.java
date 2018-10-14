package EPI;

import java.util.ArrayList;
import java.util.List;

public class NumericPalindromes {
    public static void main (String[] args) {
        System.out.println(is_numeric_palindrome(0l));
        System.out.println(is_numeric_palindrome(1l));
        System.out.println(is_numeric_palindrome(11l));
        System.out.println(is_numeric_palindrome(12l));
        System.out.println(is_numeric_palindrome(121l));
        System.out.println(is_numeric_palindrome(10001l));
        System.out.println(is_numeric_palindrome(1001l));
        System.out.println(is_numeric_palindrome(1000001l));
        System.out.println(is_numeric_palindrome(1002301l));
    }
    public static boolean is_numeric_palindrome(long number) {
        List<Integer> digits = to_digits_array(number);
        int len = digits.size();
        for (int i = 0; i <= len/2; i++) {
            if(digits.get(i) != digits.get(len - 1 - i)) return false;
        }

        return true;
    }

    private static List<Integer> to_digits_array(long number) {
        List<Integer> digits = new ArrayList<>();

        if (number == 0) digits.add(0);
        while (number > 0) {
            digits.add((int)(number % 10));
            number /= 10;
        }

        return digits;
    }
}
