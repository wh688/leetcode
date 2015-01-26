package MergeIntervals;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
	start = 0;
	end = 0;
    }

    Interval(int s, int e) {
	start = s;
	end = e;
    }
}

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	if (intervals == null || intervals.size() <= 1) {
	    return intervals;
	}
	Collections.sort(intervals, new IntervalComparator());
	ArrayList<Interval> result = new ArrayList<Interval>();
	Interval last = intervals.get(0);
	for (int i = 1; i < intervals.size(); i++) {
	    Interval curr = intervals.get(i);
	    if (curr.start <= last.end) {
		last.end = Math.max(curr.end, last.end);
	    } else {
		result.add(last);
		last = curr;
	    }
	}
	result.add(last);
	return result;
    }

    private class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval o1, Interval o2) {
	    return o1.start - o2.start;
	}
    }
}
