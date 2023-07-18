package no23;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for(ListNode node: lists) {
            if(node != null) {
                heap.add(node);
            }
        }
        ListNode preHead = new ListNode();
        ListNode prev = preHead;
        while(!heap.isEmpty()) {
            ListNode next = heap.poll();
            prev.next = next;
            prev = prev.next;
            if(next.next != null) {
                heap.add(next.next);
            }
        }
        return preHead.next;
    }
}
