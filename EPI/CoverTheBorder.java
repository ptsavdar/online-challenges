package EPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoverTheBorder {
    public static void main(String[] args) {
        List<List<Integer>> radars = new ArrayList<>();
        radars.add(new ArrayList<>(Arrays.asList(5, 10)));
        radars.add(new ArrayList<>(Arrays.asList(3, 25)));
        radars.add(new ArrayList<>(Arrays.asList(46, 99)));
        radars.add(new ArrayList<>(Arrays.asList(39, 40)));
        radars.add(new ArrayList<>(Arrays.asList(45, 50)));
        System.out.println(cover_the_border(100, radars));
        printRanges(radars);
    }
    public static int cover_the_border(int l, List<List<Integer>> radars) {
        // Example arguments:
        // l = 100
        // radars = [ [5, 10], [3, 25], [46, 99], [39, 40], [45, 50] ]
        // The `radars` list will çonsist of lists with two elements
        Collections.sort(radars, (List<Integer> r1, List<Integer> r2) -> {
            int cmp = r1.get(0).compareTo(r2.get(0));
            if (cmp == 0) cmp = r1.get(1).compareTo(r2.get(1));
            return cmp;
        });

        int cover = 0;
        int curMin = radars.get(0).get(0);
        int curMax = radars.get(0).get(1);

        if (curMax - curMin >= l) return l;

        for (int i = 1; i < radars.size(); i++) {
            List<Integer> radar = radars.get(i);
            if (curMax > radar.get(1)) continue;
            if (curMax < radar.get(0)) {
                cover += curMax - curMin;
                curMin = radar.get(0);
                curMax = radar.get(1);
            } else {
                curMax = radar.get(1);
            }
        }
        cover += curMax - curMin;

        return cover;
    }

    private static void printRanges(List<List<Integer>> radars) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (List<Integer> range : radars) {
            sb.append("[");
            sb.append(range.get(0));
            sb.append(", ");
            sb.append(range.get(1));
            sb.append("] ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
