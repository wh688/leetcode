package PalindromePartitioning;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		
	}

	public static boolean isPalindrome(String s) {
		return (new StringBuilder(s).reverse().toString()).equals(s) ? true : false;
	}
}