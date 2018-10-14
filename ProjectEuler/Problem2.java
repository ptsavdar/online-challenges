public class Problem2 {
    public static int solve(int max) {
        int sum = 0;
        int fib = 1;
        int prev = 1;
        while (fib < max) {
            if (fib % 2 == 0) {
                sum += fib;
            }
            int tmp = fib;
            fib += prev;
            prev = tmp;
        }

        return sum;
    }

    public static int solveA(int max) {
        int sum = 0;
        int fib1 = 1, fib2 = 1, fib3 = fib1 + fib2;
        while (fib3 < max) {
            sum += fib3;
            fib1 = fib2 + fib3;
            fib2 = fib1 + fib3;
            fib3 = fib1 + fib2;
        }

        return sum;
    }
}
