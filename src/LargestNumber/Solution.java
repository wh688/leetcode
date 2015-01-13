package LargestNumber;

import java.util.*;
import java.util.Comparator;

class StringComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		if (a.length() == b.length()) {
			if (Integer.parseInt(a) > Integer.parseInt(b)) {
				return -1;
			} else if (Integer.parseInt(a) == Integer.parseInt(b)) {
				return 0;
			} else {
				return 1;
			}
		} else {
			String ab = a + b;
			String ba = b + a;
			return ba.compareTo(ab);
		}
	}
}

public class Solution {
	public String largestNumber(int[] num) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> numStr = new ArrayList<String>(num.length);
		for (int i : num) {
			numStr.add(String.valueOf(i));
		}
		Collections.sort(numStr, new StringComparator());
		for (String s : numStr) {
			sb = sb.append(s);
		}
		String result = sb.toString();
		if (result.length() > 0 && result.charAt(0) == '0') {
			return "0";
		}
		return result;
	}
}
