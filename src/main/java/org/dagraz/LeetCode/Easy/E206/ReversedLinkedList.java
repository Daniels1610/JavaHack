package org.dagraz.LeetCode.Easy.E206;

import org.dagraz.LeetCode.Easy.E141.LinkedListCycle;

public class ReversedLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;          // Stores previous Node Object
        while (head != null) {
            ListNode next = head.next; // Stores next Node Object
            head.next = prev;          // Update current Node pointer to previous Node
            prev = head;               // Updates previous Node with Current one before next iteration
            head = next;               // Head points to next node
        }
        return prev;
    }

    private void display(ListNode head) {
        System.out.print("[ ");
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        } System.out.print("]");

    }

    public static void main(String[] args) {
        ReversedLinkedList s = new ReversedLinkedList();
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        ListNode revHead = s.reverseList(n1);
        s.display(revHead);
    }
}
