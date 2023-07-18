package no19;


public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        for(int i = 0; i < n-1; i++) {
            first = first.next;
        }
        ListNode prefix = new ListNode();
        prefix.next = head;
        while(first.next != null) {
            first = first.next;
            prefix = prefix.next;
        }
        if(prefix.next == head) {
            head = head.next;
        } else {
            prefix.next = prefix.next.next;
        }
        return head;
    }
}
