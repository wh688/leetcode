package palindromeNumber;
/*
Determine whether an integer is a palindrome. Do this without extra space.
*/
public class Solution {
	public boolean isPalindrome(int x) {
        if (x < 0) {
        	return false;
        } else {
        	return x == reverse(x);
        }
    }
	public int reverse(int x) {
		int result = 0;
		while(x > 0) {
			result = x % 10 + result * 10;
			x = x / 10;
		}
		return result;
	}
}
