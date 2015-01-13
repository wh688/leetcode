package Permutations;

import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(num[0]);
		result.add(first);
		for (int i = 1; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> newResult = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < result.size(); j++) {
				ArrayList<Integer> item = result.get(j);
				for (int k = 0; k < item.size() + 1; k++) {
					ArrayList<Integer> newItem = new ArrayList<Integer>(item);
					newItem.add(k, num[i]);
					newResult.add(newItem);
				}
			}
			result = newResult;
		}
		return result;
	}
}
