package io.broudy.leetcode.misc;

import java.util.Arrays;

/**
 * Convenience Class.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class ConvenienceUtils {
    public static void printArray(int[] array, boolean tabIt) {
        if (tabIt)
            System.out.print("\t\t");
        printArray(array);
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printListNode(ListNode head) {
        ListNode temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? ", " : ""));
            temp = temp.next;
        }
        System.out.print("]\n");
    }
}
