package PermutationSequence;

import java.util.*;

public class Solution {
	public String getPermutation(int n, int k) {
		if (n <= 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			nums.add(i);
		}
		int factorial = 1;
		for (int i = 2; i < n; i++) {
			factorial *= i;
		}
		int round = n - 1;
		k--;
		while (round >= 0) {
			int index = k / factorial;
			k %= factorial;
			sb.append(nums.get(index));
			nums.remove(index);
			if (round > 0) {
				factorial /= round;
			}
			round--;
		}
		String result = sb.toString();
		return result;
	}
}
