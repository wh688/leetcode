package twoSum;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number. 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based. 
 * You may assume that each input would have exactly one solution. 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * @author HWT
 *
 */
public class Solution {
	public int[] twoSum (int[] numbers, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
		for (int i = 0; i < numbers.length; i++) {
			// if the number not in the hm, put its target - number into hm, 
			// and set the value to the index of the number;
			// if the number is in the hm, it means the target - number appear before,
			// and its index is the value of the number.
			if (hm.containsKey(numbers[i])) {
				result[0] = hm.get(numbers[i]) + 1;
				result[1] = i + 1;
			} else {
				hm.put(target - numbers[i], i);
			}
		}
		return result;
		
	}
}
