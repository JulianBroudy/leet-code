package io.broudy.leetcode.solutions;

import io.broudy.leetcode.misc.ConvenienceUtils;
import io.broudy.leetcode.misc.TreeNode;

/**
 * <a href="https://leetcode.com/problems/leaf-similar-trees/">872. Leaf-Similar Trees</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode root1 = ConvenienceUtils.buildTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 14});
        TreeNode root2 = ConvenienceUtils.buildTree(new Integer[]{3, 5, 1, 6, 71, 4, 2, null, null, null, null, null, null, 9, 8});
//        TreeNode root1 = ConvenienceUtils.buildTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
//        TreeNode root2 = ConvenienceUtils.buildTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
//        TreeNode root1 = ConvenienceUtils.buildTree(new Integer[]{1, 2, 3});
//        TreeNode root2 = ConvenienceUtils.buildTree(new Integer[]{3, 2, 1});

        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder root1Sequence = new StringBuilder();
        StringBuilder root2Sequence = new StringBuilder();
        inOrderTraversal(root1, root1Sequence);
        inOrderTraversal(root2, root2Sequence);
        System.out.println(root1Sequence);
        System.out.println(root2Sequence);
        return root1Sequence.toString().contentEquals(root2Sequence);
    }

    public static void inOrderTraversal(TreeNode root, StringBuilder sequence) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            sequence.append(root.val).append(", ");
            return;
        }
        inOrderTraversal(root.left, sequence);
        inOrderTraversal(root.right, sequence);
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }


}
