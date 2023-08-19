package io.broudy.leetcode.solutions;

import io.broudy.leetcode.misc.ConvenienceUtils;
import io.broudy.leetcode.misc.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">104. Maximum Depth of Binary Tree</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {


//        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root = ConvenienceUtils.buildTree(new Integer[]{3, 9, 20, 15, 7});
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }

    public static int getMaxDepth(TreeNode node, int depth) {
        if (node == null)
            return 0;
        return Math.max(getMaxDepth(node.left, depth), getMaxDepth(node.right, depth)) + 1;
    }
}
