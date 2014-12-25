package maximumGap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] num) {
        if(num == null || num.length < 2) {
        	return 0;
        }
        int min = num[0];
        int max = num[0];
        for(int i : num) {
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        }
        int gap = (int) Math.ceil((double)(max - min)/(num.length - 1));
        int[] bucketMin = new int[num.length - 1];
        int[] bucketMax = new int[num.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for(int i : num) {
        	if(i == min || i == max) {
        		continue;
        	}
        	int idx = (i - min) / gap;
        	bucketMin[idx] = Math.min(i, bucketMin[idx]);
        	bucketMax[idx] = Math.max(i, bucketMax[idx]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
        	if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE)
        		continue;
        	maxGap = Math.max(maxGap, bucketMin[i] - previous);
        	previous = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}