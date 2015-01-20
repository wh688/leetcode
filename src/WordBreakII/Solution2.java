package WordBreakII;

import java.util.*;

public class Solution2 {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		return helper(s, dict, map);
	}

	public ArrayList<String> helper(String s, Set<String> dict,
			Map<String, ArrayList<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		ArrayList<String> result = new ArrayList<String>();
		int n = s.length();
		if (n <= 0) {
			return result;
		}
		for (int i = 1; i <= n; i++) {
			String subfix = s.substring(0, i);
			if (dict.contains(subfix)) {
				if (i == n) {
					result.add(subfix);
				} else {
					String prefix = s.substring(i);
					ArrayList<String> temp = helper(prefix, dict, map);
					for (String item : temp) {
						item = subfix + " " + item;
						result.add(item);
					}
				}
			}
		}
		map.put(s, result);
		return result;
	}
}