package HiredInTech;

public class PrimeCounting {
    public static int prime_counting(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <=n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (primes[i]) cnt++;
        }

        return cnt;
    }
}
