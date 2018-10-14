package InterviewBit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrderMatrixI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            List<ArrayList<Integer>> mtrx = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                mtrx.add(new ArrayList<>());
                for (int j = 0; j < 4; j++) {
                    mtrx.get(i).add(sc.nextInt());
                }
            }
            printMatrix(spiralOrder(mtrx));
        }
        /*List<ArrayList<Integer>> mtrx = new ArrayList<>();
        Integer[][] arr = {{1, 2, 3, 4}};
        for (Integer[] row : arr) {
            mtrx.add(new ArrayList<>(Arrays.asList(row)));
        }
        ArrayList<Integer> spiral = spiralOrder(mtrx);
        printMatrix(spiral);*/

        sc.close();
    }

    private static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> spiral = new ArrayList<>();
        if (A.size() == 0) return spiral;

        int n = A.size(), m = A.get(0).size(); // finding dimensions n x m
        int col = 0, row = 0, layer = 0, dir = 0; // Current column, row, layer and direction

        for (int i = 0; i < n * m; i++) {
            spiral.add(A.get(row).get(col));

            switch (dir) {
                case 0:
                    if(col == m - layer - 1) {
                        row++;
                        dir = 1;
                    } else {
                        col++;
                    }
                    break;
                case 1:
                    if(row == n - layer - 1) {
                        col--;
                        dir = 2;
                    } else {
                        row++;
                    }
                    break;
                case 2:
                    if(col == layer) {
                        row--;
                        dir = 3;
                    } else {
                        col--;
                    }
                    break;
                case 3:
                    if(row == layer + 1) {
                        col++;
                        layer++;
                        dir = 0;
                    } else {
                        row--;
                    }
            }
        }

        return spiral;
    }

    private static ArrayList<Integer> spiralOrderMine(final List<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size(); // finding dimensions n x m
        ArrayList<Integer> spiral = new ArrayList<>();
        // Get first row elements
        spiral.addAll(A.get(0));
        // Get last column elements
        if (n > 2) {
            for (int i = 1; i < n - 1; i++) {
                spiral.add(A.get(i).get(m - 1));
            }
        }

        if (n > 1) {
            // Add last row in reverse order
            for (int i = m - 1; i >=0; i--) {
                spiral.add(A.get(n - 1).get(i));
            }
        }

        // Get first column elements in reverse order
        // Get last column elements
        if (n > 2 && m > 1) {
            for (int i = n - 2; i >= 1; i--) {
                spiral.add(A.get(i).get(0));
            }
        }

        if (n > 2 && m > 2) {
            spiral.addAll(spiralOrder(reduceArray(A)));
        }

        return spiral;
    }

    private static List<ArrayList<Integer>> reduceArray(final List<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size(); // finding dimensions n x m
        List<ArrayList<Integer>> reduced = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            reduced.add(new ArrayList<>(A.get(i).subList(1, m - 1)));
        }

        return reduced;
    }

    private static void printMatrix(ArrayList<Integer> A) {
        StringBuilder sb = new StringBuilder();
        for (Integer i: A) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
