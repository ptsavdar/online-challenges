package EPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(16, 3, 5, 19, 10, 14, 12, 0, 15));
        printList(longest_increasing_subsequence_fast(l1));
        l1 = new ArrayList<>(Arrays.asList(15));
        printList(longest_increasing_subsequence_fast(l1));
        l1 = new ArrayList<>(Arrays.asList(10, 8, 6, 4, 2, 0));
        printList(longest_increasing_subsequence_fast(l1));
    }
    public static List<Integer> longest_increasing_subsequence(List<Integer> sequence) {
        int n = sequence.size();
        int[] len = new int[n], prev = new int[n];
        int max = 1, iMax = 0;

        // Find longest subsequence
        for (int i = 0; i < n; i++) {
            prev[i] = i;
            len[i] = 1;
            int j = i - 1;
            while (j >= 0) {
                if (sequence.get(i) > sequence.get(j) && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
                j--;
            }
            if (max < len[i]) {
                max = len[i];
                iMax = i;
            }
        }

        // Reconstruct longest subsequence
        Stack<Integer> order = new Stack<>();
        while (max-- > 0) {
            order.push(sequence.get(iMax));
            iMax = prev[iMax];
        }

        ArrayList<Integer> ordered = new ArrayList<>();
        while (!order.isEmpty()) {
            ordered.add(order.pop());
        }

        return ordered;
    }

    public static List<Integer> longest_increasing_subsequence_fast(List<Integer> sequence) {
        int n = sequence.size();
        int[] m = new int[n + 1], prev = new int[n];
        int L = 0;
        // Find longest subsequence
        for (int i = 0; i < n; i++) {
            // Binary search for the largest positive j <= L
            // such that X[M[j]] < X[i]
            int lo = 1;
            int hi = L;
            while (lo <= hi) {
                int mid = (int)Math.ceil((lo + hi)/2);
                if(sequence.get(m[mid]) < sequence.get(i)) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            int newL = lo;
            prev[i] = m[newL - 1];
            m[newL] = i;

            if (newL > L) {
                L = newL;
            }
        }

        // Reconstruct longest subsequence
        Stack<Integer> order = new Stack<>();
        int iMax = m[L];
        while (L-- > 0) {
            order.push(sequence.get(iMax));
            iMax = prev[iMax];
        }

        ArrayList<Integer> ordered = new ArrayList<>();
        while (!order.isEmpty()) {
            ordered.add(order.pop());
        }

        return ordered;
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer item : list) {
            sb.append(item);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
