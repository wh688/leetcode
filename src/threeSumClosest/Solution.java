package threeSumClosest;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 */

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
        	return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int minDiff = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < num.length - 2; i++) {
        	int start = i + 1;
        	int end = num.length - 1;
        	while (start < end) {
        		int sum = num[i] + num[start] + num[end];
        		if (Math.abs(sum - target) < minDiff) {
        			minDiff = Math.abs(sum - target);
        			val = sum;
        		}
        		if (target == sum) {
        			return sum;
        		} else if (sum > target) {
        			end--;
        		} else {
        			start++;
        		}
        	}
        }
        return val;
    }
}
