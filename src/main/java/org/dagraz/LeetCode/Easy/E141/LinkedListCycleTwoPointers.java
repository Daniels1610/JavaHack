package org.dagraz.LeetCode.Easy.E141;

/*
Status: Accepted
Runtime: 0ms | Beats 100%
Memory Usage: 44.33 MB | Beats 52.85%
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LinkedListCycleTwoPointers {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode i = head, j = head;

        // System.out.print("[ ");
        while (j != null && j.next != null) {
            // System.out.printf("%d ", i.val);
            i = i.next; j = j.next.next;
            if (i == j) return true;
        }
        // System.out.print("]\n");
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycleTwoPointers s = new LinkedListCycleTwoPointers();
        ListNode tail = new ListNode(-4);
        ListNode n3 = new ListNode(0);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = tail;
        tail.next = n2;

        System.out.printf("]\nHas Cycle? %b", s.hasCycle(n1));
    }


}


