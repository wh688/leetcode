package sortList;

/*
Sort a linked list in O(n log n) time using constant space complexity.
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
	public ListNode findMid (ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public ListNode merge (ListNode left, ListNode right) {
		ListNode fake = new ListNode(0);
		ListNode tail = fake;
		while (left != null && right != null) {
			if (left.val < right.val) {
				tail.next = left;
				left = left.next;
			} else {
				tail.next = right;
				right = right.next;
			}
			tail = tail.next;
		}
		if (left != null) {
			tail.next = left;
		} else {
			tail.next = right;
		}
		return fake.next;
	}
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
}
