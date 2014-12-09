package decodeWays;
/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping: 
 * 'A' -> 1 
 * 'B' -> 2 
 * ... 
 * 'Z' -> 26 
 * Given an encoded message containing digits, determine the total number of ways to decode it. 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12). 
 * The number of ways decoding "12" is 2.
 */
public class Solution {
	public int numDecodings(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int [] results = new int [s.length() + 1];
        results[0] = 0;
        results[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
        	if (s.charAt(i - 1) != '0') {
        		results[i] = results[i - 1];
        	}
        	if ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' >= 1 
        			&& (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
        		results[i] += results[i - 2]; 
        	}
        }
		return results[s.length()];
    }
}
