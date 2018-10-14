package GeeksForGeeks;

import java.util.Scanner;

public class MissingNumberInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean[] bits = new boolean[n];
            for (int i = 0; i < n - 1; i++) {
                bits[sc.nextInt() - 1] = true;
            }
            System.out.println(findMissing(bits, n));
        }

        sc.close();
    }

    private static int findMissing(boolean[] bits, int n) {
        for(int i = 0; i < n; i++) {
            if(!bits[i]){
                return i + 1;
            }
        }

        return -1;
    }
}
