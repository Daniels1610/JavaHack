package org.dagraz.LeetCode.Easy.E141;

/*
Status: Accepted
Runtime: 6ms | Beats 9%
Memory Usage: 44.37 MB | Beats 52.85%
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

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
        Set<ListNode> vmap = new HashSet<>();

        System.out.print("[ ");
        while (head != null) {
            if (vmap.contains(head)) return true;
            System.out.printf("%d ", head.val);
            vmap.add(head);
            head = head.next;
        }
        System.out.print("]\n");
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle s = new LinkedListCycle();
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


