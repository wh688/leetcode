package SwapNodesinPairs;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        head = fakeHead;
        while(fakeHead.next != null && fakeHead.next.next != null) {
        	ListNode tmp = fakeHead.next.next.next;
        	fakeHead.next.next.next = fakeHead.next;
        	fakeHead.next = fakeHead.next.next;
        	fakeHead.next.next.next = tmp;
        	fakeHead = fakeHead.next.next;
        }
        return head.next;
    }
}