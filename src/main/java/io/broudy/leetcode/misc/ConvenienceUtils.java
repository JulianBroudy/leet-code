package io.broudy.leetcode.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second element as the first is the root
        while (i < nodes.length) {
            TreeNode current = queue.poll();

            // Process left child
            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            // Process right child (if there is one)
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }


}
