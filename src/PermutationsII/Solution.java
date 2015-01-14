package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		Arrays.sort(num);
		helper(num, new boolean[num.length], new ArrayList<Integer>(), result);
		return result;
	}

	public void helper(int[] num, boolean[] used, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> result) {
		if (item.size() == num.length) {
			result.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && !used[i - 1] && num[i - 1] == num[i]) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				item.add(num[i]);
				helper(num, used, item, result);
				item.remove(item.size() - 1);
				used[i] = false;
			}
		}
	}
}