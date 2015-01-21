package SubstringwithConcatenationofAllWords;

import java.util.*;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	HashMap<String, Integer> toFind = new HashMap<String, Integer>();
	HashMap<String, Integer> found = new HashMap<String, Integer>();
	int m = L.length;
	int n = L[0].length();
	for (int i = 0; i < m; i++) {
	    if (!toFind.containsKey(L[i])) {
		toFind.put(L[i], 1);
	    } else {
		toFind.put(L[i], toFind.get(L[i]) + 1);
	    }
	}
	for (int i = 0; i <= S.length() - n * m; i++) {
	    found.clear();
	    int j;
	    for (j = 0; j < m; j++) {
		int k = i + j * n;
		String sub = S.substring(k, k + n);
		if (!toFind.containsKey(sub)) {
		    break;
		}
		if (!found.containsKey(sub)) {
		    found.put(sub, 1);
		} else {
		    found.put(sub, found.get(sub) + 1);
		}
		if (found.get(sub) > toFind.get(sub)) {
		    break;
		}
	    }
	    if (j == m) {
		result.add(i);
	    }
	}
	return result;
    }
}
