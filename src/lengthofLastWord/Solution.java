package lengthofLastWord;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 */
public class Solution {
	public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        String[] list = s.split("\\s+");
        if (list == null || list.length == 0) {
        	return 0;
        }
        return list[list.length - 1].length();
    }
}
