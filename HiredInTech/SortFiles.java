package HiredInTech;

import java.util.*;

public class SortFiles {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        sort_the_files(1230, res);
        printList(res);
    }
    public static void sort_the_files(int n, List<String> result) {
        sort_the_files(n, 0, 0, result);
    }

    private static void sort_the_files(int n, int level, int filename, List<String> result) {
        if (result.size() == 1000 || filename > n) return;
        if (level > 0) result.add("IMG"+filename+".jpg");
        for (int i = 0; i < 10; i++) {
            if (i == 0 && level == 0) continue;
            sort_the_files(n, level + 1, filename*10 + i, result);
        }
    }

    private static void printList(List<String> list) {
        for (String word : list) {
            System.out.println(word);
        }
    }
}
