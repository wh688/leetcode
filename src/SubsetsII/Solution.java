package SubsetsII;

import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		if (num == null || num.length == 0) {
			return result;
		}
		Arrays.sort(num);  
		int start = 0;
		for (int i = 0; i < num.length; i++) {
			int size = result.size();
			for (int j = start; j < size; j++) {
				ArrayList<Integer> element = new ArrayList<Integer>(result.get(j));
				element.add(num[i]);
				result.add(element);
			}
			if (i < num.length - 1 && num[i] == num[i + 1]) {
				start = size;
			} else {
				start = 0;
			}
		}
		return result;
	}
}
