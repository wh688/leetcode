package WordBreak;

import java.util.*;

public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder(s.substring(0, i + 1));
			for (int j = 0; j <= i; j++) {
				if (result[j] && dict.contains(sb.toString())) {
					result[i + 1] = true;
					break;
				}
				sb.deleteCharAt(0);
			}
		}
		return result[s.length()];
	}
}
