package implementstrStr;

/*
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
	public int strStr(String haystack, String needle) {
		if (haystack.indexOf(needle) >= 0) {
			return haystack.indexOf(needle);
		} else {
			return -1;
		}        
    }	
}
