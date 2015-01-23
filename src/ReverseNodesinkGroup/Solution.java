package ReverseNodesinkGroup;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
	val = x;
	next = null;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
	if (k == 0 || k == 1) {
	    return head;
	}
	ListNode cur = head;
	int length = 0;
	while (cur != null) {
	    length++;
	    cur = cur.next;
	}
	int multi = length / k;
	if (multi == 0) {
	    return head;
	}
	ListNode preTail = null, curHead = null, curTail = null;
	ListNode preNode = null, nextNode = null;
	cur = head;
	for (int j = 0; j < multi; j++) {
	    preNode = null;
	    for (int i = 0; i < k; i++) {
		if (cur != null) {
		    nextNode = cur.next;
		    cur.next = preNode;
		    preNode = cur;
		}
		if (i == 0) {
		    curTail = cur;
		}
		if (i == (k - 1)) {
		    curHead = cur;
		}
		cur = nextNode;
	    }
	    if (preTail == null) {
		head = curHead;
	    } else {
		preTail.next = curHead;
	    }
	    preTail = curTail;
	}
	curTail.next = cur;
	return head;
    }
}
