package LongestConsecutiveSequence;

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] num) {
	if (num == null || num.length == 0) {
	    return 0;
	}
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	for (int i : num) {
	    hm.put(i, 0);
	}
	int max = 1;
	for (int i : num) {
	    if (hm.get(i) == 1) {
		continue;
	    }
	    int temp = i;
	    hm.put(temp, 1);
	    int curMax = 1;
	    while (hm.containsKey(temp + 1)) {
		curMax++;
		temp++;
		hm.put(temp, 1);
	    }
	    temp = i;
	    while (hm.containsKey(temp - 1)) {
		curMax++;
		temp--;
		hm.put(temp, 1);
	    }
	    max = Math.max(curMax, max);
	}
	return max;
    }
}