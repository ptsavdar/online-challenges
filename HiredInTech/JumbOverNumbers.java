package HiredInTech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumbOverNumbers {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1));
        System.out.println(jump_over_numbers(l1));
        l1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 3, 2, 1));
        System.out.println(jump_over_numbers(l1));
        l1 = new ArrayList<Integer>(Arrays.asList(1, 2));
        System.out.println(jump_over_numbers(l1));
    }

    public static int jump_over_numbers(List<Integer> list) {
        int len = list.size();
        int i = 0, jumps = 0;
        while (i < len) {
            if (list.get(i) == 0) return -1;
            jumps++;
            i += list.get(i);
        }

        return jumps;
    }
}
