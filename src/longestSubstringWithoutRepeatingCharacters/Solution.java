package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<Character> ();
        int walker = 0;
        int runner = 0;
        int result = 0;
       	while(runner < s.length()){
        	if (hs.contains(s.charAt(runner))) {
        		result = result > runner - walker ? result : runner - walker;
        		while (s.charAt(walker) != s.charAt(runner)) {
        			hs.remove(s.charAt(walker));
        			walker++;
        		}
        		walker++;
        	} else {
        		hs.add(s.charAt(runner));        		
        	}
        	runner++;
        }
       	result = result > runner - walker ? result : runner - walker;
       	return result;
    }
}
