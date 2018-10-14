package GeeksForGeeks;

import java.util.Scanner;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int prevMaxSum = - 200, curMaxSum = -200;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                // If current sum less than zero, then take max
                if (curMaxSum < 0) {
                    if (prevMaxSum < curMaxSum) prevMaxSum = curMaxSum;
                    if (curMaxSum < a) curMaxSum = a;
                    continue;
                }

                if (a < 0 && prevMaxSum < curMaxSum) {
                    prevMaxSum = curMaxSum;
                }

                curMaxSum += a;
            }

            System.out.println(Math.max(prevMaxSum, curMaxSum));
        }

        sc.close();
    }
}
