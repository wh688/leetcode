package findMinimumInRotatedSortedArrayII;

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
There are duplicates;
*/

public class Solution {
	public int findMin(int[] num) {
        int min = num[0];
        int l = 0;
        int r = num.length - 1;
        while (l < r - 1) {
        	int m = (l + r) / 2;
        	if (num[l] < num[m]) {
        		min = Math.min(min, num[l]);
        		l = m + 1;
        	} else if (num[l] > num[m]) {
        		min = Math.min(min, num[m]);
        		r = m - 1;
        	} else {
        		l ++;
        	}
        }
        min = Math.min(min, num[l]);
        min = Math.min(min, num[r]);
        return min;
    }
}
