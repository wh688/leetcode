package InterleavingString;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
	int len1 = s1.length();
	int len2 = s2.length();
	if (len1 + len2 != s3.length()) {
	    return false;
	}
	boolean[][] result = new boolean[len1 + 1][len2 + 1];
	result[0][0] = true;
	for (int i = 1; i <= len1; i++) {
	    result[i][0] = result[i - 1][0]
		    && s1.charAt(i - 1) == s3.charAt(i - 1);
	}
	for (int j = 1; j <= len2; j++) {
	    result[0][j] = result[0][j - 1]
		    && s2.charAt(j - 1) == s3.charAt(j - 1);
	}
	for (int i = 1; i <= len1; i++) {
	    for (int j = 1; j <= len2; j++) {
		result[i][j] = (result[i - 1][j] && s1.charAt(i - 1) == s3
			.charAt(i + j - 1))
			|| (result[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i
				+ j - 1));
	    }
	}
	return result[len1][len2];
    }
}
