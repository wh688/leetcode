package zigZagConversion;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
*/
public class Solution {
	public static void main (String args[]) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	
	public static String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0) {
        	return "";
        }
        if (nRows == 1) {
        	return s;
        }
        StringBuilder sb = new StringBuilder();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
        	for (int j = i; j < s.length(); j = j + size) {
        		sb = sb.append(s.charAt(j));
        		if(i != 0 && i != nRows-1 && j + size - 2 * i < s.length())  
        			sb.append(s.charAt(j + size - 2 * i));  
        	}
        }
        return sb.toString();
    }
}
