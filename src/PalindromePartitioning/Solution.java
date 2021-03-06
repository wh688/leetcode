package PalindromePartitioning;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) {
			return result;
		}
		ArrayList<String> path = new ArrayList<String>();
		helper(s, 0, path, result);
		return result;
	}

	public static void main(String[] args) {
	}

	public static boolean isPalindrome(String s) {
		return (new StringBuilder(s).reverse().toString()).equals(s) ? true : false;
	}

	public void helper(String s, int index, ArrayList<String> path,
			ArrayList<ArrayList<String>> result) {
		if (index == s.length()) {
			result.add(new ArrayList<String>(path));
			return;
		}
		for (int i = index + 1; i <= s.length(); i++) {
			String prefix = s.substring(index, i);
			if (!isPalindrome(prefix)) {
				continue;
			}
			path.add(prefix);
			helper(s, i, path, result);
			path.remove(path.size() - 1);
		}
	}
}