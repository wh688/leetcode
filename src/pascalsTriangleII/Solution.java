package pascalsTriangleII;

import java.util.*;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 */

public class Solution {
    public List<Integer> getRow(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		List<Integer> row = new ArrayList<Integer> ();
		row.add(1);
		result.add(row);
		for (int i = 1; i <= numRows; i++) {
			row = new ArrayList<Integer> ();
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
		return result.get(numRows);
    }
}
