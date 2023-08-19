package io.broudy.leetcode.solutions;

import io.broudy.leetcode.misc.ConvenienceUtils;
import io.broudy.leetcode.misc.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ConvenienceUtils.printListNode(head);
        ConvenienceUtils.printListNode(removeNthFromEnd(head, 2));

        ConvenienceUtils.printListNode(removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
        ConvenienceUtils.printListNode(removeNthFromEnd(new ListNode(1, new ListNode(2)), 2));
        ConvenienceUtils.printListNode(removeNthFromEnd(new ListNode(1), 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> nodes = new HashMap<>();
        int i = 1;

        ListNode temp = head;
        while (temp != null) {
            nodes.put(i++, temp);
            temp = temp.next;
        }
        int count = nodes.size();
        if (count == 1) {
            return null;
        }
        int linkFrom = count - n;
        if (linkFrom == 0) {
            head = head.next;
            return head;
        }
        int linkTo = linkFrom + 2;
        if (linkTo > count) {
            nodes.get(linkFrom).next = null;
        } else {
            nodes.get(linkFrom).next = nodes.get(linkTo);
        }
        return head;
    }
}
