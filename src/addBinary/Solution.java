package addBinary;

/*
 * Given two binary strings, return their sum (also a binary string).
 For example,
 a = "11"
 b = "1"
 Return "100".
 */

public class Solution {
	public String addBinary(String a, String b) {
		int m = a.length();
		int n = b.length();
		int p = 0;
		int q = 0;
		int c = 0;
		String result = "";
		int maxLength = Math.max(m, n);
		for (int i = 0; i < maxLength; i++) {
			if (i >= m) {
				p = 0;
			} else {
				p = a.charAt(m - 1 - i) - '0';
			}
			if (i >= n) {
				q = 0;
			} else {
				q = b.charAt(n - 1 - i) - '0';
			}
			int tmp = q + p + c;
			c = tmp / 2;
			result = (tmp % 2) + result;
		}
		if (c == 1) {
			result = "1" + result;
		}
		return result;
	}
}