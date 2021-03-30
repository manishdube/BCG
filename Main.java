import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.*;

/*
Coding Exercise - Problem Description
Given a set of words, find the count of number of strings which are similar but may have had
the letters jumbled
Example:
Consider the following set of words as input:
eat, ate, tea, java, avja, apple
The expected output would be:
eat, ate, tea – 3 (ate, tea are jumbled version of eat)
java, avja – 2
apple - 1

*/

public class Main {

    public static void main(String args[]) throws Exception {

        String S = "eat, ate, tea, java, avja, apple";
        String inputWordsArray[] = S.split(", ");

        List<ArrayList<String>> groupAnagrams = groupAnagrams(inputWordsArray);

        for (int i = 0, groupAnagramsSize = groupAnagrams.size(); i < groupAnagramsSize; i++) {
            ArrayList<String> similarStrings = groupAnagrams.get(i);

            System.out.printf("Group %d : %s is of size --> %d%n", i + 1, similarStrings, similarStrings.size());
        }
    }

    public static List<ArrayList<String>> groupAnagrams(String[] words) {

        List<ArrayList<String>> wordGroups = new ArrayList<ArrayList<String>>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
            String word = words[i];

            int sum = 0;
            char[] charArray = word.toCharArray();
            for (int i1 = 0, charArrayLength = charArray.length; i1 < charArrayLength; i1++) {
                char c = charArray[i1];
                sum += c;
            }
            if (map.containsKey(sum))
                map.get(sum).add(word);
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(word);
                map.put(sum, list);
            }
        }

        wordGroups.addAll(map.values());
        System.out.println("Total number of Groups = "+ wordGroups.size());
        //return wordGroups.sort(Comparator.comparing(ArrayList::sort).reversed());

        return wordGroups;
    }
}
