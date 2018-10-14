package GeeksForGeeks;

import java.util.Arrays;
import java.util.Scanner;

public class FindingNumberBitonicArray {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            sc.nextLine();
            int[] A = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int i = findX(A, n, x);

            if (i == -1) System.out.println("OOPS! NOT FOUND");
            else System.out.println(i);
        }
    }

    private static int findX(int[] A, int n, int x) {
        int max = findMax(A, n);
        if (x > A[max]) return -1;
        if (max > 0 && x < A[0] && x < A[n - 1]) return -1;
        int i = -1;
        if (max > 0 && x >= A[0]) i = binarySearch(A, 0, max, x, true);
        if (i == -1 && x >= A[n - 1]) i = binarySearch(A, max, n - 1, x, false);

        return i;
    }

    private static int binarySearch(int[] A, int lo, int hi, int x, boolean asc) {
        if (lo > hi || (lo == hi && A[lo] != x)) return -1;
        if (lo == hi && A[lo] == x) return lo;

        int mid = Math.floorDiv(lo + hi, 2);
        if (A[mid] == x) return mid;
        if ((x > A[mid] && asc) || (x < A[mid] && !asc)) return binarySearch(A, mid + 1, hi, x, asc);
        if ((x < A[mid] && asc) || (x > A[mid] && !asc)) return binarySearch(A, lo, mid - 1, x, asc);

        return -1;
    }

    private static int findMax(int[] A, int n) {
        if(A[n - 1] > A[n -2] && A[n - 1] > A[1]) return n-1;
        if(A[0] > A[1] && A[0] > A[n - 1]) return 0;

        return findMaxBinary(A, 0, n -1);
    }

    private static int findMaxBinary(int[] A, int lo, int hi) {
        int mid = Math.floorDiv(lo + hi, 2);

        if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) return mid;
        if (A[mid] > A[mid + 1]) return findMaxBinary(A, lo, mid);
        if (A[mid] > A[mid - 1]) return findMaxBinary(A, mid, hi);

        return -1;
    }
}
