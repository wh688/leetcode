package longestCommonPrefix;

/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int len = minLength(strs);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char x = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != x) {
					return sb.toString();
				}
			}
			sb.append(strs[0].charAt(i));
		}
		return sb.toString();
    }
	public int minLength (String[] strs) {
		if (strs == null || strs.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			min = Math.min(min, strs[i].length());
		}
		return min;
	}
}
