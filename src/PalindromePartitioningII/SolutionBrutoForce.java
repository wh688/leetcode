package PalindromePartitioningII;

import java.util.ArrayList;

public class SolutionBrutoForce {
	public static int minCut(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) {
			return 0;
		}
		ArrayList<String> path = new ArrayList<String>();
		helper(s, 0, path, result);
		int min = Integer.MAX_VALUE;
		for (ArrayList<String> element : result) {
			if (element.size() < min) {
				min = element.size();
			}
		}
		return min - 1;
	}

	public static void main(String[] args) {
		//System.out.println(minCut("aabac"));
	}

	public static boolean isPalindrome(String s) {
		return (new StringBuilder(s).reverse().toString()).equals(s) ? true : false;
	}

	public static void helper(String s, int index, ArrayList<String> path,
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