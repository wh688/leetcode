package PalindromePartitioningII;

public class Solution {
	// public boolean isPalindrome(String s) {
	// return (new StringBuilder(s).reverse().toString()).equals(s) ? true :
	// false;
	// }

	public boolean[][] getIsPalindrome(String s) {
		boolean[][] result = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				result[i][j] = true;
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			result[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		}
		for (int length = 2; length < s.length(); length++) {
			for (int start = 0; start + length < s.length(); start++) {
				result[start][start + length] = result[start + 1][start + length - 1]
						&& s.charAt(start) == s.charAt(start + length);
			}
		}
		return result;
	}

	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int cut[] = new int[s.length() + 1];
		boolean[][] isPalindrome = getIsPalindrome(s);
		cut[0] = 0;
		for (int i = 1; i <= s.length(); i++) {
			cut[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				if (isPalindrome[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE) {
					cut[i] = Math.min(cut[i], cut[i - j] + 1);
				}
			}
		}
		return cut[s.length()] - 1;
	}
}
