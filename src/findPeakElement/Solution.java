package findPeakElement;

public class Solution {
	public int findPeakElement(int[] num) {
        int max = Integer.MIN_VALUE;
        if (num == null || num.length == 0) {
        	return -1;
        }
        int index = 0;
        for (int i = 0; i < num.length; i++) {
        	if (num[i] > max) {
        		max = num[i];
        		index = i;
        	}
        }
        return index;
    }
}
