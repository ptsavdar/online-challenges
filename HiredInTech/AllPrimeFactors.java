package HiredInTech;

import java.util.ArrayList;
import java.util.List;

public class AllPrimeFactors {
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
