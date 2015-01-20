package WordBreakII;

import java.util.*;

public class Solution {
	public ArrayList<String> wordBreak(String s, HashSet<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return result;
		}
		helper(s, dict, 0, "", result);
		return result;
	}

	public void helper(String s, HashSet<String> dict, int start, String item,
			ArrayList<String> result) {
		if (start >= s.length()) {
			result.add(item);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(start));
			if (dict.contains(sb.toString())) {
				String newItem = item.length() > 0 ? (item + " " + sb.toString()) : sb
						.toString();
				helper(s, dict, i + 1, newItem, result);
			}
		}
	}
}
