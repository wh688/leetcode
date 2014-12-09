package wordLadder;

import java.util.*;

public class Solution {
	public int ladderLength(String start, String end, Set<String> dict) {
        if (dict.size() == 0 || dict == null) {
        	return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1;
        while(!queue.isEmpty()) {
        	int count = queue.size();
        	for (int i = 0; i < count; i++) {
        		String current = queue.poll();
        		for (char c = 'a'; c <= 'z'; c++) {
	        		for (int j = 0; j < current.length(); j++) {
	        			if (c == current.charAt(j)) {
	        				continue;
	        			}
	        			String tmp = replace (current, j, c);
	        			if (tmp.equals(end)) {
	        				return length + 1;
	        			}
	        			if (dict.contains(tmp)) {
	        				queue.offer(tmp);
	        				dict.remove(tmp);
	        			}
	        		}
        		}
        	}
        	length++;
        }
        return 0;
	}
	public String replace (String s, int i, char c) {
		char[] chars = s.toCharArray();
		chars[i] = c;
		return new String(chars);
	}
}
