package GeeksForGeeks;

import java.util.Arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2};
        System.out.println(minSwaps(a, a.length));
    }

    private static int minSwaps(int[] arr, int n) {
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }
        Arrays.sort(pairs);

        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || pairs[i].idx == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                cycleSize +=1;
                j = pairs[j].idx;
            }

            res += cycleSize - 1;
        }

        return res;
    }

    private static class Pair implements Comparable<Pair> {
        int num, idx;

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.num - pair.num;
        }
    }
}
