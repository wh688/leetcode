package singleNumberII;
/**
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one. 
 * Note: Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * @author HWT
 *
 */
public class Solution {
	public int singleNumber (int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int result = 0;
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				bits[i] += (A[j] >> i) & 1;
				//bits[i] stores the sum of A at ith bit;
				bits[i] %= 3;
				//update bits[i] to 1 or 0, 1 if only appear once, 0 if appear 3 times;
			}
			result |= (bits[i] << i);
			//ith bit of result will be bits[i], need to left shift it to ith bit;
		}
		return result;
	}
}
