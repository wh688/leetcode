package Subsets;

import java.util.*;

public class NonRecursiveSolution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		if (S == null || S.length == 0) {
			return result;
		}
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> element = new ArrayList<Integer>(result.get(j));
				element.add(S[i]);
				result.add(element);
			}
		}
		return result;
	}
}
