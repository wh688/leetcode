package reverseWordsInAString;

/*
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */

public class Solution {	
    public static String reverseWords(String s) {
        String[] words = s.split("\\s{1,}");
        for (int i = 0; i < words.length / 2; i++) {
        	String tmp = words[i];
        	words[i] = words[words.length - 1 - i];
        	words[words.length - 1 - i] = tmp;
        }
        String result = "";
        for (int i = 0; i < words.length; i++) {
        	result = result + words[i] + " ";
        }
        return result.trim();
    }
}
