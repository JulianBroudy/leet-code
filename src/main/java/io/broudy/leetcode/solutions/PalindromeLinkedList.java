package io.broudy.leetcode.solutions;

import io.broudy.leetcode.misc.ListNode;

/**
 * 234. Palindrome Linked List
 * 
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode current = head;

        while (current != null) {
            builder.append(current.val);
            current = current.next;
        }

        String string = builder.toString();
        char[] chars = string.toCharArray();
        int length = string.length();
        int mid = length / 2;
        int left, right;

        if (length % 2 == 1) {
            left = mid;
            mid++;
            right = mid + 1;
        } else {
            left = mid;
            right = mid + 1;
        }
        left--;
        right--;

        while (left > -1) {
            if (chars[left--] != chars[right++]) {
                return false;
            }
        }
        return true;
    }
}
