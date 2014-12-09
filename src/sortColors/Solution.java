package sortColors;

/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class Solution {
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
        int nonred = 0;
        int nonblue = A.length - 1;
        while (nonred < A.length && A[nonred] == 0) {
        	nonred++;
        }
        while (nonblue >= 0 && A[nonblue] == 2) {
        	nonblue--;
        }
        int i = nonred;
        while (i <= nonblue) {
        	if (A[i] == 0) {
        		swap(A, i++, nonred++);
        	} else if (A[i] == 2) {
        		swap(A, nonblue--, i++);
        	} else {
        		i++;
        	}
        }
    }
	public void swap (int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
