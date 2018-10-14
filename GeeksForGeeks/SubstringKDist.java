package GeeksForGeeks;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringKDist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int k = sc.nextInt();
        List<String> substrings = subStringsKDist(input, k);
        for(String str : substrings) {
            System.out.println(str);
        }
    }
    public static List<String> subStringsKDist(String inputStr, int num)
    {
        Set<String> substrings = new HashSet<>();

        int len = inputStr.length();
        //Keep track of chars in current substring
        int[] chars = new int[26];

        for (int i = 0; i <= len - num; i++) {
            int dist = 0;
            //Initialize char counters
            Arrays.fill(chars, 0);
            for (int j = 0; j < num; j++) {
                int curChar = inputStr.charAt(i + j) - 'a';
                if (chars[curChar] == 0) dist++;
                chars[curChar]++;
            }
            if (dist == num) {
                substrings.add(inputStr.substring(i, i + num));
            }
        }

        return substrings.stream().collect(Collectors.toList());
    }
}
