package HiredInTech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountThePaths {
    public static void main (String[] args) {
        List<String> l1 = new ArrayList<String>(Arrays.asList("00", "00"));
        System.out.println(count_the_paths(l1));
        l1 = new ArrayList<String>(Arrays.asList("10", "01"));
        System.out.println(count_the_paths(l1));
        l1 = new ArrayList<String>(Arrays.asList("100", "000", "001"));
        System.out.println(count_the_paths(l1));
        l1 = new ArrayList<String>(Arrays.asList("0000", "1100", "0001", "0100"));
        System.out.println(count_the_paths(l1));
        l1 = new ArrayList<String>(Arrays.asList("00000", "01001", "00001", "00111"));
        System.out.println(count_the_paths(l1));
    }
    public static int count_the_paths(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        // I know from definition first and last always open
        if (rows == 1 && cols == 1) return 1;
        int[][] c = new int[rows][cols];
        // Initialize start point by definition always open
        c[rows - 1][0] = 1;
        // Initialize first column
        for (int i = rows - 2; i >= 0; i--) {
            if (grid.get(i).charAt(0) == '1') continue;
            c[i][0] = c[i + 1][0];
        }
        // Initialize last row
        for (int i = 1; i < cols; i++) {
            if (grid.get(rows - 1).charAt(i) == '1') continue;
            c[rows - 1][i] = c[rows - 1][i - 1];
        }
        // Loop through grid
        for (int i = rows - 2; i >=0; i--) {
            for (int j = 1; j < cols; j++) {
                if (grid.get(i).charAt(j) == '1') continue;
                c[i][j] = (c[i + 1][j] + c[i][j - 1]) % 1000003;
            }
        }

        return c[0][cols - 1];
    }
}
