package RemoveDuplicatesfromSortedListII;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode helper = new ListNode(0);
        helper.next = head;
        head = helper;
        while(head.next != null && head.next.next != null) {
        	if(head.next.val == head.next.next.val) {
        		int val = head.next.val;
        		while(head.next != null && head.next.val == val) {
        			head.next = head.next.next;
        		}
        	} else {
        		head = head.next;
        	}
        }
        return helper.next;
    }
}
