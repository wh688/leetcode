package triangle;
import java.util.*;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
        int[] result = new int[triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
        	result[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
        	for (int j = 0; j <= i; j++) {
        		result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
        	}
        }
        return result[0];
    }
}
