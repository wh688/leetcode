package validPalindrome;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*/

public class Solution {
    public boolean isPalindrome(String s) {
    	if (s == null || s.length() == 0) {
    		return true;
    	}
        s = s.toUpperCase();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
        	if(!isValid(s.charAt(low))) {
        		low ++;
        		continue;
        	}
        	if (!isValid(s.charAt(high))) {
        		high --;
        		continue;
        	}
        	if (s.charAt(low) == s.charAt(high)) {
        		low++;
        		high--;
        	} else {
        		return false;
        	}
        }
        return true;
    }
    public boolean isValid (char c) {
    	return Character.isDigit(c) || Character.isLetter(c);
    }
}