package insertionSortList;

/*
 * Sort a linked list using insertion sort.
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode current = head;
        ListNode dummyHead = new ListNode(0);
        while (current != null) {
        	ListNode next = current.next;
        	ListNode pre = dummyHead;
        	while (pre.next != null && pre.next.val < current.val) {
        		pre = pre.next;
        	}
        	current.next = pre.next;
        	pre.next = current;
        	current = next;
        }
        return dummyHead.next;
    }
}
