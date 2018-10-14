package HiredInTech;

import java.util.Hashtable;
import java.util.Scanner;

public class RelatedWords {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String txt = sc.nextLine();
        String word = sc.nextLine();
        int dist = sc.nextInt();
        sc.close();
        String related = relatedWord(txt, word, dist);
        System.out.println(related != null ? related : "N/A");
    }

    private static String relatedWord(String txt, String word, int dist) {
        int lastIdx = 0, maxFreq = 0;
        String maxFreqWord = null;
        Hashtable<String, Integer> wordFreq = new Hashtable<>();
        word = word.toLowerCase();
        txt = txt.toLowerCase().replaceAll("[^(0-9 a-z)]+", "");
        String[] words = txt.split(" ");
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word)) {
                for(int j = 1; j <= dist; j++) {
                    for(int k = 0; k < 2; k++) {
                        String related = "";
                        if (k == 0 && i - j > lastIdx) {
                            related = words[i - j];
                        } else if (k == 1 && i + j < words.length && i + j > lastIdx){
                            related = words[i + j];
                        } else continue;
                        if (!related.equals(word)) {
                            int freq = wordFreq.get(related) != null ? wordFreq.get(related) + 1 : 1;
                            wordFreq.put(related, freq);
                            if (freq > maxFreq || (freq == maxFreq && maxFreqWord != null && related.compareTo(maxFreqWord) < 0)) {
                                maxFreq = freq;
                                maxFreqWord = related;
                            }
                        }
                    }
                }
                lastIdx = i + dist;
            }
        }

        return maxFreqWord;
    }
}
