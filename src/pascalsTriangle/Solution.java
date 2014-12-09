package pascalsTriangle;

import java.util.*;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 */

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		
		if (numRows == 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer> ();
			row.add(1);
			for (int j = 1; j < i; j++) {
				List<Integer> prerow = result.get(i - 1);
				int tmp = prerow.get(j - 1) + prerow.get(j);
				row.add(tmp);
			}
			if (i != 0) {
				row.add(1);
			}
			result.add(row);
		}
		return result;
    }
}
