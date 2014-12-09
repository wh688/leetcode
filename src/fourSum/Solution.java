package fourSum;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 * The solution set must not contain duplicate quadruplets.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>> ();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        //List<Integer> l = new List<Integer> ();
        //This is not compiled because List is an interface;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
        	for (int j = i + 1; j < num.length - 2; j++) {
        		int low = j + 1;
        		int high = num.length - 1;
        		while (low < high) {
	        		int sum = num[i] + num[j] + num[low] + num[high];
	        		if (sum == target) {
	        			ArrayList<Integer> tmp = new ArrayList<Integer> ();
	        			tmp.add(num[i]);
	        			tmp.add(num[j]);
	        			tmp.add(num[low]);
	        			tmp.add(num[high]);
	        			if (!hs.contains(tmp)) {
	        				hs.add(tmp);
	        				result.add(tmp);
	        			}
	        			low++;
	        			high--;
	        		} else if (sum < target) {
	        			low++;
	        		} else {
	        			high--;
	        		}
        		}
        	}
        }
        return result;
    }
}