package GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestCommonSubsequence {
    public static void main(String[] args) {
        ArrayList<String> targetList = new ArrayList<>();
        targetList.add("made");
        targetList.add("in");
        targetList.add("Spain");
        ArrayList<String> availList = new ArrayList<>();
        availList.add("made");
        availList.add("weather");
        availList.add("forecast");
        availList.add("says");
        availList.add("that");
        availList.add("made");
        availList.add("rain");
        availList.add("in");
        availList.add("spain");
        availList.add("stays");
        List<Integer> idxs = subSequenceTags(targetList, availList);
        System.out.println(idxs.get(0) + " " + idxs.get(1));

    }
    static List<Integer> subSequenceTags(List<String> targetList,
                                  List<String> availableTagList)
    {
        ArrayList<Integer> indexes = new ArrayList<>();
        int targetLen = targetList.size();

        // Create a hashMap with all target words and their indexes, initialize indexes to -1
        HashMap<String, Integer> targetMap = new HashMap<>();
        for (String target : targetList) {
            targetMap.put(target.toLowerCase(), -1);
        }

        int minLen = Integer.MAX_VALUE;
        int count = 0, i = 0;
        int localStart = 0, localEnd = 0;
        for (String tag: availableTagList) {
            tag = tag.toLowerCase();
            if (targetMap.containsKey(tag)) {
                // If this is the first occurence of the target tag
                int index = targetMap.get(tag);
                if (index == -1) count++;

                // Store latest index
                targetMap.put(tag, i);

                // If all words matched
                if (count == targetLen) {
                    // Find smallest index
                    int min = Integer.MAX_VALUE;
                    for (Map.Entry<String, Integer> m : targetMap.entrySet()) {
                        int val = m.getValue();
                        if (val < min) min = val;
                    }

                    int curLen = i - min;
                    if (curLen < minLen) {
                        localStart = min;
                        localEnd = i;
                        minLen = curLen;
                    }
                }
            }
            i++;
        }

        indexes.add(localStart);
        indexes.add(localEnd);

        return indexes;
    }
}
