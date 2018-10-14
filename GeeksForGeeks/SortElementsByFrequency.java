package GeeksForGeeks;

import java.util.*;

public class SortElementsByFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[60];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int ai = sc.nextInt();
                a[ai - 1]++;
                if (min > ai) min = ai;
                if (max < ai) max = ai;
            }
            a = sortByFreq(a, n, min, max);
            printArray(a);
        }

        sc.close();
    }

    private static int[] sortByFreq(int[] a, int n, int min, int max) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = min; i<=max; i++) {
            if(a[i - 1] > 0) {
                pq.add(new Pair(i, a[i - 1]));
            }
        }

        int[] res = new int[n];
        int idx = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int i = 0; i < pair.freq; i++) {
                res[idx] = pair.n;
                idx++;
            }
        }

        return res;
    }

    private static void printArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int ai : a) {
            sb.append(ai);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static class Pair implements Comparable<Pair> {
        int n;
        int freq;

        private Pair(int n, int freq) {
            this.n = n;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.freq > pair.freq) return -1;
            if (this.freq < pair.freq) return 1;

            return this.n - pair.n;
        }
    }
}
