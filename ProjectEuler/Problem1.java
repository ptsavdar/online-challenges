public class Problem1 {
    public static int solve(int size) {
        int sum = 0;
        for(int i = 1; i <= size; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static int solveA(int size) {
        int sum = sumDivisibleBy(size,3) + sumDivisibleBy(size,5) - sumDivisibleBy(size,15);

        return sum;
    }

    public static int sumDivisibleBy(int size, int divisor) {
        int p = Math.floorDiv(size, divisor);


        return Math.floorDiv(divisor * p * (p + 1), 2);
    }
}
