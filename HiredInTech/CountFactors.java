package HiredInTech;

import java.util.ArrayList;
import java.util.List;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(count_numbers_factors(7));
        System.out.println(count_numbers_factors(12));
        System.out.println(count_numbers_factors(70));
        System.out.println(count_numbers_factors(35));
    }
    public static int count_numbers_factors(long number) {
        int cnt = 1;

        ArrayList<Long> factors = (ArrayList<Long>) all_prime_factors(number);
        long prevFactor = 0;
        int prevFactorCount = 0;
        for (Long factor: factors) {
            if (prevFactor == 0) {
                prevFactor = factor;
                prevFactorCount++;
                continue;
            }
            if (prevFactor != factor) {
                cnt *= (prevFactorCount + 1);
                prevFactor = factor;
                prevFactorCount = 1;
            } else {
                prevFactorCount++;
            }
        }
        cnt *= (prevFactorCount + 1);

        return cnt;
    }

    public static List<Long> all_prime_factors(long number) {
        List<Long> factors = new ArrayList<>();
        while (number % 2L == 0L) {
            factors.add(2L);
            number /= 2L;
        }
        for (long i = 3; i <= Math.sqrt(number); i+=2) {
            while (number % i == 0L) {
                factors.add(i);
                number /= i;
            }
        }

        if (number > 2) {
            factors.add(number);
        }

        return factors;
    }
}
