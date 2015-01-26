package InsertInterval;

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
    static public void main (String[] args) {
	ArrayList<Interval> intervals = new ArrayList<Interval>();
	Interval interval = new Interval(1,5);
	intervals.add(interval);
	Interval newInterval = new Interval(0,0);
	ArrayList<Interval> newintervals = insert(intervals, newInterval);
	for (Interval in : newintervals) {
	    System.out.println(in.start + " " + in.end);
	}	
    }
    
    static public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	if(newInterval == null) {
	    return intervals;
	}
	ArrayList<Interval> result = new ArrayList<Interval>();
	if(intervals == null || intervals.size() == 0) {
	    result.add(newInterval);
	    return result;
	}
	intervals.add(newInterval);
	Collections.sort(intervals, new IntervalComparator());
	Interval last = intervals.get(0);
	for (int i = 0; i < intervals.size(); i++) {
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

    static private class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval o1, Interval o2) {
	    return o1.start - o2.start;
	}
    }
}
