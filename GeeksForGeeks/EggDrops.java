package GeeksForGeeks;

import java.util.Scanner;

public class EggDrops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[][] cache = new int[51][11];
        initCache(cache);

        while (t-- > 0) {
            int eggs = sc.nextInt();
            int floors = sc.nextInt();
            System.out.println(calculateDrops(cache, eggs, floors));
        }

        sc.close();
    }

    private static void initCache(int[][] cache) {
        for (int i = 0; i < cache[0].length; i++) {
            cache[1][i] = 1;
        }

        for (int i = 0; i < cache.length; i++) {
            cache[i][1] = i;
        }
    }

    private static int calculateDrops(int[][] cache, int eggs, int floors) {
        int drops = searchCache(cache, eggs, floors);
        if (drops > 0) return drops;

        int j = 1;
        while (cache[j - 1][eggs] < floors) {
            for(int i = 2; i <= eggs; i++) {
                if(cache[j][i] == 0) cache[j][i] = cache[j - 1][i] + cache[j - 1][i - 1] + 1;
            }
            j++;
        }

        return j - 1;
    }

    private static int searchCache(int[][] cache, int eggs, int floors) {
        int j = 1;
        while (cache[j][eggs] < floors && cache[j][eggs] > 0) {
            j++;
        }
        if(cache[j][eggs] > 0) return j;

        return -1;
    }
}
