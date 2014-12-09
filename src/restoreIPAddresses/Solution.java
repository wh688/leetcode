package restoreIPAddresses;

/* Given a string containing only digits, restore it by returning all possible valid IP address combinations. */

import java.util.*;

public class Solution {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String> ();
		ArrayList<String> list = new ArrayList<String> ();
		if (s.length() < 4 || s.length() > 12 || s == null) {
			return result;
		}
		help(result, list, s, 0);
		return result;
    }
	void help (ArrayList<String> result, ArrayList<String> list, String s, int start) {
		if (list.size() == 4) {
			if (start != s.length()) {
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (String tmp : list) {
				sb.append(tmp);
				sb.append('.');
			}
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString());
		}
		for (int i = start; i < s.length() && i <= start + 3; i++) {
			String tmp = s.substring(start, i + 1);
			if(isValid(tmp)) {
				list.add(tmp);
				help(result, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	boolean isValid (String str) {
		if(str.charAt(0) == '0') {
			return str.equals("0");
		}
		return Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255;
	}
}
