package grayCode;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
A gray code sequence must begin with 0.
*/

import java.util.*;

public class Solution {
	public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
        	ArrayList<Integer> result = new ArrayList<Integer> ();
        	result.add(0);
        	return result;
        }
        ArrayList<Integer> result = grayCode(n - 1);
        int addNum = 1 << (n - 1);
        for (int i = result.size() - 1; i >= 0; i--) {
        	result.add(addNum + result.get(i));
        }
        return result;
    }
}
