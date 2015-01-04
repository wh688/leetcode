package FactorialTrailingZeroes;

public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n > 1) {
        	n = n / 5;
        	result = result + n;
        }
        return result;
    }
}