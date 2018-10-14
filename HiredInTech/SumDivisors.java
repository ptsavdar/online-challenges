package HiredInTech;

public class SumDivisors {
    public static long sum_the_divisors(int number) {
        long cnt = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0)  {
                cnt += i;
                if (number/i != i) cnt += number/i;
            }
        }

        return cnt;
    }
}
