package io.broudy.leetcode.solutions;

import io.broudy.leetcode.misc.ListNode;

/**
 * 2. Add Two Numbers
 * 
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode current1 = l1, current2 = l2;
        while (current1.next != null) {
            current1 = current1.next;
        }
        if (current1.val == 0) {
            return l2;
        }
        while (current2.next != null) {
            current2 = current2.next;
        }
        if (current2.val == 0) {
            return l1;
        }

        final ListNode head = new ListNode();

        ListNode current = head;
        current1 = l1;
        current2 = l2;

        int sum, newVal, carry = 0;
        while (current1 != null || current2 != null) {
            sum = (current1 != null ? current1.val : 0) + (current2 != null ? current2.val : 0) + carry;
            if (sum < 10) {
                newVal = sum;
                carry = 0;
            } else {
                newVal = sum % 10;
                carry = (sum / 10);
            }
            current.val = newVal;
            if ((current1 != null && current1.next != null) || (current2 != null && current2.next != null)) {
                current.next = new ListNode();
                current = current.next;
            }
            if (current1 != null) {
                current1 = current1.next;
            }
            if (current2 != null) {
                current2 = current2.next;
            }
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return head;
    }

}
