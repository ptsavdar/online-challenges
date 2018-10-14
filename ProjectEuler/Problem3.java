public class Problem3 {
    public static double maxPrimeFactor(double n) {
        // Every composite number has at least one prime factor less than or equal to square root of itself
        double sqn = (double)Math.floor((Math.sqrt(n)));
        double maxPrimeFactor = 1;

        // Eliminate all even numbers because 2 is the smallest even prime number
        while (n % 2 == 0) {
            n = n / 2;
            maxPrimeFactor = 2;
        }

        // For every other odd number test if is a factor and prime
        for (int i = 3; i <= sqn; i = i + 2) {
            while (n%i == 0) {
                maxPrimeFactor = i;
                n = n / i;
            }
        }

        if (n > 2) {
            maxPrimeFactor = n;
        }


        return maxPrimeFactor;
    }
}
