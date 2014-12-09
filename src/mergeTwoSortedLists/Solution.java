package mergeTwoSortedLists;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakehead = new ListNode(-1);
		ListNode head = fakehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				fakehead.next = l1;
				fakehead = fakehead.next;
				l1 = l1.next;
			} else {
				fakehead.next = l2;
				fakehead = fakehead.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			fakehead.next = l1;
			fakehead = fakehead.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			fakehead.next = l2;
			fakehead = fakehead.next;
			l2 = l2.next;
		}
		return head.next;
    }
}
