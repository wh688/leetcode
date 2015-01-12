package Subsets;

import java.util.*;

public class RecursiveSolution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null) {
			return null;
		}
		Arrays.sort(S);
		return helper(S, S.length - 1);
	}

	public ArrayList<ArrayList<Integer>> helper(int[] S, int index) {
		if (index == -1) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> element = new ArrayList<Integer>();
			result.add(element);
			return result;
		}
		ArrayList<ArrayList<Integer>> result = helper(S, index - 1);
		int size = result.size();
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> element = new ArrayList<Integer>(result.get(i));
			element.add(S[index]);
			result.add(element);
		}
		return result;
	}
}