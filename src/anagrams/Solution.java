package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */

public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String> ();
		if (strs == null || strs.length == 0 ) {
			return result;
		}
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>> ();
    for (String str : strs) {
      char[] temp = str.toCharArray();
      Arrays.sort(temp);
      String tempstr = new String(temp);
      if (hm.containsKey(tempstr)) {
        if (hm.get(tempstr).size() == 1) {
          result.add(hm.get(tempstr).get(0));
        }
        hm.get(tempstr).add(str);
        result.add(str);
      } else {
        ArrayList<String> newAdd = new ArrayList<String> ();
        newAdd.add(str);
        hm.put(tempstr, newAdd);
      }
    }
    return result;
  }
}
